package com.company;

public abstract class Animal {

    public String name;
    public String gender;
    public String type;
    public int price;
    public int healthPercent;

    public Animal(String name, String gender){
        this.name = name;
        this.gender = gender;
        this.healthPercent = 100;
    }

    public void healthDecrease (Animal animal){
        animal.healthPercent = (int)Math.round(animal.healthPercent - Math.random()*30);
        System.out.println("Your " + animal.gender + " " + animal.type.toLowerCase() + " named " + animal.name + " has " + animal.healthPercent + "/100 health left.");
     }
}
