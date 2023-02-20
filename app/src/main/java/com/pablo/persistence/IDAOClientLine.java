package com.pablo.persistence;

import com.pablo.models.ClientLineModel;
import com.pablo.models.InvoiceLineModel;

import java.util.ArrayList;

public abstract class IDAOClientLine {

    public abstract ArrayList<ClientLineModel> getByIdClient(int clientId);

    public abstract int getTotalInvoices(int clientId);



    public static IDAOClientLine getInstance()
    {
        if (AppConfig.Modo == "MEMORY")
        {
            return new DAOMemoryClientLine();
        }
        if (AppConfig.Modo == "FIREASE")
        {
            //return new DAOFirebaseLineaFactura();
        }
        if (AppConfig.Modo == "SQLITE")
        {
            //return new DAOSQLiteLineaFactura();
        }
        return null;
    }

}
