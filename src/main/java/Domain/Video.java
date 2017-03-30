package Domain;


import java.util.Date;

/**
 * Created by Lars on 29-3-2017.
 */
public class Video extends Track{

    public Video(String performer, String title, String url, long duration,int playcount, Date publication_date, String description) {
        super(performer, title, url, duration, playcount, publication_date, description);


    }
}
