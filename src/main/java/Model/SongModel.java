package Model;

import Domain.Track;

/**
 * Created by Lars on 29-3-2017.
 */
public class SongModel extends TrackModel {
    String album;

    public SongModel() {}
    @Override
    public void setAlbum(String album) {
        this.album = album;
    }
    @Override
    public String getAlbum() {
        return album;
    }
    @Override
    public String getPerformer() {
        return performer;
    }

}
