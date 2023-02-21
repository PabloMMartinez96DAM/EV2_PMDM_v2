package com.pablo.persistence;

import com.pablo.models.ClientModel;

import java.util.ArrayList;


public abstract class IDAOClient {

    public abstract ClientModel getById(int codigo);
    public abstract ArrayList<ClientModel> getAll();

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

    public abstract boolean updateClient(ClientModel client);
}
