package Spotitube;

import Datasource.Hibernate.LoginHibernate;
import Datasource.Hibernate.TrackHibernate;
import Domain.Login;
import Domain.Song;
import Domain.Track;

/**
 * Created by dimitri on 6-6-17.
 */
public class DummyData {

    public static void main(String [] args)
    {
        TrackHibernate trackHibernate = new TrackHibernate();
        Track track1 = new Song("Kendrick lamar", "HUMBLE.", "http://", 1000, "DAMN.");
        Track track2 = new Song("Kendrick lamar", "DNA.", "http://", 1000, "DAMN.");

        trackHibernate.add(track1);
        trackHibernate.add(track2);

        LoginHibernate loginHibernate = new LoginHibernate();
        Login login = new Login("dimitri","dimitri");
        loginHibernate.add(login);
    }
}
