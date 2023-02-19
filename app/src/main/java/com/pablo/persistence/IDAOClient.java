package com.pablo.persistence;

import com.pablo.models.ClientModel;


public abstract class IDAOClient {

    public abstract ClientModel getById(int codigo);

    public static IDAOClient getInstance()
    {
        if (AppConfig.Modo == "MEMORY")
        {
            return new DAOMemoryClient();
        }
        if (AppConfig.Modo == "FIREASE")
        {
            //return new DAOFirebaseCliente();
        }
        if (AppConfig.Modo == "SQLITE")
        {
            //return new DAOSQLiteCliente();
        }
        return null;
    }
}
