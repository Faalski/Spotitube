package Datasource.JDBC;

import Datasource.JDBC.Util.DatabaseProperties;
import Datasource.LoginInterface;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends MainDAO implements LoginInterface {

    @Inject
    public LoginDAO(DatabaseProperties databaseProperties) {
        super(databaseProperties);
    }

    @Override
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
            System.out.println(e);
        }
        return temp;
    }

    public boolean retrieveLogin(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
}
