package com.pablo.models;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String userName;
    private String password;

    //Default constructor
    public UserModel() {
    }


    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
