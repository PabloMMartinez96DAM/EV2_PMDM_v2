package com.pablo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.pablo.R;
import com.pablo.models.ClientLineModel;
import com.pablo.models.InvoiceLineModel;

import java.util.List;

public class ClientLineListViewAdapter extends BaseAdapter {

    private Context _context;
    private final List<ClientLineModel> _items;

    public ClientLineListViewAdapter(Context context, List<ClientLineModel> items) {
        _context = context;
        _items = items;
    }
    //El método getCount devuelve el número de elementos en la lista.
    @Override
    public int getCount() {
        return _items.size();
    }

    //El método getItem devuelve el elemento en la posición especificada.
    @Override
    public Object getItem(int position) {
        ClientLineModel clientLine = _items.get(position);
        return clientLine;
    }

    //El método getItemId devuelve la posición del elemento.
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(_context);
            convertView = inflater.inflate(R.layout.adapter_listview_clientline, parent, false);
        }

        ClientLineModel clientLineModel = _items.get(position);

        TextView idInvoiceLbl = convertView.findViewById(R.id.idInvoiceLbl);
        idInvoiceLbl.setText(String.valueOf(clientLineModel.getId()));

        //TextView dateInvoiceLbl = convertView.findViewById(clientLineModel.get)


        return convertView;
    }
}
