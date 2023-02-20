package com.pablo.persistence;

import com.pablo.models.ClientLineModel;

import java.util.ArrayList;

public class DAOMemoryClientLine extends IDAOClientLine {

    @Override
    public ArrayList<ClientLineModel> getByIdClient(int clientId) {

        ArrayList<ClientLineModel> list = new ArrayList<>();
        for (ClientLineModel clientLineModel : DataMemory.getInstance().clientLinesData) {
            if (clientLineModel.getClientId() == clientId) {
                list.add(clientLineModel);
            }
        }
        return list;
    }

    @Override
    public int getTotalInvoices(int clientId) {

        return getByIdClient(clientId).size();
    }
}
