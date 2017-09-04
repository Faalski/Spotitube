package Datasource.Hibernate;

import Datasource.Hibernate.Util.HibernateUtil;
import Domain.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ItemHibernate implements Datasource.IitemHibernate {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void add(Item newEntity) {
        session.beginTransaction();
        session.persist(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public void update(Item newEntity) throws SQLException {
        session.beginTransaction();
        session.update(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Item newEntity) throws SQLException {
        session.beginTransaction();
        session.delete(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public List<Item> list() throws SQLException {
        Session sessionForFinding = sessionFactory.openSession();
        return sessionForFinding.createQuery("FROM Item ORDER BY name asc").list();
    }

    @Override
    public List<Item> getItemsByName(String name) throws SQLException {
        Session sessionForFinding = sessionFactory.openSession();
        return sessionForFinding.createQuery("FROM Item WHERE name LIKE :name OR code LIKE :name ORDER BY name asc").setParameter("name", "%" + name + "%").list();
    }

    @Override
    public Item find(String code) {
        return (Item) session.get(Item.class, code);
    }
}
