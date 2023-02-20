package com.pablo.persistence;


import com.pablo.models.ClientModel;

import java.util.ArrayList;

public class DAOMemoryClient extends IDAOClient {

    public ClientModel getById(int id){
        for (ClientModel c: DataMemory.getInstance().clientsData) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public ArrayList<ClientModel> getAll(){
        return DataMemory.getInstance().clientsData;
    }
}
