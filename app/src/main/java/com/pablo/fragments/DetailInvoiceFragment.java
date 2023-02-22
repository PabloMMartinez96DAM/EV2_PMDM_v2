package com.pablo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.pablo.R;
import com.pablo.adapters.InvoiceLineListViewAdapter;
import com.pablo.models.ClientModel;
import com.pablo.models.InvoiceLineModel;
import com.pablo.models.InvoiceModel;
import com.pablo.persistence.IDAOClient;
import com.pablo.persistence.IDAOInvoice;
import com.pablo.persistence.IDAOInvoiceLine;

import java.util.ArrayList;


//Implementada en clase: Fragment para mostrar el detalle de una factura
public class DetailInvoiceFragment extends Fragment {

    private ListView _listView;
    private TextView _invoiceIdText;
    private TextView _clientText;
    private TextView _totalText;
    private ArrayList<InvoiceLineModel> _elements;
    private InvoiceLineListViewAdapter _adapter;
    private InvoiceModel _invoice;
    private IDAOInvoice _idaoInvoice = IDAOInvoice.GetInstance();
    private IDAOInvoiceLine _idaoInvoiceLine = IDAOInvoiceLine.getInstance();
    private IDAOClient _idaoClient = IDAOClient.getInstance();

    public DetailInvoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            int codigoFactura = args.getInt("invoiceId");
            _invoice = _idaoInvoice.getById(codigoFactura);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_invoice, container, false);
        _listView = view.findViewById(R.id.listView);
        _invoiceIdText = view.findViewById(R.id.txtCodigoFactura);
        _clientText = view.findViewById(R.id.txtCliente);
        _totalText = view.findViewById(R.id.txtTotal);

        //campos
        ClientModel cliente = _idaoClient.getById(_invoice.getClientId());
        double total = _idaoInvoiceLine.getTotalAmount(_invoice.getId());
        _invoiceIdText.setText(String.valueOf(_invoice.getId()));
        _clientText.setText(cliente.getName());
        _invoiceIdText.setText(String.valueOf(total));

        //adaptador
        _elements = _idaoInvoiceLine.getByCodigoFactura(_invoice.getId());
        _adapter = new InvoiceLineListViewAdapter(getContext(), _elements);
        _listView.setAdapter(_adapter);

        return view;
    }
}