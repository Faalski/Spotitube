package Presentation;

import Domain.Playlist;
import Domain.Track;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Lars on 3-4-2017.
 */
public interface ControllerHelper {

    public List<Track> clearTrackValues(List<Track> list, String playlist);

}
