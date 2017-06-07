package Datasource;

import Domain.Playlist;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lars on 6-4-2017.
 */
public interface PlaylistInterface {

    List<Playlist> getPlaylistsByOwner(String owner);

    void changePlaylistName(String owner, String newplaylistname, String oldplaylistname);

    void deletePlaylist(String owner, String playlist) throws SQLException;

    void createNewPlaylist(String[] newPlaylistInfo);

}
