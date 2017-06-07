package Service;

import Datasource.LoginInterface;

import javax.inject.Inject;

public class LoginService {
    LoginInterface loginDAO;

    @Inject
    public LoginService(LoginInterface loginDAO){
        this.loginDAO = loginDAO;
    }

    public boolean checkLoginData(String user, String pass){
        return loginDAO.checkForLoginData(user, pass);
    }
}
