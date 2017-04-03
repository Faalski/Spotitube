package Service;

import Datasource.MainDAO;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lars on 21-3-2017.
 */
public class PlaylistService {
    MainDAO playlistDAO = new PlaylistDAO(new DatabaseProperties());
    List<Playlist> playlists;
    public PlaylistService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getAllPlaylists(String owner) {
         playlists = playlistDAO.getPlaylistsByOwner(owner);
        return playlists;
    }

    public void AddTrackToPlayList(String trackname, String performer, String playlist){
        playlistDAO.AddNewTrackToPlayList(trackname, performer, playlist);
    }

    public void changePlaylistName(String newplaylistname, String oldplaylistname) {
        playlistDAO.changePlaylistName(newplaylistname, oldplaylistname);
    }

    public void deletePlaylist(String owner, String playlist) throws SQLException {
        playlistDAO.deletePlaylist(owner, playlist);
    }

    public void createNewPlaylist(String[] newPlaylistInfo) {
        playlistDAO.createNewPlaylist(newPlaylistInfo);
    }
}
