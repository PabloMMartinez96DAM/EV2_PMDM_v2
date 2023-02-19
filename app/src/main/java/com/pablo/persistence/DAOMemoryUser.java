package com.pablo.persistence;

import com.pablo.models.UserModel;


public class DAOMemoryUser extends IDAOUser {



    public UserModel login(String usuario, String password){
        for (UserModel u: DataMemory.getInstance().datosUsuarios) {
            if (u.getUsuario().equals(usuario) && u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        return null;
    }
}
