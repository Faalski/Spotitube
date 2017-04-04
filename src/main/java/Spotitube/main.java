package Spotitube;

import Datasource.PlaylistDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import Domain.Track;
import Model.PlaylistModel;
import Model.TrackModel;
import Service.TrackService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lars on 20-3-2017.
 */
public class main {
    public static void main(String[] args) {
        String owner = "harry";
        //PlaylistModel pm = new PlaylistModel();
        TrackModel tm = new TrackModel();
        tm.getTracksFromPlaylist("de harrylijstdeel2");
        //pm.getAllPlaylists(owner);
    }
}
