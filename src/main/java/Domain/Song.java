package Domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Song extends Track implements Serializable{

    public Song(){}
    public Song(String performer, String title, String url, long duration, String album) {
        super(performer, title, url, duration, album);
    }
}
