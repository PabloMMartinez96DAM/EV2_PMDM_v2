package com.pablo.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pablo.R;
import com.pablo.adapters.InvoiceListViewAdapter;
import com.pablo.models.InvoiceModel;
import com.pablo.persistence.IDAOInvoice;

import java.util.ArrayList;


public class MasterInvoiceFragment extends Fragment {

    private FloatingActionButton _insertFloatingBtn;
    private ListView _listView;
    private ArrayList<InvoiceModel> _elements;
    private InvoiceListViewAdapter _adapter;
    private IDAOInvoice _idaoInvoice = IDAOInvoice.GetInstance();



    //Método que se ejecuta cuando se crea el fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtén la referencia a la Toolbar inflada en onCreateView()
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        if(toolbar != null){

            // Configura la acción de búsqueda en la barra de herramientas
            SearchView searchView = toolbar.findViewById(R.id.search_view);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // Implementa aquí lo que quieres hacer cuando el usuario presiona el botón de búsqueda
                    _adapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    // Implementa aquí la lógica de filtrado de resultados en base a newText
                    _adapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }

    //Este método inicializa los componentes de la interfaz grafica definidos en el xml e implementa
    //la navegación hacia el formulario para crear nuevas facturas
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_invoice, container, false);
        _listView = view.findViewById(R.id.listView);
        _elements = _idaoInvoice.getAll();
        _adapter = new InvoiceListViewAdapter(getContext(), _elements);
        _listView.setAdapter(_adapter);

        _insertFloatingBtn = view.findViewById(R.id.fab_insertar);
        _insertFloatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                // Crea una instancia del nuevo fragment
                Fragment newFragment = new InvoiceFormFragment();

                // Obtiene el FragmentManager desde el contexto
                FragmentManager fragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();

                // Inicia la transacción de fragmentos
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}