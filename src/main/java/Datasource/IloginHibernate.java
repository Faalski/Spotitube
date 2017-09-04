package Datasource;

import Domain.Account;
import Domain.Item;

import java.sql.SQLException;
import java.util.List;

public interface IloginHibernate {
    void add(Account newEntity) throws SQLException;
    List<Account> getAccountByName(String name, String password) throws SQLException;
    List<Account> getAccountByNameOnly(String name) throws SQLException;
}
