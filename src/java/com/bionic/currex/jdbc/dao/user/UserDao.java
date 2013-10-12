/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.dao.user;

import com.bionic.currex.jdbc.connection.DAOFactory;
import com.bionic.currex.jdbc.connection.DBTypes;

/**
 *
 * @author oper4
 */
public class UserDao {
    public static IUserDao getUserDao(){
        return DAOFactory.createDriver(DBTypes.MYSQL).getUserDao();
    }
}
