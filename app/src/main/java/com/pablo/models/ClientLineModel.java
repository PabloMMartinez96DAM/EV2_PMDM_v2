package com.pablo.models;

public class ClientLineModel {
    //Properties
    private int id;
    private int clientId;
    private int totalInvoices;

    //Cosntructors
    public ClientLineModel() {
    }

    public ClientLineModel(int id, int clientId, int totalInvoices) {
        this.id = id;
        this.clientId = clientId;
        this.totalInvoices = totalInvoices;
    }
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTotalInvoices() {
        return totalInvoices;
    }

    public void setTotalInvoices(int totalInvoices) {
        this.totalInvoices = totalInvoices;
    }
}
