package Service;

import Datasource.PlaylistInterface;
import Domain.Playlist;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/playlists")
@Singleton
public class PlaylistService {
    PlaylistInterface playlistDAO;
    List<Playlist> playlists;

    @Inject
    public PlaylistService(PlaylistInterface playlistInterface) {
        this.playlistDAO = playlistInterface;
    }

    @Path("/ownername/{ownerName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getAllPlaylists(@PathParam("ownerName") String owner){
         playlists = playlistDAO.getPlaylistsByOwner(owner);
        return playlists;
    }

    public void changePlaylistName(String owner, String newplaylistname, String oldplaylistname) {
        playlistDAO.changePlaylistName(owner, newplaylistname, oldplaylistname);
    }

    public void deletePlaylist(String owner, String playlist) throws SQLException {
        playlistDAO.deletePlaylist(owner, playlist);
    }

    public void createNewPlaylist(String[] newPlaylistInfo) {
        playlistDAO.createNewPlaylist(newPlaylistInfo);
    }
}
