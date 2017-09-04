import Datasource.Hibernate.LoginHibernate;
import Datasource.IloginHibernate;
import Domain.Account;
public class LoginData {

    public static void main(String [] args)
    {
        Account account = new Account("vincent", "hooftman");
        IloginHibernate login = new LoginHibernate();
        try{
            login.add(account);
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
