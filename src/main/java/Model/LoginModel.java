package Model;

import Service.LoginService;
import Spotitube.DataSourceGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class LoginModel {
    LoginService ls;

    public LoginModel(){
        Injector injector = Guice.createInjector(new DataSourceGuiceModule());
        ls = injector.getInstance(LoginService.class);
    }

    public boolean checkForData(String user, String pass){
        return ls.checkLoginData(user,pass);
    }
}
