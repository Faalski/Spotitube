package Datasource.JDBC;

import Datasource.JDBC.Util.DatabaseProperties;
import Domain.Playlist;
import Domain.Track;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainDAO {
    private final DatabaseProperties databaseproperties;
    List<Track> tracks = new ArrayList<Track>();
    List<Playlist> playlists = new ArrayList<Playlist>();

    @Inject
    public MainDAO(DatabaseProperties databaseProperties) {
        this.databaseproperties = databaseProperties;
        tryLoadJdbcDriver(databaseProperties);
    }

    public void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public Connection openConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(databaseproperties.connectionString());
        return connection;
    }

    public List<Playlist> clearPlaylistValues(List<Playlist> list, String owner) {
        Iterator<Playlist> it = list.iterator();
        while (it.hasNext()) {
            Playlist p = it.next();
            if (p.getOwner().equals(owner)) {
                it.remove();
            }
        }
        return list;
    }

    public List<Track> clearTrackValues(List<Track> list) {
        Iterator<Track> it = list.iterator();
        while (it.hasNext()) {
            Track t = it.next();
            it.remove();
        }
        return list;
    }

    public PreparedStatement statementSetString(String[] sqlvariables, PreparedStatement statement) throws SQLException {
        if (sqlvariables != null) {
            for (int i=0; i < sqlvariables.length; i++) {
                if(sqlvariables[i].equals("true")) {
                    statement.setBoolean(i+1, true);
                }
                else if (sqlvariables[i].equals("false")) {
                    statement.setBoolean(i+1, false);
                }
                else {
                    statement.setString(i+1, sqlvariables[i]);
                }

            }
        }
        return statement;
    }

    public void closeConnection(PreparedStatement statement, Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }
}

