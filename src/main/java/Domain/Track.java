package Domain;

import java.util.Date;

/**
 * Created by Lars on 24-3-2017.
 */
public class Track extends IsOfflineAvailable{
    public String performer;
    public String title;
    public String url;
    public long duration;
    public String album;
    public int playcount;
    public Date publication_date = new Date();
    public String description;

    public Track(String performer, String title, String url, long duration, String album) {
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
        this.album = album;

    }

    public Track(String performer, String title, String url, long duration, int playcount, Date publication_date, String description) {
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
        this.playcount = playcount;
        this.publication_date = publication_date;
        this.description = description;
    }

    public String getPerformer() {
        return performer;
    }

    @Override
    public void toggle() {
        if (offlineAvailable) {
            offlineAvailable = false;
        }
        else {
            offlineAvailable = true;
        }
    }

    @Override
    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }


    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }
}
