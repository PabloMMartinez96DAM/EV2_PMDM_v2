package com.pablo.models;

import java.util.Date;

public class InvoiceModel {

    //Properties
    private int id;
    private double total;
    private int clientId;
    private Date date;


    //Constructor

    public InvoiceModel() {
    }

    public InvoiceModel(int id, double total, int clientId, Date date) {
        this.id = id;
        this.total = total;
        this.clientId = clientId;
        this.date = date;
    }
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
