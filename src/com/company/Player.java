package com.company;

import com.company.animals.Fish;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public int money;
    public String name;
    public ArrayList<Animal> animals = new ArrayList<>();
    public ArrayList<Integer> animalNumbers = new ArrayList<>();
    public ArrayList<Food> foods = new ArrayList<>();
    public ArrayList<Double> foodNumbers = new ArrayList<>();

    public Player(String name){
        this.name = name;
        this.money = 10000;
    }

    public void animalHealth(Player player){
        for (var animal : player.animals){
            animal.healthDecrease(animal);
            if (animal.healthPercent <= 0){
                System.out.println("One of your " + player.animals.getClass() + " just died.");
                player.animals.remove(animal);
            }
        }
    }

    public void feedYourAnimals(Player player){
        System.out.println("Which type of animal would you like to feed?");
        System.out.println("1. my fish");
        System.out.println("2. my turtle(s)");
        System.out.println("3. my bunny(/bunnies)");
        System.out.println("4. my cat(s)");
        System.out.println("5. my dog(s)");
        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();
        switch (menuItem){
            case 1:
                var numberOfFedFish = 0;
                    for (var j = 0; j < player.animals.size(); j++) {
                        if (player.animals.get(j).type == "Fish" && player.animals.get(j).healthPercent < 1
                                && player.foodNumbers.get(0) >= 0.01) {
                            while (player.animals.get(j).healthPercent < 1 && player.foodNumbers.get(0) >= 0.01) {
                                player.animals.get(j).healthPercent += 0.1;
                                if (player.animals.get(j).healthPercent > 1) {
                                    player.animals.get(j).healthPercent = 1;
                                }
                                player.foodNumbers.set(0, (player.foodNumbers.get(0) - 0.01));
                            }
                            numberOfFedFish++;
                        }
                    }
                System.out.println(numberOfFedFish + " of your " + player.animalNumbers.get(0) + " fish were fully fed.");
                    break;
            case 2:
                var numberOfFedTurtles = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type == "Turtle" && player.animals.get(j).healthPercent < 1
                            && player.foodNumbers.get(1) >= 0.1) {
                        while (player.animals.get(j).healthPercent < 1 && player.foodNumbers.get(1) >= 0.1) {
                            player.animals.get(j).healthPercent += 0.1;
                            if (player.animals.get(j).healthPercent > 1) {
                                player.animals.get(j).healthPercent = 1;
                            }
                            player.foodNumbers.set(1, (player.foodNumbers.get(1) - 0.1));
                        }
                        numberOfFedTurtles++;
                    }
                }
                System.out.println(numberOfFedTurtles + " of your " + player.animalNumbers.get(1) + " turtle(s) were fully fed.");
                break;
            case 3:
                var numberOfFedBunnies = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type == "Bunny" && player.animals.get(j).healthPercent < 1
                            && player.foodNumbers.get(1) >= 0.2) {
                        while (player.animals.get(j).healthPercent < 1 && player.foodNumbers.get(1) > 0.2) {
                            player.animals.get(j).healthPercent += 0.1;
                            if (player.animals.get(j).healthPercent > 1) {
                                player.animals.get(j).healthPercent = 1;
                            }
                            player.foodNumbers.set(1, (player.foodNumbers.get(1) - 0.2));
                        }
                        numberOfFedBunnies++;
                    }
                }
                System.out.println(numberOfFedBunnies + " of your " + player.animalNumbers.get(2) + " bunny(/bunnies) were fully fed.");
                break;
            case 4:
                var numberOfFedCats = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type == "Cat" && player.animals.get(j).healthPercent < 1
                            && player.foodNumbers.get(2) >= 0.1) {
                        while (player.animals.get(j).healthPercent < 1 && player.foodNumbers.get(2) >= 0.1) {
                            player.animals.get(j).healthPercent += 0.1;
                            if (player.animals.get(j).healthPercent > 1) {
                                player.animals.get(j).healthPercent = 1;
                            }
                            player.foodNumbers.set(2, (player.foodNumbers.get(2) - 0.1));
                        }
                        numberOfFedCats++;
                    }
                }
                System.out.println(numberOfFedCats + " of your " + player.animalNumbers.get(3) + " cat(s) were fully fed.");
                break;
            case 5:
                var numberOfFedDogs = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type == "Dog" && player.animals.get(j).healthPercent < 1
                            && player.foodNumbers.get(3) >= 0.3) {
                        while (player.animals.get(j).healthPercent < 1 && player.foodNumbers.get(3) >= 0.3) {
                            player.animals.get(j).healthPercent += 0.1;
                            if (player.animals.get(j).healthPercent > 1) {
                                player.animals.get(j).healthPercent = 1;
                            }
                            player.foodNumbers.set(3, (player.foodNumbers.get(3) - 0.3));
                        }
                        numberOfFedDogs++;
                    }
                }
                System.out.println(numberOfFedDogs + " of your " + player.animalNumbers.get(4) + " dog(s) were fully fed.");
                break;
        }
        System.out.println("Would you like to feed another type of animal? (yes/no)");
        Scanner menuScanner = new Scanner(System.in);
        var yesOrNo = menuScanner.nextLine();
        if (yesOrNo.equals("yes")){
            player.feedYourAnimals(player);
        }
        else {
            return; }
    }

}
