package Service;

import Datasource.PlaylistDAO;
import Datasource.TrackDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import Domain.Track;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lars on 21-3-2017.
 */
@Path("/Playlists")
@Singleton
public class PlaylistService {
    List<Playlist> playlists;
    PlaylistDAO playlistDAO = new PlaylistDAO(new DatabaseProperties());

    public PlaylistService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getAllPlaylists(String owner) {
        playlists = playlistDAO.getPlaylistsByOwner(owner);
        return playlists;
    }


    public void changePlaylistName(String newplaylistname, String oldplaylistname) {
        playlistDAO.changePlaylistName(newplaylistname, oldplaylistname);
    }
}