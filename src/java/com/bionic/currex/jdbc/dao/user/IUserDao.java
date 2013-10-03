/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.dao.user;

import com.bionic.currex.entities.User;
import java.util.ArrayList;
/**
 *
 * @author Sergio
 */
public interface IUserDao {
    public void addUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public ArrayList<User> findAll() throws Exception;
    public User findById(int id) throws Exception;
    public ArrayList<User> findByFirstName(String firstName) throws Exception;
    public ArrayList<User> findBySecondName(String secondName) throws Exception;
}
