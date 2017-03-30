package Domain;

/**
 * Created by Lars on 29-3-2017.
 */
public class Song extends Track {
    String album;

    public Song(String performer, String title, String url, long duration, String album) {
        super(performer, title, url, duration, album);


    }
}
