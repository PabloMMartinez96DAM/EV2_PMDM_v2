package com.pablo.models;

public class InvoiceLineModel {
    //Properties

    private int id;
    private int invoiceId;
    private int amount;
    private String prodcutName;
    private double price;

    //Constructor

    //Default constructor
    public InvoiceLineModel() {
    }

    public InvoiceLineModel(int id, int invoiceId, int amount, String prodcutName, double price) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.prodcutName = prodcutName;
        this.price = price;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProdcutName() {
        return prodcutName;
    }

    public void setProdcutName(String prodcutName) {
        this.prodcutName = prodcutName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
