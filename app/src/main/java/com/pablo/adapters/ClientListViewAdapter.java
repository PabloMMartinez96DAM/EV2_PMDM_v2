package com.pablo.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.pablo.R;
import com.pablo.fragments.ClientFormFragment;
import com.pablo.models.ClientModel;
import com.pablo.models.InvoiceModel;
import com.pablo.persistence.IDAOClient;
import com.pablo.persistence.IDAOClientLine;


import java.util.ArrayList;
import java.util.List;

//Adaptador para mostrar  a los clientes en el ListView del MasterClientFragment
public class ClientListViewAdapter extends BaseAdapter  implements Filterable {
    private IDAOClient idaoClient = IDAOClient.getInstance();

    private IDAOClientLine idaoClientLine = IDAOClientLine.getInstance();

    private Context _context;

    private final List<ClientModel> _items;
    private List<ClientModel> _itemsFiltered;
    private CustomFilter customFilter;


    public ClientListViewAdapter(Context context, List<ClientModel> items) {
        _items = new ArrayList<>(items);
        _itemsFiltered = new ArrayList<>(items);
        _context = context;
        customFilter = new CustomFilter();
    }
    //El método getCount devuelve el número de elementos en la lista.
    @Override
    public int getCount() {
        return _itemsFiltered.size();
    }

    //El método getItem devuelve el elemento en la posición especificada.
    @Override
    public Object getItem(int position) {
        ClientModel client = _itemsFiltered.get(position);
        return client;
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
            convertView = inflater.inflate(R.layout.adapter_listview_clients, parent, false);
        }

        ClientModel client = _itemsFiltered.get(position);


        //Obtenemos las referencias a los TextView a los que queremos asignarles los datos
        TextView clientIdlbl = convertView.findViewById(R.id.idClientLbl);
        TextView clientNamelbl = convertView.findViewById(R.id.clientNameLbl);
        TextView totalInvoices = convertView.findViewById(R.id.totalInvoicesLbl);

        //Asignamos los datos del cliente a los labels correspondientes
        clientIdlbl.setText(String.valueOf(client.getId()));
        clientNamelbl.setText(client.getName());
        totalInvoices.setText(String.valueOf(idaoClientLine.getTotalInvoices(client.getId())));



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea una instancia del nuevo fragment
                Fragment newFragment = new ClientFormFragment();

                // Crear un bundle para pasar los parámetros
                Bundle args = new Bundle();
                args.putInt("clientId", client.getId());

                // Agregar el bundle al fragmento
                newFragment.setArguments(args);
                FragmentManager fragmentManager = ((FragmentActivity) _context).getSupportFragmentManager();

                // Inicia la transacción de fragmentos
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        //y se devuelve la View resultante
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return null;
    } private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();

            if (charSequence == null || charSequence.length() == 0) {
                results.values = new ArrayList<>(_items);
                results.count = _items.size();
            } else {
                List<ClientModel> filtered = new ArrayList<>();
                for (ClientModel client : _items) {
                    ClientModel cliente = idaoClient.getById(client.getId());
                    if (cliente.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filtered.add(client);
                    }
                }
                results.values = filtered;
                results.count = filtered.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            _itemsFiltered.clear();
            _itemsFiltered.addAll((List<ClientModel>) filterResults.values);
            notifyDataSetChanged();
        }
    }

}