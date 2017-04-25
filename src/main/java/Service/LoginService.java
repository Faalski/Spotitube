package Service;

import Datasource.LoginDAO;
import Datasource.Util.DatabaseProperties;

public class LoginService {
    LoginDAO ld = new LoginDAO(new DatabaseProperties());

    public LoginService(){

    }

    public boolean checkLoginData(String user, String pass){
        return ld.checkForLoginData(user, pass);
    }
}
