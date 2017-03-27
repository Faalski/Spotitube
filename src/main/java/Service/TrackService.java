package Service;

import Datasource.TrackDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Track;

import java.util.List;

/**
 * Created by Lars on 24-3-2017.
 */
public class TrackService {
    List<Track> tracks;
    public TrackService() {

    }

    public List<Track> getTrackFromPlaylist(String playlist) {
        TrackDAO trackDAO = new TrackDAO(new DatabaseProperties());
        tracks = trackDAO.getTracksByPlaylist(playlist);
        return tracks;
    }
}
