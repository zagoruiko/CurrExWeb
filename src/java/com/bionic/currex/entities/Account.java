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
public class Account {
    
    private int accountNumber;
    private boolean isPremium;
    private Date startDate;
    private Date expirationDate;
    private boolean isActive;
    private double debit;
    private Currency currency;
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isIsPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.accountNumber;
        hash = 11 * hash + (this.isPremium ? 1 : 0);
        hash = 11 * hash + Objects.hashCode(this.startDate);
        hash = 11 * hash + Objects.hashCode(this.expirationDate);
        hash = 11 * hash + (this.isActive ? 1 : 0);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.debit) ^ (Double.doubleToLongBits(this.debit) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.currency);
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
        final Account other = (Account) obj;
        if (this.accountNumber != other.accountNumber) {
            return false;
        }
        if (this.isPremium != other.isPremium) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.expirationDate, other.expirationDate)) {
            return false;
        }
        if (this.isActive != other.isActive) {
            return false;
        }
        if (Double.doubleToLongBits(this.debit) != Double.doubleToLongBits(other.debit)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        return true;
    }
}
