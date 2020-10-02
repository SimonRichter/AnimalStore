package com.company;

public class Cat extends Animal{

    private int initialPrice = 5000;

    public Cat(String name){
        super(name);
    }


    public void meow(){
        System.out.println("Meow!");
    }

}
