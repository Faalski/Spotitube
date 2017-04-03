package Datasource;

import Datasource.Util.DatabaseProperties;
import Domain.Song;
import Domain.Track;
import Domain.Video;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Lars on 24-3-2017.
 */
public class TrackDAO extends MainDAO {
    public TrackDAO(DatabaseProperties databaseProperties) {
        super(databaseProperties);

    }
    @Override
    public List<Track> getTracks() throws SQLException {
        tracks = clearTrackValues(tracks);
        try{
            final String sql = "SELECT t.performer, t.title, t.url, t.duration, t.soort, t.album, t.playcount, t.publicationdate, t.description FROM Track t";
            retrieveTracksFromDatabase(sql, null);
        } catch (SQLException e) {
            raiseError(e);
        }
        return tracks;
    }
    @Override
    public List<Track> getTracksByPlaylist(String playlist) {
        tracks = clearTrackValues(tracks);

        String [] sqlvariables = {playlist};
        try {
            final String sql = "SELECT t.performer, t.title, t.url, t.duration, t.soort, t.album, t.playcount, t.publicationdate, t.description FROM Track t INNER JOIN TrackInPlaylist tip ON t.title = tip.track AND t.performer = tip.performer WHERE tip.playlist = ?";
            retrieveTracksFromDatabase(sql, sqlvariables);
        } catch (SQLException e) {
            raiseError(e);
        }

        return tracks;
    }

    public void deleteTrackFromPlaylist(String title, String performer, String playlist)  {
        String [] sqlvariables = {title, performer, playlist};
        try {
            final String sql = "DELETE FROM TrackInPlaylist WHERE track = ? AND performer = ? AND playlist = ?";
            Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement);
            statement.executeUpdate();
            closeConnection(statement, connection);
        }catch (SQLException e) {
            raiseError(e);
        }
    }

    public List<Track> getTracksByName(String name){
        tracks = clearTrackValues(tracks);
        String [] sqlvariables = {name};
        try {
            final String sql = "SELECT performer, title, url, duration, soort, album, playcount, publicationdate, description FROM Track WHERE title LIKE '%' ? '%'";
            retrieveTracksFromDatabase(sql, sqlvariables);
        } catch(SQLException e){
            raiseError(e);
        }
        return tracks;
    }

    public void retrieveTracksFromDatabase(String sql, String[] sqlvariables) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement = statementSetString(sqlvariables, statement);
        retrieveTracks(statement);
        closeConnection(statement, connection);
    }



    private void retrieveTracks(PreparedStatement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            if (resultSet.getString("soort").equals("song")) {
                Track song = new Song(resultSet.getString("performer"), resultSet.getString("title"), resultSet.getString("url"), resultSet.getLong("duration"), resultSet.getString("album"));
                tracks.add(song);
            }
            else if (resultSet.getString("soort").equals("video")) {
                Track video = new Video(resultSet.getString("performer"), resultSet.getString("title"), resultSet.getString("url"), resultSet.getLong("duration"), resultSet.getInt("playcount"), resultSet.getDate("publicationdate"), resultSet.getString("description"));

                tracks.add(video);
            }
        }
    }


}
