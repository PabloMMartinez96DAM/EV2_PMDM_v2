package com.pablo.persistence;

import com.pablo.models.ClientModel;

import java.util.ArrayList;


public abstract class IDAOClient {

    //Devuelve un ClientModel en función del ID
    public abstract ClientModel getById(int codigo);

    //Devuelve todos los ModelCliente almacenados
    public abstract ArrayList<ClientModel> getAll();

    //Devuelve una instancia de la clase que implementa los métodos anteriores en función
    //de la configuración escogida para el programa
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

    //Método para actualizar un cliente ya existente que devuelve un booleano en función
    //de si se ha podido actualizar o no
    public abstract boolean updateClient(ClientModel updatedClient);
}
