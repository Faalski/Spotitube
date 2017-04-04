package test;

import Datasource.TrackDAO;
import Datasource.Util.DatabaseProperties;
import Domain.Track;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertThat;

/**
 * Created by Lars on 3-4-2017.
 */
public class TrackDAOTest {
    List<Track> tracks;
    TrackDAO trackDAO;
    @Before
    public void setUp() throws Exception {
        TrackDAO trackDAO = new TrackDAO(new DatabaseProperties());
        List<Track> tracks = new ArrayList<Track>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTracks() throws Exception {
        tracks = trackDAO.getTracks();
        //assertThat(tracks, hasSize(5));

    }

    @Test
    public void getTracksByPlaylist() throws Exception {

    }

    @Test
    public void deleteTrackFromPlaylist() throws Exception {

    }

    @Test
    public void retrieveTracksFromDatabase() throws Exception {

    }

}