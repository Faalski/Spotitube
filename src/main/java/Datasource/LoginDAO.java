package Datasource;

import Datasource.Util.DatabaseProperties;
import Domain.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dimitri on 4-4-17.
 */
public class LoginDAO extends MainDAO implements InterfaceDAO{

    public LoginDAO(DatabaseProperties databaseProperties) {
        super(databaseProperties);
    }

    public boolean checkForLoginData(String user, String pass){
        String[] sqlvariables = {user, pass};
        boolean temp = false;
        try {
            Connection connection = openConnection();
            final String sql = "SELECT user,pass FROM Login WHERE user = ? AND pass = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement = statementSetString(sqlvariables, statement );
            temp = retrieveLogin(statement);
            closeConnection(statement, connection);
        } catch (SQLException e) {
            raiseError(e);
        }
        return temp;
    }

    public boolean retrieveLogin(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
}
