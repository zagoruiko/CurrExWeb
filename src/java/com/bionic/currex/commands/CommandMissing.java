/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.commands;

import com.bionic.currex.manager.Config;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oper4
 */
public class CommandMissing implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return Config.getInstance().getProperty(Config.LOGIN);
    }
    
}
