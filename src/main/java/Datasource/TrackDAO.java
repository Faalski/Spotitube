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

    public List<Track> getTracks() throws SQLException {
        try{
            final String sql = "SELECT t.performer, t.title, t.url, t.duration, t.soort, t.album, t.playcount, t.publicationdate, t.description FROM Track t INNER JOIN TrackInPlaylist tip ON t.title = tip.track AND t.performer = tip.performer";
            retrieveTracksFromDatabase(sql, null);
        } catch (SQLException e) {
            raiseError(e);
        }
        
        return tracks;
    }

    public List<Track> getTracksByPlaylist(String playlist) {
        String [] sqlvariables = {playlist};
        try {

            final String sql = "SELECT t.performer, t.title, t.url, t.duration, t.soort, t.album, t.playcount, t.publicationdate, t.description FROM Track t INNER JOIN TrackInPlaylist tip ON t.title = tip.track AND t.performer = tip.performer WHERE tip.playlist = ?";
            retrieveTracksFromDatabase(sql, sqlvariables);
        } catch (SQLException e) {
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
