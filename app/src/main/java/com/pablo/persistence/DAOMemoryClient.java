package com.pablo.persistence;


import com.pablo.models.ClientModel;

import java.util.ArrayList;

public class DAOMemoryClient extends IDAOClient {

    public ClientModel getById(int codigo){
        for (ClientModel c: DataMemory.getInstance().datosClientes) {
            if (c.getId() == codigo){
                return c;
            }
        }
        return null;
    }

    public ArrayList<ClientModel> getAll(){
        return DataMemory.getInstance().datosClientes;
    }
}
