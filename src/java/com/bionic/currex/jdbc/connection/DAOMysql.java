/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.connection;

import com.bionic.currex.jdbc.dao.user.IUserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class DAOMysql extends DAOFactory {
    
    private static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/currexdb";
    private static final String DBNAME = "root";
    private static final String DBPASS = "root";

    @Override
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, DBNAME, DBPASS);
    }
    
    @Override
    protected String getDriverClass() {
        return DRIVER_CLASS;
    }

    @Override
    public IUserDao getUserDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
