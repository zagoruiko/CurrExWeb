/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.dao.user;

/**
 *
 * @author Sergio
 */
public class UserDaoFactory {
    public static IUserDao create(){
        return new UserDaoImpl();
    }
}
