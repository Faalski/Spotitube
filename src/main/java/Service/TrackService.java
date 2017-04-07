package Service;

import Datasource.MainDAO;
import Datasource.TrackDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Track;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lars on 24-3-2017.
 */
public class TrackService {
    MainDAO trackDAO;
    List<Track> tracks;
    public TrackService() {
        trackDAO = new TrackDAO(new DatabaseProperties());
    }

    public List<Track> getTracksFromPlaylist(String playlist) {
        tracks = trackDAO.getTracksByPlaylist(playlist);
        return tracks;
    }

    public List<Track> getTracks() throws SQLException {
        tracks = trackDAO.getTracks();
        return tracks;
    }

    public void deleteTrackFromPlaylist(String title, String performer, String playlist) {
        try {
            trackDAO.deleteTrackFromPlaylist(title, performer, playlist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Track> getTracksByName(String name) throws SQLException {
        tracks = trackDAO.getTracksByName(name);
        return tracks;
    }

    public void changeAvailability(String tracktitle, String trackperformer, String isOffline, String playlist) throws SQLException {
        trackDAO.changeAvailability(tracktitle, trackperformer, isOffline, playlist);

    }
}
