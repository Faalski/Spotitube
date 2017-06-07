package Datasource.Hibernate;

import Datasource.Hibernate.Util.HibernateUtil;
import Datasource.PlaylistInterface;
import Domain.Playlist;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlaylistHibernate implements PlaylistInterface {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public List<Playlist> getPlaylistsByOwner(String owner) {
        Query query = session.createQuery("FROM Playlist WHERE owner = :owner");
        query.setParameter("owner", owner);
        return query.list();
    }

    @Override
    public void changePlaylistName(String owner, String newplaylistname, String oldplaylistname) {
        List<Playlist> playlists = getPlaylistsByOwner(owner);
        for(Playlist playlist : playlists){
            if(playlist.getName().equalsIgnoreCase(oldplaylistname)){
                Playlist toUpdatePlaylist = playlist;
                toUpdatePlaylist.setName(newplaylistname);
                session.beginTransaction();
                session.update(toUpdatePlaylist);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public void deletePlaylist(String owner, String playlist) throws SQLException {
        List<Playlist> playlists = getPlaylistsByOwner(owner);
        for(Playlist currentPlaylist : playlists){
            if(currentPlaylist.getName().equalsIgnoreCase(playlist)){
                session.beginTransaction();
                session.delete(currentPlaylist);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public void createNewPlaylist(String[] newPlaylistInfo) {
        session.beginTransaction();
        session.persist(new Playlist(newPlaylistInfo[0], newPlaylistInfo[1]));
        session.getTransaction().commit();
    }
}
