package Datasource;

import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import Domain.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lars on 6-4-2017.
 */
public interface InterfaceDAO {

    void tryLoadJdbcDriver(DatabaseProperties databaseProperties);

    Connection openConnection() throws SQLException;

    List<Playlist> clearPlaylistValues(List<Playlist> list, String owner);

    List<Track> clearTrackValues(List<Track> list);

    PreparedStatement statementSetString(String[] sqlvariables, PreparedStatement statement) throws SQLException;

    void raiseError(SQLException e);

    void AddNewTrackToPlayList(String trackname, String performer, String playlist);

    void changePlaylistName(String newplaylistname, String oldplaylistname);

    void deletePlaylist(String owner, String playlist) throws SQLException;

    void createNewPlaylist(String[] newPlaylistInfo);

    List<Track> getTracks() throws SQLException;

    void deleteTrackFromPlaylist(String track, String performer, String playlist) throws SQLException;

    List<Track> getTracksByName(String name) throws SQLException;

    void changeAvailability(String tracktitle, String trackperformer, String isOffline, String playlist) throws SQLException;

    boolean checkForLoginData(String user, String pass);

    boolean retrieveLogin(PreparedStatement statement) throws SQLException;

    void retrievePlaylists(PreparedStatement statement, String owner) throws SQLException;

    List<Track> getTracksByPlaylist(String playlist);

}
