package Domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Video extends Track implements Serializable{

    public Video(){}
    public Video(String performer, String title, String url, long duration,int playcount, Date publication_date, String description) {
        super(performer, title, url, duration, playcount, publication_date, description);
    }
}
