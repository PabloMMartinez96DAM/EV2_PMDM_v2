package com.pablo.persistence;

import com.pablo.models.InvoiceLineModel;


import java.util.ArrayList;

public abstract class IDAOInvoiceLine {
    public abstract ArrayList<InvoiceLineModel> getByCodigoFactura(int codigoFactura);

    public abstract double getTotalAmount(int codigoFactura);



    public static IDAOInvoiceLine getInstance()
    {
        if (AppConfig.Modo == "MEMORY")
        {
            return new DAOMemoryInvoiceLine();
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
