package Service;

import Datasource.LoginDAO;
import Datasource.Util.DatabaseProperties;

/**
 * Created by dimitri on 4-4-17.
 */
public class LoginService {
    LoginDAO ld = new LoginDAO(new DatabaseProperties());

    public LoginService(){

    }

    public boolean checkLoginData(String user, String pass){
        return ld.checkForLoginData(user, pass);
    }
}
