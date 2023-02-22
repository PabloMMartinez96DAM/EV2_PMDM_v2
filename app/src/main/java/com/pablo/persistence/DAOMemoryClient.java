package com.pablo.persistence;


import com.pablo.models.ClientModel;

import java.util.ArrayList;

public class DAOMemoryClient extends IDAOClient {

    //Recupera el modelo del cliente de la lista de clientes en función del ID
    public ClientModel getById(int id){
        for (ClientModel c: DataMemory.getInstance().clientsData) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    //Devuelve la lista completa de clientes
    public ArrayList<ClientModel> getAll(){
        return DataMemory.getInstance().clientsData;
    }

    //Este método actualiza a un cliente y devuelve un booleano si se ha conseguido
    @Override
    public boolean updateClient(ClientModel updatedClient) {
        ArrayList<ClientModel> clients = DataMemory.getInstance().clientsData;
        for (int i = 0; i <clients.size();i++) {
            if(clients.get(i).getId() == updatedClient.getId()){
                clients.set(i,updatedClient);
               return true;
            }

        }
        return false;

    }
}
