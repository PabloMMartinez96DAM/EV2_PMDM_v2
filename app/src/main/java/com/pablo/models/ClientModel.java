package com.pablo.models;

public class ClientModel {
    //Properties

    //Id of the model
    private int id;

    //Name of the client
    private String name;

    private String lastName;

    //Age of the client
    private int age;

    //Description of the client
    private String description;

    //Constructors

    //Default constructor
    public ClientModel() {}

    //Constructor which initialize all the properties of this class
    public ClientModel(int id, String name, String lastName, int age, String description) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.description = description;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
