package Datasource.JDBC.Util;

import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties{
    private Properties properties;

    public DatabaseProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String driver()
    {
        return properties.getProperty("driver");
    }

    public String connectionString()
    {
        return properties.getProperty("connectionString");
    }

}
