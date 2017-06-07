package Datasource;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface LoginInterface {

    boolean checkForLoginData(String user, String pass);

}
