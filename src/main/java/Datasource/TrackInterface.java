package Datasource;

import Domain.Track;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lars on 6-4-2017.
 */
public interface TrackInterface {

    void AddNewTrackToPlayList(String trackname, String performer, String playlist);

    List<Track> getTracks() throws SQLException;

    void deleteTrackFromPlaylist(String track, String performer, String playlist) throws SQLException;

    List<Track> getTracksByName(String name) throws SQLException;

    void changeAvailability(String tracktitle, String trackperformer, String isOffline, String playlist) throws SQLException;

    List<Track> getTracksByPlaylist(String playlist);

}
