package Model;

import Domain.Song;
import Domain.Track;
import Domain.Video;
import Service.TrackService;

import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TrackModel extends IsOfflineAvailableModel {
    String performer;
    String title;
    String url;
    long duration;
    TrackService ts = new TrackService();
    List<TrackModel> trackModels = new ArrayList<TrackModel>();
    List<Track> serviceTracks = new ArrayList<Track>();

    public List<TrackModel> getTracksFromPlaylist(String playlist) {
        trackModels.clear();
        serviceTracks = ts.getTracksFromPlaylist(playlist);
        fillTracks(serviceTracks);
        return trackModels;
    }

    public List<TrackModel> getTracks() throws SQLException {
        trackModels.clear();
        serviceTracks = ts.getTracks();
        fillTracks(serviceTracks);
        return trackModels;
    }

    public List<TrackModel> getTracksByName(String name) throws SQLException {
        trackModels.clear();
        serviceTracks = ts.getTracksByName(name);
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
        sm.setOfflineAvailable(t.isOfflineAvailable());
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
        vm.setOfflineAvailable(t.isOfflineAvailable());
        trackModels.add(vm);
    }
    public void deleteTrackFromPlaylist(String title, String performer, String playlist) {
        ts.deleteTrackFromPlaylist(title, performer, playlist);
    }
    public void changeAvailability(TrackModel tm, String playlist) throws SQLException {
        String tracktitle;
        String trackperformer;
        String isOffline;
        tm.toggle();
        tracktitle = tm.getTitle();
        trackperformer = tm.getPerformer();
        if(tm.isOfflineAvailable()) {
            isOffline = "true";
        }
        else {
            isOffline = "false";
        }
        ts.changeAvailability(tracktitle, trackperformer, isOffline, playlist);

    }

    public void AddTrackToPlayList(String trackname, String performer, String playlist) throws SQLException {
        ts.AddTrackToPlayList(trackname, performer, playlist);
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
    public Date getPublication_date() {return null;}
    public String getDescription() {return "";}
    public boolean getOfflineAvailable() {
        return isOfflineAvailable();
    }
    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }






}
