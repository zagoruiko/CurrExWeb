/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.dao.user;

import com.bionic.currex.entities.User;
import com.bionic.currex.jdbc.connection.DAOFactory;
import com.bionic.currex.jdbc.connection.DBTypes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class UserDaoImpl implements IUserDao{

    private Connection getConnection() throws SQLException{
        return DAOFactory.createDriver(DBTypes.MYSQL).getConnection();
    }
    
    @Override
    public int insertUser(String firstName, String lastName, String nickName, 
        String email, String password, int phone, int cell, int userRoleId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try{
            conn = this.getConnection();
            ps = conn.prepareStatement("INSERT INTO User(firstName, lastName, "
                    + "nickName, email, password, phone, cell, RoleId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, nickName);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setInt(6, phone);
            ps.setInt(7, cell);
            ps.setInt(8, userRoleId);
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return id;
        }
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> findByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> findBySecondName(String secondName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = this.getConnection();
            ps = conn.prepareStatement("SELECT userId, firstName, lastName, "
                    + "nickName, email, password, phone, cell, RoleId " 
                    + "FROM User WHERE email=?;");
            ps.setString(1, email);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()){
                user = new User(rs.getInt("userId"), 
                        rs.getString("firstName"), 
                        rs.getString("lastName"),
                        rs.getString("nickName"),
                        email,
                        rs.getString("password"),
                        rs.getInt("phone"),
                        rs.getInt("cell"),
                        rs.getInt("RoleId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return user;
        }
    

    }

    
    
}
