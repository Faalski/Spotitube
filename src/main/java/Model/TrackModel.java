package Model;

import Domain.Track;
import Service.TrackService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lars on 24-3-2017.
 */
public class TrackModel {
    String playlist;
    String performer;
    String title;
    String url;
    long duration;

    public List<TrackModel> getTracksFromPlaylist(String playlist) {
        TrackService ts = new TrackService();
        List<Track> serviceTracks = ts.getTrackFromPlaylist(playlist);
        List<TrackModel> trackModels = new ArrayList<TrackModel>();

        for (Track track: serviceTracks) {
            TrackModel tm = new TrackModel();
            tm.setPlaylist(track.playlist);
            tm.setPerformer(track.performer);
            tm.setTitle(track.title);
            tm.setUrl(track.url);
            tm.setDuration(track.duration);
            System.out.println(tm.getPerformer());
            trackModels.add(tm);
        }
        return trackModels;
    }

    public List<TrackModel> getAllTracks(){
        TrackService ts = new TrackService();
        List<Track> serviceTrack = ts.getAllTracks();
        List<TrackModel> trackModels = new ArrayList<TrackModel>();

        for(Track track: serviceTrack){
            TrackModel tm = new TrackModel();
            tm.setPlaylist(track.playlist);
            tm.setPerformer(track.performer);
            tm.setTitle(track.title);
            tm.setUrl(track.url);
            tm.setDuration(track.duration);
            System.out.println(tm.getPerformer());
            trackModels.add(tm);
        }
        return trackModels;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getPerformer() {
        return performer;
    }
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public long getDuration() {
        return duration;
    }
}
