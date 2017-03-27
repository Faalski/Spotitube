package Domain;

/**
 * Created by Lars on 24-3-2017.
 */
public class Track {
    public String performer;
    public String title;
    public String url;
    public long duration;
    public String playlist;

    public Track(String performer, String title, String url, long duration, String playlist) {
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
        this.playlist = playlist;
    }
}
