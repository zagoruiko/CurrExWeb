/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.manager;

import java.util.ResourceBundle;

/**
 *
 * @author oper4
 */
public class Config {
    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "com.bionic.currex.manager.config";
    public static final String MAIN = "MAIN";
    public static final String ERROR = "ERROR";
    public static final String LOGIN = "LOGIN";

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
