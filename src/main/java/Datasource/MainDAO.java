package Datasource;

import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import Domain.Track;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainDAO implements InterfaceDAO{
    private Logger logger = Logger.getLogger(getClass().getName());
    private final DatabaseProperties databaseproperties;
    List<Track> tracks = new ArrayList<Track>();
    List<Playlist> playlists = new ArrayList<Playlist>();

    public MainDAO(DatabaseProperties databaseProperties) {
        this.databaseproperties = databaseProperties;
        tryLoadJdbcDriver(databaseProperties);
    }

    public void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    public Connection openConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(databaseproperties.connectionString());
        return connection;
    }

    public List<Playlist> clearPlaylistValues(List<Playlist> list, String owner) {
        Iterator<Playlist> it = list.iterator();
        while (it.hasNext()) {
            Playlist p = it.next();
            if (p.getOwner().equals(owner)) {
                it.remove();
            }
        }
        return list;
    }
    public List<Track> clearTrackValues(List<Track> list) {
        Iterator<Track> it = list.iterator();
        while (it.hasNext()) {
            Track t = it.next();
            it.remove();
        }
        return list;
    }

    public PreparedStatement statementSetString(String[] sqlvariables, PreparedStatement statement) throws SQLException {
        if (sqlvariables != null) {
            for (int i=0; i < sqlvariables.length; i++) {
                if(sqlvariables[i].equals("true")) {
                    statement.setBoolean(i+1, true);
                }
                else if (sqlvariables[i].equals("false")) {
                    statement.setBoolean(i+1, false);
                }
                else {
                    statement.setString(i+1, sqlvariables[i]);
                }

            }
        }
        return statement;
    }

    public void raiseError(SQLException e) {
        logger.log(Level.SEVERE, "Error communicating with database " + databaseproperties.connectionString(), e);
    }

    public List<Playlist> getPlaylistsByOwner(String owner) {
        return playlists;
    }

    public List<Track> getTracksByPlaylist(String playlist) {
        return tracks;
    }

    public void closeConnection(PreparedStatement statement, Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }

    public void AddNewTrackToPlayList(String trackname, String performer, String playlist){
    }
    public void changePlaylistName(String newplaylistname, String oldplaylistname) {
    }
    public void deletePlaylist(String owner, String playlist) throws SQLException {
    }
    public void createNewPlaylist(String[] newPlaylistInfo) {
    }

    public List<Track> getTracks() throws SQLException {
        return tracks;
    }

    public void deleteTrackFromPlaylist(String track, String performer, String playlist) throws SQLException {
    }

    public List<Track> getTracksByName(String name) throws SQLException {
        return tracks;
    }

    public void changeAvailability(String tracktitle, String trackperformer, String isOffline, String playlist) throws SQLException {
    }

    public boolean checkForLoginData(String user, String pass) {
        return false;
    }

    public boolean retrieveLogin(PreparedStatement statement) throws SQLException {
        return false;
    }

    public void retrievePlaylists(PreparedStatement statement, String owner) throws SQLException {

    }
}

