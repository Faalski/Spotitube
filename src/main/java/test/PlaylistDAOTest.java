package test;

import Datasource.MainDAO;
import Datasource.PlaylistDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Playlist;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;

/**
 * Created by Lars on 6-4-2017.
 */
public class PlaylistDAOTest {
    MainDAO playlistDAO = new PlaylistDAO(new DatabaseProperties());
    Playlist een = new Playlist("harry", "aaa");
    Playlist twee = new Playlist("harry", "jaja");
    Playlist drie = new Playlist("harry", "kaklijst");
    Playlist vier = new Playlist("harry", "klik");
    Playlist vijf = new Playlist("harry", "Nieuw");
    Playlist zes = new Playlist("harry", "nieuwuw");
    @Test
    public void getPlaylistsByOwner() throws Exception {
        List<Playlist> testplaylists = null;
        testplaylists.add(een);
        testplaylists.add(twee);
        testplaylists.add(drie);
        testplaylists.add(vier);
        testplaylists.add(vijf);
        testplaylists.add(zes);

        List<Playlist> playlists = (playlistDAO.getPlaylistsByOwner("harry"));
        assertThat(playlists, is(testplaylists));
    }

}