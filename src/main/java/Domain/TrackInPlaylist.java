package Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TrackInPlaylist implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String track;
    private String performer;
    private String playlist;
    private boolean offlineAvailable;

    public void setOfflineAvailable(String offlineAvailable) {
        if(offlineAvailable.equalsIgnoreCase("true")){
            this.offlineAvailable = true;
        } else {
            this.offlineAvailable = false;
        }

    }

    public String getTrack() {
        return track;
    }

    public TrackInPlaylist(){}
    public TrackInPlaylist(String track, String performer, String playlist){
        this.track = track;
        this. performer = performer;
        this.playlist = playlist;
        this.offlineAvailable = false;
    }
}
