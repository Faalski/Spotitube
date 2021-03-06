package Model;

import Domain.Playlist;
import Service.PlaylistService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistModel {
    String owner;
    String name;
    PlaylistService ps = new PlaylistService();

    public List<PlaylistModel> getAllPlaylists(String owner) {
        List<Playlist> serviceplaylists = ps.getAllPlaylists(owner);
        List<PlaylistModel> playlistModels = new ArrayList<PlaylistModel>();

        for (Playlist p: serviceplaylists) {
            PlaylistModel playlistmodel = new PlaylistModel();
            playlistmodel.setOwner(p.owner);
            playlistmodel.setName(p.name);
            playlistModels.add(playlistmodel);
        }
        return playlistModels;
    }


    public void changePlaylistName(String newplaylistname, String oldplaylistname) {
        ps.changePlaylistName(newplaylistname, oldplaylistname);
    }
    public void deletePlaylist(String owner, String playlist) throws SQLException {
        ps.deletePlaylist(owner, playlist);
    }
    public void createNewPlaylist(String[] newPlaylistInfo) {
        ps.createNewPlaylist(newPlaylistInfo);
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOwner() { return owner;}

}
