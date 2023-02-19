package com.pablo.persistence;

import com.pablo.models.InvoiceLineModel;


import java.util.ArrayList;

public abstract class IDAOInvoiceLine {
    public abstract ArrayList<InvoiceLineModel> getByCodigoFactura(int codigoFactura);

    public abstract double getTotal(int codigoFactura);

    public static IDAOInvoiceLine GetInstance()
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
