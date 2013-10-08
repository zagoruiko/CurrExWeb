/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.commands;

import com.bionic.currex.jdbc.connection.DAOFactory;
import com.bionic.currex.jdbc.connection.DBTypes;
import com.bionic.currex.jdbc.dao.user.IUserDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergii.zagoruiko
 */
public class CommandLogin implements ICommand {
    
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String page = null;
        String email = request.getParameter(email);
        String password = request.getParameter(password);
        IUserDao userDao = DAOFactory.createDriver(DBTypes.MYSQL).getUserDao();

        if ((userDao.findByEmail(email).getEmail() == email) && (userDao.findByEmail(email).getPassword() == password)) {
//            request.setAttribute("user", login);
//            page = Config.getInstance().getProperty(Config.MAIN);
        } else {
//            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
//            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }
    
}
