package com.company.animals;
import com.company.Animal;

public class Dog extends Animal {

    public Dog(String name, String gender){
        super(name, gender);
        price = 6000;
        type = "Dog";
    }
}
