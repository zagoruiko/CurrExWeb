/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.commands;

import com.bionic.currex.jdbc.connection.DAOFactory;
import com.bionic.currex.jdbc.connection.DBTypes;
import com.bionic.currex.jdbc.dao.user.IUserDao;
import com.bionic.currex.manager.Config;
import com.bionic.currex.manager.Message;
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
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        IUserDao userDao = DAOFactory.createDriver(DBTypes.MYSQL).getUserDao();
        

        if (userDao.findByEmailAndPassword(email, password)) {
            request.setAttribute("email", email);
            page = Config.getInstance().getProperty(Config.MAIN);
        } else {
            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }
    
}
