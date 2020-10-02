package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Animal[] temp = {
                new Dog ("Fido"),
                new Cat("Agda"),
                new Dog("Ysse")
        };

        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(temp));

        //Dogs and Cats have been upcasted to Animal
        //This won't work: animals.get(0).bark();

        //Downcasting
        var aDog = (Dog) animals.get(0);
        aDog.bark();



    }
}
