package com.company;

import com.company.animals.*;

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

    public void feedYourAnimals(Player player){
        System.out.println("");
        System.out.println("Which type of animal would you like to feed?");
        System.out.println("1. my fish");
        System.out.println("2. my turtle(s)");
        System.out.println("3. my bunny(/bunnies)");
        System.out.println("4. my cat(s)");
        System.out.println("5. my dog(s)");
        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();
        System.out.println("");
        switch (menuItem){
            case 1:
                var numberOfFedFish = 0;
                    for (var j = 0; j < player.animals.size(); j++) {
                        if (player.animals.get(j).type.equals("Fish") && player.animals.get(j).healthPercent < 100
                                && player.foodNumbers.get(0) >= 0.01) {
                            while (player.animals.get(j).healthPercent < 100 && player.foodNumbers.get(0) >= 0.01) {
                                player.animals.get(j).healthPercent += 10;
                                if (player.animals.get(j).healthPercent > 100) {
                                    player.animals.get(j).healthPercent = 100;
                                }
                                player.foodNumbers.set(0, (player.foodNumbers.get(0) - 0.01));
                            }
                            numberOfFedFish++;
                        }
                    }
                System.out.println("");
                System.out.println(numberOfFedFish + " of your " + player.animalNumbers.get(0) + " fish were fully fed.");
                    break;
            case 2:
                var numberOfFedTurtles = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type.equals("Turtle") && player.animals.get(j).healthPercent < 100
                            && player.foodNumbers.get(1) >= 0.1) {
                        while (player.animals.get(j).healthPercent < 100 && player.foodNumbers.get(1) >= 0.1) {
                            player.animals.get(j).healthPercent += 10;
                            if (player.animals.get(j).healthPercent > 100) {
                                player.animals.get(j).healthPercent = 100;
                            }
                            player.foodNumbers.set(1, (player.foodNumbers.get(1) - 0.1));
                        }
                        numberOfFedTurtles++;
                    }
                }
                System.out.println("");
                System.out.println(numberOfFedTurtles + " of your " + player.animalNumbers.get(1) + " turtle(s) were fully fed.");
                break;
            case 3:
                var numberOfFedBunnies = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type.equals("Bunny") && player.animals.get(j).healthPercent < 100
                            && player.foodNumbers.get(1) >= 0.2) {
                        while (player.animals.get(j).healthPercent < 100 && player.foodNumbers.get(1) > 0.2) {
                            player.animals.get(j).healthPercent += 10;
                            if (player.animals.get(j).healthPercent > 100) {
                                player.animals.get(j).healthPercent = 100;
                            }
                            player.foodNumbers.set(1, (player.foodNumbers.get(1) - 0.2));
                        }
                        numberOfFedBunnies++;
                    }
                }
                System.out.println("");
                System.out.println(numberOfFedBunnies + " of your " + player.animalNumbers.get(2) + " bunny(/bunnies) were fully fed.");
                break;
            case 4:
                var numberOfFedCats = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type.equals("Cat") && player.animals.get(j).healthPercent < 100
                            && player.foodNumbers.get(2) >= 0.1) {
                        while (player.animals.get(j).healthPercent < 100 && player.foodNumbers.get(2) >= 0.1) {
                            player.animals.get(j).healthPercent += 10;
                            if (player.animals.get(j).healthPercent > 100) {
                                player.animals.get(j).healthPercent = 100;
                            }
                            player.foodNumbers.set(2, (player.foodNumbers.get(2) - 0.1));
                        }
                        numberOfFedCats++;
                    }
                }
                System.out.println("");
                System.out.println(numberOfFedCats + " of your " + player.animalNumbers.get(3) + " cat(s) were fully fed.");
                break;
            case 5:
                var numberOfFedDogs = 0;
                for (var j = 0; j < player.animals.size(); j++) {
                    if (player.animals.get(j).type.equals("Dog") && player.animals.get(j).healthPercent < 100
                            && player.foodNumbers.get(3) >= 0.3) {
                        while (player.animals.get(j).healthPercent < 100 && player.foodNumbers.get(3) >= 0.3) {
                            player.animals.get(j).healthPercent += 10;
                            if (player.animals.get(j).healthPercent > 100) {
                                player.animals.get(j).healthPercent = 100;
                            }
                            player.foodNumbers.set(3, (player.foodNumbers.get(3) - 0.3));
                        }
                        numberOfFedDogs++;
                    }
                }
                System.out.println("");
                System.out.println(numberOfFedDogs + " of your " + player.animalNumbers.get(4) + " dog(s) were fully fed.");
                break;
        }
        System.out.println("");
        System.out.println("Would you like to feed another type of animal? (yes/no)");
        Scanner menuScanner = new Scanner(System.in);
        var yesOrNo = menuScanner.nextLine();
        if (yesOrNo.equals("yes")){
            player.feedYourAnimals(player);
        }
        else {
            return; }
    }

    public void matingTime(Player player){
        System.out.println("");
        System.out.println("Pick your male animal to mate:");
        for (var i = 0; i < player.animals.size(); i++){
            if (player.animals.get(i).gender.equals("male")) {
                System.out.println((i+1) + ". Your " + player.animals.get(i).type.toLowerCase() + " named " + player.animals.get(i).name);
            }
        }
        Scanner scan = new Scanner(System.in);
        var maleAnimalNumber = scan.nextInt() - 1;
        System.out.println("");
        System.out.println("Pick your female animal to mate:");
        for (var i = 0; i < player.animals.size(); i++){
            if (player.animals.get(i).gender.equals("female")) {
                System.out.println((i+1) + ". Your " + player.animals.get(i).type.toLowerCase() + " named " + player.animals.get(i).name);
            }
        }
        var femaleAnimalNumber = scan.nextInt() - 1;
        if (player.animals.get(maleAnimalNumber).type.equals(player.animals.get(femaleAnimalNumber).type) &&
                player.animals.get(femaleAnimalNumber).gender.equals("female") &&
                player.animals.get(maleAnimalNumber).gender.equals("male")){
            var matingSuccessful = Math.random();
            System.out.println("");
            if (matingSuccessful > 0.5){
                switch (player.animals.get(maleAnimalNumber).type){
                    case "Fish":
                        var howManyFish = Math.round((Math.random() * 15) + 15);
                        System.out.println("The mating was successful! It resulted in " + howManyFish
                                + " baby fish.");
                        for (var k = 1; k <= howManyFish; k++){
                            System.out.println("");
                            System.out.println("Name baby fish number " + k + ":");
                            Scanner newScanner = new Scanner(System.in);
                            var newName = newScanner.nextLine();
                            player.animals.add(new Fish(newName, setRandomGender()));
                            player.animalNumbers.set(0, (player.animalNumbers.get(0) +1));
                        }
                        break;
                    case "Turtle":
                        var howManyTurtles = Math.round((Math.random() * 8) + 2);
                        System.out.println("The mating was successful! It resulted in " + howManyTurtles
                                + " baby turtles.");
                        for (var k = 1; k <= howManyTurtles; k++){
                            System.out.println("");
                            System.out.println("Name baby turtle number " + k + ":");
                            Scanner newScanner = new Scanner(System.in);
                            var newName = newScanner.nextLine();
                            player.animals.add(new Turtle(newName, setRandomGender()));
                            player.animalNumbers.set(1, (player.animalNumbers.get(1) +1));
                        }
                        break;
                    case "Bunny":
                        var howManyBunnies = Math.round((Math.random() * 13) + 1);
                        System.out.println("The mating was successful! It resulted in " + howManyBunnies
                                + " kits.");
                        for (var k = 1; k <= howManyBunnies; k++){
                            System.out.println("");
                            System.out.println("Name kit number " + k + ":");
                            Scanner newScanner = new Scanner(System.in);
                            var newName = newScanner.nextLine();
                            player.animals.add(new Bunny(newName, setRandomGender()));
                            player.animalNumbers.set(2, (player.animalNumbers.get(2) +1));
                        }
                        break;
                    case "Cat":
                        var howManyChildren = Math.round((Math.random() * 5) + 0.52);
                        System.out.println("The mating was successful! It resulted in " + howManyChildren
                                + " kitten(s).");
                        for (var k = 1; k <= howManyChildren; k++){
                            System.out.println("");
                            System.out.println("Name kitten number " + k + ":");
                            Scanner newScanner = new Scanner(System.in);
                            var newName = newScanner.nextLine();
                            player.animals.add(new Cat(newName, setRandomGender()));
                            player.animalNumbers.set(3, (player.animalNumbers.get(3) +1));
                        }
                        break;
                    case "Dog":
                        var howManyDogs = Math.round((Math.random() * 5) + 0.52);
                        System.out.println("The mating was successful! It resulted in " + howManyDogs
                                + " puppy(/puppies).");
                        for (var k = 1; k <= howManyDogs; k++){
                            System.out.println("");
                            System.out.println("Name puppy number " + k + ":");
                            Scanner newScanner = new Scanner(System.in);
                            var newName = newScanner.nextLine();
                            player.animals.add(new Dog(newName, setRandomGender()));
                            player.animalNumbers.set(4, (player.animalNumbers.get(4) +1));
                        }
                        break;
                }
            }
            else {
                System.out.println("");
                System.out.println("The mating was unsuccessful");
            }
        }
    }

    public String setRandomGender(){
        var genderRandomiser = Math.random();
        var genderString = "";
        if (genderRandomiser < 0.5){
            genderString = "male";
        }
        else if (genderRandomiser > 0.5){
            genderString = "female";
        }
        return genderString;
    }

    public void animalHealth(Player player){
        for (var i = player.animals.size() - 1; i >= 0; i--){
            player.animals.get(i).healthDecrease(player.animals.get(i));
            if (player.animals.get(i).healthPercent <= 0){
                System.out.println("Your " + player.animals.get(i).type + " named "
                        + player.animals.get(i).name + " just died.");
                player.animals.remove(player.animals.get(i));
            }
        }
    }
}
