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
public class ExchangeOrder {
    
    private int orderId;
    private boolean isActive;
    private Date startTime;
    private Date endTime;
    private boolean partialExchangeAllowed;
    private double orderAmount;
    private double minOrderAmount;
    private double rate;
    
}
