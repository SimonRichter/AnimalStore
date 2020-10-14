package com.company;

public abstract class Animal {


    public String name;
    public String gender;
    public String type;
    public int price;
    public double healthPercent;


    public Animal(String name, String gender){
        this.name = name;
        this.gender = gender;
        this.healthPercent = 1;
    }

    public void healthDecrease (Animal animal){
        animal.healthPercent = animal.healthPercent - Math.random()*0.3;
        System.out.println("Your " + animal.gender + " " + animal.type + " named " + animal.name + " has " + animal.healthPercent + "/1 health left.");
 }




}
