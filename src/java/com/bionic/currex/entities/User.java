/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.currex.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author oper4
 */
public class User implements Serializable {
    
    private int userId;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private int phone;
    private int cell;
    private UserRole role;
    private UserAddress userAddress;
    private Account userAccount;
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.userId;
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.nickName);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + this.phone;
        hash = 53 * hash + this.cell;
        hash = 53 * hash + Objects.hashCode(this.role);
        hash = 53 * hash + Objects.hashCode(this.userAddress);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.nickName, other.nickName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (this.cell != other.cell) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return true;
    }
}
