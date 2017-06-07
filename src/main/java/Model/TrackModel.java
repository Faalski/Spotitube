package Model;

import Domain.Song;
import Domain.Track;
import Domain.Video;
import Service.TrackService;
import Spotitube.DataSourceGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TrackModel extends Domain.IsOfflineAvailable{
    String performer;
    String title;
    String url;
    long duration;
    TrackService ts;
    List<TrackModel> trackModels = new ArrayList<TrackModel>();
    List<Track> serviceTracks = new ArrayList<Track>();

    public TrackModel(){
        Injector injector = Guice.createInjector(new DataSourceGuiceModule());
        ts = injector.getInstance(TrackService.class);
    }

    public List<TrackModel> getTracksFromPlaylist(String playlist) {
        trackModels.clear();
        serviceTracks = ts.getTracksFromPlaylist(playlist);
        fillTracks(serviceTracks);
        return trackModels;
    }

    public List<TrackModel> getTracks(){
        trackModels.clear();
        try{
            serviceTracks = ts.getTracks();
        }catch(SQLException e){
            System.out.println(e);
        }
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
        SongModel sm = new SongModel();
        VideoModel vm = new VideoModel();
        for (Track t: serviceTracks) {
            if(t instanceof Song) {
                trackModels.add(sm.fillSong(t));
            }
            else if (t instanceof Video) {
                trackModels.add(vm.fillVideo(t));
            }
        }
    }

    public void deleteTrackFromPlaylist(String title, String performer, String playlist) {
        ts.deleteTrackFromPlaylist(title, performer, playlist);
    }
    public void changeAvailability(TrackModel tm, String playlist) throws SQLException {
        String tracktitle;
        String trackperformer;
        tracktitle = tm.getTitle();
        trackperformer = tm.getPerformer();
        String isOffline;
        if(this.isOfflineAvailable()) {
            toggle(true);
            isOffline = "true";
        }
        else {
            toggle(false);
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
    public void setOfflineAvailable(boolean isOfflineAvailable){
        toggle(isOfflineAvailable);
    }
}
