package Datasource;

import Domain.Item;

import java.sql.SQLException;
import java.util.List;

public interface IitemHibernate {
    void add(Item newEntity);

    void update(Item newEntity) throws SQLException;

    void delete(Item newEntity) throws SQLException;

    List list() throws SQLException;

    List<Item> getItemsByName(String name) throws SQLException;

    Item find(String code);
}
