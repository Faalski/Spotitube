package Model;

import Domain.Track;

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

    public TrackModel fillSong(Track t) {
        TrackModel sm = new SongModel();
        sm.setPerformer(t.performer);
        sm.setTitle(t.title);
        sm.setUrl(t.url);
        sm.setDuration(t.duration);
        sm.setAlbum(t.album);
        setOfflineAvailable(t.isOfflineAvailable());
        return sm;
    }
}
