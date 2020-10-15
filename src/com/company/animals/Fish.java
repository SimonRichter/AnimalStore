package com.company.animals;
import com.company.Animal;

public class Fish extends Animal {
    private int initialPrice = 60;

    public Fish(String name, String gender){
        super(name, gender);
        price = 60;
        type = "Fish";
    }

}
