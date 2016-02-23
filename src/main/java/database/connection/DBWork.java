package database.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static database.connection.DBPropertyManager.*;

/**
 * Created by X1z on 22.02.2016.
 */
public class DBWork {

    private static DBWork ourInstance = new DBWork();
    private final String URL = getProperty("db.url");
    private final String PASS = getProperty("db.login");
    private final String LOGIN = getProperty("db.password");
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public static DBWork getInstance() {
        return ourInstance;
    }

    private DBWork() {
        init();
    }

    private void init(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,LOGIN,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
