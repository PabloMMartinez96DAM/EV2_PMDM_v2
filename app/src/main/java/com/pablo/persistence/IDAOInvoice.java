package com.pablo.persistence;

import com.pablo.models.InvoiceModel;


import java.util.ArrayList;

public abstract class IDAOInvoice {

    public abstract ArrayList<InvoiceModel> getAll();
    public abstract InvoiceModel getById(int codigo);

    public abstract ArrayList<InvoiceModel> search(String text);

    public static IDAOInvoice GetInstance()
    {
        if (AppConfig.Modo == "MEMORY")
        {
            return new DAOMemoryInvoice();
        }
        if (AppConfig.Modo == "FIREASE")
        {
            //return new DAOFirebaseFactura();
        }
        if (AppConfig.Modo == "SQLITE")
        {
            //return new DAOSQLiteFactura();
        }
        return null;
    }
}
