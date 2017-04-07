package Datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import Model.PlaylistModel;

public class PlaylistDAO extends MainDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

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
            raiseError(e);
        }
        return playlists;
    }
    @Override
    public void retrievePlaylists(PreparedStatement statement, String owner) throws SQLException {
        playlists = clearPlaylistValues(playlists, owner);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Playlist playlist = new Playlist(owner, resultSet.getString("name"));
            playlists.add(playlist);
        }
    }
    @Override
    public void changePlaylistName(String newplaylistname, String oldplaylistname) {
        String[] sqlvariables = {newplaylistname, oldplaylistname,};
        try {
            Connection connection = openConnection();
            final String sql = "UPDATE Playlist SET name = ? WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement );
            statement.executeUpdate();
            closeConnection(statement, connection);
        } catch (SQLException e) {
            raiseError(e);
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
            raiseError(e);
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
            raiseError(e);
        }
    }

    @Override
    public void AddNewTrackToPlayList(String trackname, String performer, String playlist){
        String[] sqlvariables = {trackname, performer, playlist};
        try{
            Connection connection = openConnection();
            final String sql = "INSERT INTO TrackInPlaylist VALUES(?,?,?, false)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement);
            statement.executeUpdate();
            closeConnection(statement, connection);
        } catch (SQLException e){
            raiseError(e);
        }
    }
}
