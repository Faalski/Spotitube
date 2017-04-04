package Model;

import Service.LoginService;

/**
 * Created by dimitri on 4-4-17.
 */
public class LoginModel {
    LoginService ls = new LoginService();

    public LoginModel(){

    }

    public boolean checkForData(String user, String pass){
        return ls.checkLoginData(user,pass);
    }
}
