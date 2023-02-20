package com.pablo.persistence;

import com.pablo.models.InvoiceLineModel;

import java.util.ArrayList;

public class DAOMemoryInvoiceLine extends IDAOInvoiceLine {

    public ArrayList<InvoiceLineModel> getByCodigoFactura(int codigoFactura) {
        ArrayList<InvoiceLineModel> ret = new ArrayList<>();
        for (InvoiceLineModel lf : DataMemory.getInstance().invoiceLinesData) {
            if (lf.getInvoiceId() == codigoFactura) {
                ret.add(lf);
            }
        }
        return ret;
    }

    //Método para obtener la cantidad total de las facturas
    @Override
    public double getTotalAmount(int codigoFactura) {
        ArrayList<InvoiceLineModel> list = getByCodigoFactura(codigoFactura);
        int sum = 0;
        for (InvoiceLineModel linea : list) {
            sum += linea.getAmount() * linea.getPrice();
        }
        return sum;
    }
}
