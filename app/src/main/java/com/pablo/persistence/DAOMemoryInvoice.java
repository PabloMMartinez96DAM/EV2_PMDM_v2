package com.pablo.persistence;

import com.pablo.models.InvoiceModel;


import java.util.ArrayList;


public class DAOMemoryInvoice extends IDAOInvoice {


    public ArrayList<InvoiceModel> getAll(){
        return DataMemory.getInstance().invoicesData;
    }

    public InvoiceModel getById(int id){
        for (InvoiceModel c: DataMemory.getInstance().invoicesData) {
            if (c.getId() == id){
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
