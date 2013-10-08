/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergii.zagoruiko
 */
public interface ICommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
