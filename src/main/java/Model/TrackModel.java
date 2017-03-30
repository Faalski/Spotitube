package Model;

import Domain.Song;
import Domain.Track;
import Domain.Video;
import Service.TrackService;

import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lars on 24-3-2017.
 */
public class TrackModel {
    String performer;
    String title;
    String url;
    long duration;
    TrackService ts = new TrackService();
    List<TrackModel> trackModels = new ArrayList<TrackModel>();

    public List<TrackModel> getTracksFromPlaylist(String playlist) {
        List<Track> serviceTracks = ts.getTracksFromPlaylist(playlist);
        fillTracks(serviceTracks);
        return trackModels;
    }

    public List<TrackModel> getTracks() throws SQLException {
        List<Track> serviceTracks = ts.getTracks();
        fillTracks(serviceTracks);
        return trackModels;
    }

    private void fillTracks(List<Track> serviceTracks) {
        for (Track t: serviceTracks) {

            if(t instanceof Song) {
                fillSong(t);

            }
            else if (t instanceof Video) {
                fillVideo(t);
            }
        }
    }

    public void fillSong(Track t) {
        TrackModel sm = new SongModel();
        sm.setPerformer(t.performer);
        sm.setTitle(t.title);
        sm.setUrl(t.url);
        sm.setDuration(t.duration);
        sm.setAlbum(t.album);
        trackModels.add(sm);
    }

    public void fillVideo(Track t) {
        TrackModel vm = new VideoModel();
        vm.setPerformer(t.performer);
        vm.setTitle(t.title);
        vm.setUrl(t.url);
        vm.setDuration(t.duration);
        vm.setPlaycount(t.playcount);
        vm.setPublication_date(t.publication_date);
        vm.setDescription(t.description);
        trackModels.add(vm);
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
    public void setAlbum(String album) {}
    public void setPlaycount(int playcount) {}
    public void setPublication_date(Date publication_date) {}
    public void setDescription(String description) {}

    public String getPerformer() {
        return performer;
    }
    public String getTitle() {return title;}
    public String getUrl() {return url;}
    public long getDuration() {return duration;}
    public String getAlbum() {return "";}
    public int getPlaycount() {return 0;}
    public Date getPublication_date() {return new Date();}
    public String getDescription() {return "";}



}
