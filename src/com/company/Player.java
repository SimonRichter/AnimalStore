package com.company;

import java.util.ArrayList;

public class Player {
    public int money;
    public String name;
    public ArrayList<Animal> animals;
    public ArrayList<Food> foods;

    public Player(String name){
        this.name = name;
        this.money = 10000;
    }

}
