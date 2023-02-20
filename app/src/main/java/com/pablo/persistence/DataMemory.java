package com.pablo.persistence;

import com.pablo.models.ClientLineModel;
import com.pablo.models.ClientModel;
import com.pablo.models.InvoiceLineModel;
import com.pablo.models.InvoiceModel;
import com.pablo.models.LanguageModel;
import com.pablo.models.UserModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataMemory
    {
        public ArrayList<ClientModel> clientsData;
        public ArrayList<InvoiceModel> invoicesData;
        public ArrayList<InvoiceLineModel> invoiceLinesData;
        public ArrayList<UserModel> usersData;
        public ArrayList<LanguageModel> languageData;
        public ArrayList<ClientLineModel> clientLinesData;

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
            initializeUserData();
            initializeClientsData();
            initializeInvoicesData();
            initializeInvoiceLinesData();
            initializeLanguageData();
            initializeClientLinesData();
        }

        private void initializeClientLinesData() {
            this.clientLinesData = new ArrayList<>();
            this.clientLinesData.add(new ClientLineModel(1,1,10));
            this.clientLinesData.add(new ClientLineModel(2,2,10));
            this.clientLinesData.add(new ClientLineModel(3,3,10));
            this.clientLinesData.add(new ClientLineModel(4,4,10));
            this.clientLinesData.add(new ClientLineModel(5,5,10));
        }

        private void initializeUserData() {
            this.usersData = new ArrayList<UserModel>();
            this.usersData.add(new UserModel("Pablo","123456789/a"));
            this.usersData.add(new UserModel("usuario1", "password1"));
            this.usersData.add(new UserModel("usuario2", "password2"));

        }

        private void initializeClientsData(){
            this.clientsData = new ArrayList<ClientModel>();
            this.clientsData.add(new ClientModel(1,"Cliente 1", "Apellido1", 18,"Este es el cliente número 1"));
            this.clientsData.add(new ClientModel(2,"Cliente 2", "Apellido2", 20, "Esta es la clienta número 2"));
            this.clientsData.add(new ClientModel(3,"Cliente 3", "Apellido3", 32, "Este es el cliente número 3"));
            this.clientsData.add(new ClientModel(4,"Cliente 4", "Apellido4", 25, "Esta es la clienta número 4"));
        }

        private void initializeInvoicesData(){
            this.invoicesData = new ArrayList<InvoiceModel>();
            try {
                this.invoicesData.add(new InvoiceModel(1, 100, 1, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01")));
                this.invoicesData.add(new InvoiceModel(2, 200, 2, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-02")));
                this.invoicesData.add(new InvoiceModel(3, 300, 3, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-03")));
                this.invoicesData.add(new InvoiceModel(4, 400, 4, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-04")));
            } catch (Exception ex){
                //
            }
        }

        private void initializeInvoiceLinesData(){
            this.invoiceLinesData = new ArrayList<InvoiceLineModel>();
            this.invoiceLinesData.add(new InvoiceLineModel(1, 1, 1, "Producto 1", 100));
            this.invoiceLinesData.add(new InvoiceLineModel(2, 1, 2, "Producto 2", 200));
            this.invoiceLinesData.add(new InvoiceLineModel(3, 2, 3, "Producto 3", 300));
            this.invoiceLinesData.add(new InvoiceLineModel(4, 2, 4, "Producto 4", 400));
            this.invoiceLinesData.add(new InvoiceLineModel(5, 3, 5, "Producto 5", 500));
            this.invoiceLinesData.add(new InvoiceLineModel(6, 3, 6, "Producto 6", 600));
            this.invoiceLinesData.add(new InvoiceLineModel(7, 4, 3, "Producto 7", 700));
            this.invoiceLinesData.add(new InvoiceLineModel(8, 4, 4, "Producto 8", 800));
        }

        private void initializeLanguageData() {
            this.languageData = new ArrayList<LanguageModel>();
            this.languageData.add(new LanguageModel(1, "es", "Español"));
            this.languageData.add(new LanguageModel(2, "en", "Inglés"));
            this.languageData.add(new LanguageModel(3, "de", "Alemán"));
        }
    }


