package Model;

import Service.LoginService;

public class LoginModel {
    LoginService ls = new LoginService();

    public LoginModel(){

    }

    public boolean checkForData(String user, String pass){
        return ls.checkLoginData(user,pass);
    }
}
