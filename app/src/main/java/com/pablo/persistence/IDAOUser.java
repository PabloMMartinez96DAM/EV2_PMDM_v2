package com.pablo.persistence;

import com.pablo.models.UserModel;


public abstract class IDAOUser {
    public abstract UserModel login(String usuario, String password);

    public static IDAOUser GetInstance()
    {
        if (AppConfig.Modo == "MEMORY")
        {
            return new DAOMemoryUser();
        }
        if (AppConfig.Modo == "FIREASE")
        {
            //return new DAOFirebaseUsuario();
        }
        if (AppConfig.Modo == "SQLITE")
        {
            //return new DAOSQLiteUsuario();
        }
        return null;
    }
}
