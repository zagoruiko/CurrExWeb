/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.entities;

import java.util.Objects;

/**
 *
 * @author Sergio
 */
public class Currency {
    
    private int currencyId;
    private String currencyName;
    private String currencyCountry;
    private char currencySign;
    private String currencyAbbriviature;
    
    
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCountry() {
        return currencyCountry;
    }

    public void setCurrencyCountry(String currencyCountry) {
        this.currencyCountry = currencyCountry;
    }

    public char getCurrencySign() {
        return currencySign;
    }

    public void setCurrencySign(char currencySign) {
        this.currencySign = currencySign;
    }

    public String getCurrencyAbbriviature() {
        return currencyAbbriviature;
    }

    public void setCurrencyAbbriviature(String currencyAbbriviature) {
        this.currencyAbbriviature = currencyAbbriviature;
    }
 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.currencyId;
        hash = 67 * hash + Objects.hashCode(this.currencyName);
        hash = 67 * hash + Objects.hashCode(this.currencyCountry);
        hash = 67 * hash + this.currencySign;
        hash = 67 * hash + Objects.hashCode(this.currencyAbbriviature);
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
        final Currency other = (Currency) obj;
        if (this.currencyId != other.currencyId) {
            return false;
        }
        if (!Objects.equals(this.currencyName, other.currencyName)) {
            return false;
        }
        if (!Objects.equals(this.currencyCountry, other.currencyCountry)) {
            return false;
        }
        if (this.currencySign != other.currencySign) {
            return false;
        }
        if (!Objects.equals(this.currencyAbbriviature, other.currencyAbbriviature)) {
            return false;
        }
        return true;
    }
}
