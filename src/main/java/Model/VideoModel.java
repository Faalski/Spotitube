package Model;

import java.util.Date;

/**
 * Created by Lars on 29-3-2017.
 */
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
}
