package com.pablo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pablo.R;
import com.pablo.adapters.ClientListViewAdapter;
import com.pablo.models.ClientModel;
import com.pablo.persistence.IDAOClient;

import java.util.ArrayList;

public class MasterClientFragment extends Fragment {


    private ListView _listView;
    private ArrayList<ClientModel> _elements;
    private ClientListViewAdapter _adapter;
    private IDAOClient _idaoClient = IDAOClient.getInstance();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_master_client, container, false);

        _listView = view.findViewById(R.id.listView);
        _elements = _idaoClient.getAll();
        _adapter = new ClientListViewAdapter(getContext(),_elements);
        _listView.setAdapter(_adapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}