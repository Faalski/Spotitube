package Datasource.JDBC;

import java.sql.*;
import java.util.List;

import Datasource.JDBC.Util.DatabaseProperties;
import Datasource.PlaylistInterface;
import Domain.Playlist;
import com.google.inject.Inject;

public class PlaylistDAO extends MainDAO implements PlaylistInterface {

    @Inject
    public PlaylistDAO(DatabaseProperties databaseProperties) {
        super(databaseProperties);
    }

    @Override
    public List<Playlist> getPlaylistsByOwner(String owner) {
        String[] sqlvariables = {owner};
        try {
            Connection connection = openConnection();
            final String sql = "SELECT name FROM Playlist WHERE owner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement);
            retrievePlaylists(statement, owner);
            closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return playlists;
    }

    public void retrievePlaylists(PreparedStatement statement, String owner) throws SQLException {
        playlists = clearPlaylistValues(playlists, owner);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Playlist playlist = new Playlist(owner, resultSet.getString("name"));
            playlists.add(playlist);
        }
    }

    @Override
    public void changePlaylistName(String owner, String newplaylistname, String oldplaylistname) {
        String[] sqlvariables = {newplaylistname, newplaylistname, oldplaylistname, oldplaylistname};
        try {
            Connection connection = openConnection();
            final String sql = "UPDATE Playlist p, TrackInPlaylist tip SET p.name = ?, tip.playlist = ? WHERE p.name = ? AND tip.playlist = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement );
            statement.executeUpdate();
            closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void deletePlaylist(String owner, String playlist) throws SQLException {
        String[] sqlvariables = {owner, playlist};
        try {
            Connection connection = openConnection();
            final String sql = "DELETE FROM Playlist WHERE owner = ? AND name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement);
            statement.executeUpdate();
            closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void createNewPlaylist(String[] newPlaylistInfo) {
        String[] sqlvariables = newPlaylistInfo;
        try {
            Connection connection = openConnection();
            final String sql = "INSERT INTO Playlist(owner, name) VALUES(?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement);
            statement.executeUpdate();
            closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
