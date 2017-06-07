package Service;

import Datasource.TrackInterface;
import Domain.Track;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/tracks")
@Singleton
public class TrackService {
    private TrackInterface trackDAO;
    List<Track> tracks;

    @Inject
    public TrackService(TrackInterface trackInterface){
        this.trackDAO = trackInterface;
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
        try{
            trackDAO.deleteTrackFromPlaylist(title, performer, playlist);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Path("/trackbyname/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracksByName(@PathParam("id")String name) throws SQLException {
        tracks = trackDAO.getTracksByName(name);
        return tracks;
    }

    public void changeAvailability(String tracktitle, String trackperformer, String isOffline, String playlist) throws SQLException {
        trackDAO.changeAvailability(tracktitle, trackperformer, isOffline, playlist);
    }

    public void AddTrackToPlayList(String trackname, String performer, String playlist){
        trackDAO.AddNewTrackToPlayList(trackname, performer, playlist);
    }
}
