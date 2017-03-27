package Spotitube;

import Datasource.PlaylistDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import Model.PlaylistModel;
import Model.TrackModel;

import java.util.ArrayList;

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
