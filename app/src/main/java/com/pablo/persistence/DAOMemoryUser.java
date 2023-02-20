package com.pablo.persistence;

import com.pablo.models.UserModel;


public class DAOMemoryUser extends IDAOUser {



    public UserModel login(String usuario, String password){
        for (UserModel u: DataMemory.getInstance().usersData) {
            if (u.getUserName().equals(usuario) && u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        return null;
    }
}
