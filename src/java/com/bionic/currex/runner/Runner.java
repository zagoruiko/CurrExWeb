/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.runner;

import com.bionic.currex.entities.User;
import com.bionic.currex.jdbc.connection.*;
import com.bionic.currex.jdbc.dao.user.*;
import java.sql.Connection;
/**
 *
 * @author sergii.zagoruiko
 */
public class Runner {
    public static void main(String[] args){
        IUserDao userDao = new UserDaoImpl();
//        userDao.insertUser("TestName", "TestSurname", "TestNick", 
//                "sergio@inet.ua", "password", 123456789, 123456789, 1);
        User user = userDao.findByEmail("sergio@inet.ua");
        System.out.println(user.toString());
        System.out.println("Finish!");
    }
}
