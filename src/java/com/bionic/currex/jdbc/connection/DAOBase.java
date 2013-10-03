/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public abstract class DAOBase {
    
    protected abstract String getDriverClass();
    
    public abstract Connection getConnection() throws SQLException;

    
    
//    public Connection restoreConnection(Database conn) throws SQLException{
//            if (conn.validate()) {
//                return conn.getConnection();
//            }
//            return getConnection(conn.getUrl(), conn.getLogin(), conn.getPassword());
//    }
    
}
