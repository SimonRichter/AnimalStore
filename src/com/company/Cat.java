package com.company;

public class Cat extends Animal{

    private int initialPrice = 2000;

    public Cat(String name){
        super(name);
    }


    public void meow(){
        System.out.println("Meow!");
    }

}
