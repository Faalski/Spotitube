package Spotitube;

import Datasource.*;
import Datasource.Hibernate.LoginHibernate;
import Datasource.Hibernate.PlaylistHibernate;
import Datasource.Hibernate.TrackHibernate;
import Datasource.JDBC.LoginDAO;
import Datasource.JDBC.MainDAO;
import Datasource.JDBC.PlaylistDAO;
import Datasource.JDBC.TrackDAO;
import com.google.inject.AbstractModule;

public class DataSourceGuiceModule extends AbstractModule {

    @Override
    public void configure(){
        bind(LoginInterface.class).to(LoginDAO.class);
        bind(PlaylistInterface.class).to(PlaylistDAO.class);
        bind(TrackInterface.class).to(TrackDAO.class);
    }
}
