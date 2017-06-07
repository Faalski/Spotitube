package Datasource.Hibernate;

import Datasource.Hibernate.Util.HibernateUtil;
import Datasource.LoginInterface;
import Domain.Login;
import Domain.Track;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginHibernate implements LoginInterface {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    public void add(Login newEntity) {
        session.beginTransaction();
        session.persist(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public boolean checkForLoginData(String user, String pass) {
        Query query = session.createQuery("FROM Login WHERE user = :user AND pass = :pass");
        query.setParameter("user", user);
        query.setParameter("pass", pass);
        if(query.list().size() != 0){
            return true;
        } else {
            return false;
        }
    }
}
