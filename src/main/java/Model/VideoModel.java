package Model;

import Domain.Track;
import java.util.Date;

public class VideoModel extends TrackModel {
    int playcount;
    Date publication_date = new Date();
    String description;
    @Override
    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }
    @Override
    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public int getPlaycount() {
        return playcount;
    }
    @Override
    public Date getPublication_date() {
        return publication_date;
    }
    @Override
    public String getDescription() {
        return description;
    }

    public TrackModel fillVideo(Track t) {
        TrackModel vm = new VideoModel();
        vm.setPerformer(t.performer);
        vm.setTitle(t.title);
        vm.setUrl(t.url);
        vm.setDuration(t.duration);
        vm.setPlaycount(t.playcount);
        vm.setPublication_date(t.publication_date);
        vm.setDescription(t.description);
        vm.setOfflineAvailable(t.isOfflineAvailable());
        return vm;
    }
}
