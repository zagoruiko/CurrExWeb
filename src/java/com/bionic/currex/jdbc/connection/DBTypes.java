/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.jdbc.connection;

/**
 *
 * @author Sergio
 */
public enum DBTypes {
    MYSQL("MYSQL");
    
    DBTypes(String id){
        this.id = id;
    }
    
    private String id;
    
    public String getId(){
        return id;
    }
}
