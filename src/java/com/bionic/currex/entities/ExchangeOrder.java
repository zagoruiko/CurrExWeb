/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.entities;

import java.util.Date;
import java.util.Objects;

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isPartialExchangeAllowed() {
        return partialExchangeAllowed;
    }

    public void setPartialExchangeAllowed(boolean partialExchangeAllowed) {
        this.partialExchangeAllowed = partialExchangeAllowed;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(double minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.orderId;
        hash = 83 * hash + (this.isActive ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.startTime);
        hash = 83 * hash + Objects.hashCode(this.endTime);
        hash = 83 * hash + (this.partialExchangeAllowed ? 1 : 0);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.orderAmount) ^ (Double.doubleToLongBits(this.orderAmount) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.minOrderAmount) ^ (Double.doubleToLongBits(this.minOrderAmount) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExchangeOrder other = (ExchangeOrder) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.isActive != other.isActive) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        if (this.partialExchangeAllowed != other.partialExchangeAllowed) {
            return false;
        }
        if (Double.doubleToLongBits(this.orderAmount) != Double.doubleToLongBits(other.orderAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.minOrderAmount) != Double.doubleToLongBits(other.minOrderAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        return true;
    }
    
}
