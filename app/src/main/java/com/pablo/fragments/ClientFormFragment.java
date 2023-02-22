package com.pablo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.pablo.R;
import com.pablo.activities.MainActivity;
import com.pablo.models.ClientModel;
import com.pablo.persistence.IDAOClient;


//Este fragment modificara un cliente que se le pasa como parametro
public class ClientFormFragment extends Fragment {

    private ClientModel _client;
    private IDAOClient _idaoClient = IDAOClient.getInstance();

    public static ClientFormFragment newInstance(String param1, String param2) {
        ClientFormFragment fragment = new ClientFormFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    //Recuperamos el cliente
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_form, container, false);

        //Creamos las referencias a los componentes de la interfaz
        TextInputEditText nameTxt = view.findViewById(R.id.nameEditText);
        TextInputEditText lastNameTxt = view.findViewById(R.id.lastNameEditText);
        TextInputEditText ageNameTxt = view.findViewById(R.id.ageEditText);
        TextInputEditText descrEditText = view.findViewById(R.id.descriptionEditText);

        Button sendBtn = view.findViewById(R.id.sendBtn);

        //Asignamos los valores correspondientes del cliente a modificar
        nameTxt.setText(_client.getName());
        lastNameTxt.setText(_client.getLastName());
        ageNameTxt.setText(String.valueOf(_client.getAge()));
        descrEditText.setText(_client.getDescription());


        //Definimos el método onClick del botón para actualizar los datos
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = nameTxt.getText().toString();
                String newLastName = lastNameTxt.getText().toString();

                //Una mejora sería comprobar si lo introducido no es un número o restringir a que
                //solo se pueden meter número definiendo un Pattern o con alguna herramienta del
                //propio framework
                int newAge =Integer.parseInt( ageNameTxt.getText().toString());

                String newDescription = descrEditText.getText().toString();



                ClientModel updatedClient = new ClientModel(_client.getId(),newName,newLastName,newAge,newDescription);

                //Si se ha producido correctamente la actualización
                if(_idaoClient.updateClient(updatedClient)){
                    Toast.makeText(getContext(), "Se ha actualizado al cliente: " + newName, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "No se ha podido actualizar al cliente: " + _client.getName() , Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}