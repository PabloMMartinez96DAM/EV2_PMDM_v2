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

import com.pablo.R;
import com.pablo.fragments.DetailInvoiceFragment;
import com.pablo.models.ClientModel;
import com.pablo.models.InvoiceModel;
import com.pablo.persistence.IDAOClient;
import com.pablo.persistence.IDAOInvoiceLine;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


//La clase CustomAdapter extiende la clase BaseAdapter.
// Esta clase es una de las dos clases de base principales que se pueden utilizar para crear un adaptador personalizado.
// La otra es ArrayAdapter
public class InvoiceListViewAdapter extends BaseAdapter implements Filterable {

    private IDAOClient idaoCliente = IDAOClient.getInstance();

    private IDAOInvoiceLine idaoLineaFactura = IDAOInvoiceLine.getInstance();

    private Context _context;

    private final List<InvoiceModel> _items;

    private List<InvoiceModel> _itemsFiltered;

    private CustomFilter customFilter;

    public InvoiceListViewAdapter(@NonNull Context context, @NonNull List<InvoiceModel> items) {
        //super(context, R.layout.adapter_listview_facturas, items);
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
        InvoiceModel factura = _itemsFiltered.get(position);
        return factura;
    }

    //El método getItemId devuelve la posición del elemento.
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Este método se ejecuta al mostrar un elemento
    public View getView(int position, View convertView, ViewGroup parent) {

        //Una pequeña optimización para no tener que "inflar" la vista si no es nula.
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(_context);
            convertView = inflater.inflate(R.layout.adapter_listview_invoices, parent, false);
        }
        InvoiceModel invoice = _itemsFiltered.get(position);

        //Obtenemos la referencia a los componentes de la interfaz
        TextView lblCodigoFactura = convertView.findViewById(R.id.lblCodigoFactura);
        TextView lblDateYear = convertView.findViewById(R.id.lblDateYear);
        TextView lblDateDay = convertView.findViewById(R.id.lblDateDay);
        TextView lblDateMonth = convertView.findViewById(R.id.lblDateMonth);
        TextView lblCliente = convertView.findViewById(R.id.lblCliente);
        TextView lblTotal = convertView.findViewById(R.id.lblTotal);

        //Asignamos los valores a los componentes
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(invoice.getDate());
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        String diaFormateado = String.format("%02d", dia);
        String mesFormateado = new DateFormatSymbols().getShortMonths()[mes];

        ClientModel cliente = idaoCliente.getById(invoice.getClientId());
        double total = idaoLineaFactura.getTotalAmount(invoice.getId());

        lblCodigoFactura.setText(String.valueOf(invoice.getId()));
        lblDateYear.setText(String.valueOf(ano));
        lblDateDay.setText(diaFormateado);
        lblDateMonth.setText(mesFormateado);
        lblCliente.setText(cliente.getName());
        lblTotal.setText(String.valueOf(total));

        //Implementamos un listener cuando clickamos un elemento para navegar al fragment de detalle
        //pasandole los datos del elemento seleccionado
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea una instancia del nuevo fragment
                Fragment newFragment = new DetailInvoiceFragment();

                // Crear un bundle para pasar los parámetros
                Bundle args = new Bundle();
                args.putInt("invoiceId", invoice.getId());
                // Agregar el bundle al fragmento
                newFragment.setArguments(args);

                // Obtiene el FragmentManager desde el contexto
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
        return customFilter;
    }

    //Implementación del filtro de busqueda
    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();

            if (charSequence == null || charSequence.length() == 0) {
                results.values = new ArrayList<>(_items);
                results.count = _items.size();
            } else {
                List<InvoiceModel> filtered = new ArrayList<>();
                for (InvoiceModel factura : _items) {
                    ClientModel cliente = idaoCliente.getById(factura.getClientId());
                    if (cliente.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filtered.add(factura);
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
            _itemsFiltered.addAll((List<InvoiceModel>) filterResults.values);
            notifyDataSetChanged();
        }
    }

}



