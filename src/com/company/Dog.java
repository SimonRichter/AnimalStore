package com.company;

public class Dog extends Animal{

    private int initialPrice = 6000;

    public Dog(String name){
        super(name);
    }
    public void bark(){
        System.out.println("Woof!");
    }
}
