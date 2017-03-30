package Datasource;

import Datasource.Util.DatabaseProperties;
import Domain.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Lars on 24-3-2017.
 */
public class TrackDAO {
    List<Track> tracks = new ArrayList<Track>();
    private Logger logger = Logger.getLogger(getClass().getName());
    private final DatabaseProperties databaseproperties;


    public TrackDAO(DatabaseProperties databaseProperties) {
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

    public List<Track> getTracksByPlaylist(String playlist) {

        try {
            Connection connection = DriverManager.getConnection(databaseproperties.connectionString());
            final String sql = "SELECT performer, title, url, duration FROM Track WHERE playlist = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, playlist);
            retrieveTracks(statement, playlist);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseproperties.connectionString(), e);
        }

        return tracks;
    }

    private void retrieveTracks(PreparedStatement statement, String playlist) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Track track = new Track(resultSet.getString("performer"), resultSet.getString("title"), resultSet.getString("url"), resultSet.getLong("duration"), playlist);
            tracks.add(track);
        }
    }

    public List<Track> getAllTracks(){
        List<Track> tempTrack = new ArrayList<Track>();
        try {
            Connection connection = DriverManager.getConnection(databaseproperties.connectionString());
            final String sql = "SELECT performer, title, url, duration FROM Track";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Track track = new Track(resultSet.getString("performer"), resultSet.getString("title"), resultSet.getString("url"), resultSet.getLong("duration"), "owner");
                tempTrack.add(track);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseproperties.connectionString(), e);
        }
        return tempTrack;
    }


}
