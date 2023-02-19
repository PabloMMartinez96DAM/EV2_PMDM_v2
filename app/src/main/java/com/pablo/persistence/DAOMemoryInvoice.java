package com.pablo.persistence;

import com.pablo.models.InvoiceModel;


import java.util.ArrayList;


public class DAOMemoryInvoice extends IDAOInvoice {


    public ArrayList<InvoiceModel> getAll(){
        return DataMemory.getInstance().datosFacturas;
    }

    public InvoiceModel getById(int codigo){
        for (InvoiceModel c: DataMemory.getInstance().datosFacturas) {
            if (c.getId() == codigo){
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<InvoiceModel> search(String text) {

        return null;
    }


}
