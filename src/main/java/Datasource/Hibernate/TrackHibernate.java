package Datasource.Hibernate;

import Datasource.Hibernate.Util.HibernateUtil;
import Datasource.TrackInterface;
import Domain.Track;
import Domain.TrackInPlaylist;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackHibernate implements TrackInterface {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    public void add(Track newEntity) {
        session.beginTransaction();
        session.persist(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public void AddNewTrackToPlayList(String trackname, String performer, String playlist) {
        session.beginTransaction();
        session.persist(new TrackInPlaylist(trackname, performer, playlist));
        session.getTransaction().commit();
    }

    @Override
    public List<Track> getTracks() throws SQLException {
        Query query = session.createQuery("FROM IsOfflineAvailable");
        System.out.println(query.list());
        return query.list();
    }

    @Override
    public void deleteTrackFromPlaylist(String track, String performer, String playlist) throws SQLException {
        session.beginTransaction();
        session.delete(findTrackInPlaylist(track, performer, playlist).get(0));
        session.getTransaction().commit();
    }

    @Override
    public List<Track> getTracksByName(String name) throws SQLException {
        Query query = session.createQuery("FROM IsOfflineAvailable WHERE title LIKE :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    public void changeAvailability(String tracktitle, String trackperformer, String isOffline, String playlist) throws SQLException {
        TrackInPlaylist updatedTrack = findTrackInPlaylist(tracktitle,trackperformer,playlist).get(0);
        updatedTrack.setOfflineAvailable(isOffline);

        session.beginTransaction();
        session.update(updatedTrack);
        session.getTransaction().commit();
    }

    @Override
    public List<Track> getTracksByPlaylist(String playlist) {
        System.out.println("Get tracks by playlist");
        Query query = session.createQuery("FROM TrackInPlaylist WHERE playlist = :playlist");
        query.setParameter("playlist", playlist);
        List<TrackInPlaylist> trackInPlaylistList = query.list();
        System.out.println("TracksInPlaylist" + trackInPlaylistList);
        List<Track> tempTracks;
        List<Track> tracks = new ArrayList<Track>();
        for(TrackInPlaylist trackInPlaylist : trackInPlaylistList){
            Query query_track = session.createQuery("FROM IsOfflineAvailable WHERE title = :title");
            query_track.setParameter("title", trackInPlaylist.getTrack());
            tempTracks = query_track.list();
            System.out.println(tempTracks);
            for(Track track : tempTracks){
                tracks.add(track);
            }

        }
        return tracks;
    }


    public List<TrackInPlaylist> findTrackInPlaylist(String track, String performer, String playlists) throws SQLException {
        Query query = session.createQuery("FROM TrackInPlaylist WHERE track = :track AND performer = :performer AND playlist = :playlist");
        query.setParameter("track", track);
        query.setParameter("performer", performer);
        query.setParameter("playlist", playlists);
        return query.list();
    }
}
