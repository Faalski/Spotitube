package Datasource.Hibernate;

import Datasource.Hibernate.Util.HibernateUtil;
import Domain.Account;
import Domain.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class LoginHibernate implements Datasource.IloginHibernate {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void add(Account newEntity) throws SQLException{
        session.beginTransaction();
        session.persist(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public List<Account> getAccountByName(String name, String password) throws SQLException {
        return session.createQuery("FROM Account WHERE name = :name AND password = :password").setParameter("name", name).setParameter("password", password).list();
    }

    @Override
    public List<Account> getAccountByNameOnly(String name) throws SQLException {
        return session.createQuery("FROM Account WHERE name = :name").setParameter("name", name).list();
    }
}
