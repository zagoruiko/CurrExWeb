/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.entities;

import java.util.Date;

/**
 *
 * @author Sergio
 */
public class Account {
    
    private int accountNumber;
    private boolean isPremium;
    private Date startDate;
    private Date expirationDate;
    private boolean isActive;
    private double debit;
    private Currency currency;
}
