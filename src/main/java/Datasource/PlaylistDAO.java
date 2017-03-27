package Datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datasource.Util.DatabaseProperties;
import Domain.Playlist;

public class PlaylistDAO {
    List<Playlist> playlists = new ArrayList<Playlist>();
    private Logger logger = Logger.getLogger(getClass().getName());
    private final DatabaseProperties databaseproperties;

    public PlaylistDAO(DatabaseProperties databaseProperties) {
        this.databaseproperties = databaseProperties;
        tryLoadJdbcDriver(databaseProperties);
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    public List<Playlist> getPlaylistsByOwner(String owner) {

        try {
            Connection connection = DriverManager.getConnection(databaseproperties.connectionString());
            final String sql = "SELECT name FROM Playlist WHERE owner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, owner);
            retrievePlaylists(statement, owner);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseproperties.connectionString(), e);
        }
        return playlists;
    }

    private void retrievePlaylists(PreparedStatement statement, String owner) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Playlist playlist = new Playlist(owner, resultSet.getString("name"));
            playlists.add(playlist);
        }
    }

    public void changePlaylistName(String newplaylistname, String oldplaylistname) {
        try {
            Connection connection = DriverManager.getConnection(databaseproperties.connectionString());
            final String sql = "UPDATE Playlist SET name = ? WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newplaylistname);
            statement.setString(2, oldplaylistname);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseproperties.connectionString(), e);
        }
    }
}
