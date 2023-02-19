package com.pablo.persistence;

import com.pablo.models.ClientModel;
import com.pablo.models.InvoiceLineModel;
import com.pablo.models.InvoiceModel;
import com.pablo.models.LanguageModel;
import com.pablo.models.UserModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataMemory
    {
        public ArrayList<ClientModel> datosClientes;
        public ArrayList<InvoiceModel> datosFacturas;
        public ArrayList<InvoiceLineModel> datosLineasFacturas;
        public ArrayList<UserModel> datosUsuarios;
        public ArrayList<LanguageModel> datosIdiomas;

        //Propiedad estática donde se guarda la única instancia de la clase ...
        private static DataMemory instance;

        //Método estático que devuelve una unica instancia de "Singleton" ...
        public static DataMemory getInstance()
        {
            if (instance == null)
            {
                instance = new DataMemory();
            }
            return instance;
        }

        //Constructor por defecto privado para que no se pueda instanciar a menos que se use el metodo de clase "GetInstance" ...
        private DataMemory() {
            inicializarDatosUsuario();
            inicializarDatosClientes();
            inicializarDatosFacturas();
            inicializarLineasFacturas();
            inicializarDatosIdiomas();
        }

        private void inicializarDatosUsuario() {
            this.datosUsuarios = new ArrayList<UserModel>();
            this.datosUsuarios.add(new UserModel("usuario1", "password1"));
            this.datosUsuarios.add(new UserModel("usuario2", "password2"));
        }

        private void inicializarDatosClientes(){
            this.datosClientes = new ArrayList<ClientModel>();
            this.datosClientes.add(new ClientModel(1,"Cliente 1"));
            this.datosClientes.add(new ClientModel(2,"Cliente 2"));
            this.datosClientes.add(new ClientModel(3,"Cliente 3"));
            this.datosClientes.add(new ClientModel(4,"Cliente 4"));
        }

        private void inicializarDatosFacturas(){
            this.datosFacturas = new ArrayList<InvoiceModel>();
            try {
                this.datosFacturas.add(new InvoiceModel(1, 100, 1, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01")));
                this.datosFacturas.add(new InvoiceModel(2, 200, 2, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-02")));
                this.datosFacturas.add(new InvoiceModel(3, 300, 3, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-03")));
                this.datosFacturas.add(new InvoiceModel(4, 400, 4, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-04")));
            } catch (Exception ex){
                //
            }
        }

        private void inicializarLineasFacturas(){
            this.datosLineasFacturas = new ArrayList<InvoiceLineModel>();
            this.datosLineasFacturas.add(new InvoiceLineModel(1, 1, 1, "Producto 1", 100));
            this.datosLineasFacturas.add(new InvoiceLineModel(2, 1, 2, "Producto 2", 200));
            this.datosLineasFacturas.add(new InvoiceLineModel(3, 2, 3, "Producto 3", 300));
            this.datosLineasFacturas.add(new InvoiceLineModel(4, 2, 4, "Producto 4", 400));
            this.datosLineasFacturas.add(new InvoiceLineModel(5, 3, 5, "Producto 5", 500));
            this.datosLineasFacturas.add(new InvoiceLineModel(6, 3, 6, "Producto 6", 600));
            this.datosLineasFacturas.add(new InvoiceLineModel(7, 4, 3, "Producto 7", 700));
            this.datosLineasFacturas.add(new InvoiceLineModel(8, 4, 4, "Producto 8", 800));
        }

        private void inicializarDatosIdiomas() {
            this.datosIdiomas = new ArrayList<LanguageModel>();
            this.datosIdiomas.add(new LanguageModel(1, "es", "español"));
            this.datosIdiomas.add(new LanguageModel(2, "en", "ingles"));
        }
    }


