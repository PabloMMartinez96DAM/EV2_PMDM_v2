package com.pablo.persistence;

import com.pablo.models.ClientLineModel;
import com.pablo.models.InvoiceLineModel;

import java.util.ArrayList;

public abstract class IDAOClientLine {

    //Devuelve un cliente en función del ID
    public abstract ArrayList<ClientLineModel> getByIdClient(int clientId);

    //Obtiene el total de facturas a nombre del cliente
    public abstract int getTotalInvoices(int clientId);

    //Devuelve una instancia de una clase que implemente los métodos de la interfaz en función
    //de la configuración escogida
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
