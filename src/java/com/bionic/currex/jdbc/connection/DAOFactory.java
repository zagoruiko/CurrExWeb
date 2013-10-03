package com.bionic.currex.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.bionic.currex.jdbc.connection.DBTypes.MYSQL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio
 */
public abstract class DAOFactory {
    
  private static DAOBase driver = null;

    public static DAOBase createDriver(final DBTypes dbType) throws ClassNotFoundException {
        switch (dbType) {
            case MYSQL:
                driver = new DAOMysql();
                break;
            default:
                driver = new DAOMysql();
        }

        return driver;
    }

    private DAOFactory() {
    }
    
}
