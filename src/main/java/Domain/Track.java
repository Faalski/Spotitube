package Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Track extends IsOfflineAvailable implements Serializable{

    public String performer;
    public String title;
    public String url;
    public long duration;
    public String album;
    public int playcount;
    public Date publication_date = new Date();
    public String description;

    public Track(){}
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

}
