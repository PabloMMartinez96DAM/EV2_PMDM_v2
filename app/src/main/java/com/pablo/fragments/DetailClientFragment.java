package com.pablo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.pablo.R;
import com.pablo.adapters.ClientLineListViewAdapter;
import com.pablo.models.ClientLineModel;
import com.pablo.models.ClientModel;
import com.pablo.persistence.IDAOClient;
import com.pablo.persistence.IDAOClientLine;
import com.pablo.persistence.IDAOInvoiceLine;

import java.util.ArrayList;


public class DetailClientFragment extends Fragment {



    private TextView _idClientLbl;
    private TextView _nameClientLbl;

    private ListView _listView;
    private ArrayList<ClientLineModel> _elements;
    private ClientLineListViewAdapter _adapter;

    private IDAOClientLine _idaoClientLine = IDAOClientLine.getInstance();
    private IDAOClient _idaoClient = IDAOClient.getInstance();
    private ClientModel _client;

    public DetailClientFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            int clientId = args.getInt("clientId");
            _client = _idaoClient.getById(clientId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_client, container, false);

        //Recuperamos los componentes de la interfaz
        _listView = view.findViewById(R.id.listView);
        _idClientLbl = view.findViewById(R.id.idClientLbl);
        _nameClientLbl = view.findViewById(R.id.nameClientLbl);

        //Le asiganos los valores en función del cliente
        _nameClientLbl.setText(this._client.getName());
        _idClientLbl.setText(String.valueOf(this._client.getId()));

        _elements = _idaoClientLine.getByIdClient(_client.getId());
        _adapter = new ClientLineListViewAdapter(getContext(),_elements);
        _listView.setAdapter(_adapter);






        return view;
    }
}