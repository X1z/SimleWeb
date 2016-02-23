package database.connection;

import java.util.ResourceBundle;

/**
 * Created by X1z on 22.02.2016.
 */
public class DBPropertyManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private DBPropertyManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
