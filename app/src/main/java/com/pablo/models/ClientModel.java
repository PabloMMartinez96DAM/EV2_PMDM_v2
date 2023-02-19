package com.pablo.models;

public class ClientModel {
    //Properties

    //Id of the model
    private int id;

    //Name of the client
    private String name;

    //Constructors

    //Default constructor
    public ClientModel() {}


    //Constructor which initialize all the properties of this class
    public ClientModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
