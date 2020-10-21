package com.company;
import com.company.animals.*;
import com.company.foods.*;
import java.util.*;

public class Store {

    public Store(){
    }

    public void sellAnimals(Player player){
        System.out.println("");
        System.out.println("Which animal would you like to buy?");
        System.out.println("1. Fish, 60 coins each");
        System.out.println("2. Turtles, 200 coins each" );
        System.out.println("3. Bunnies, 600 coins each");
        System.out.println("4. Cats, 2000 coins each");
        System.out.println("5. Dogs, 6000 coins each");

        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();
        System.out.println("");

        switch (menuItem) {
            case 1:
                System.out.println("How many fish would you like to buy?");
                var numberOfFish = scan.nextInt();
                if (player.money > numberOfFish * 60) {
                    for (var i = 1; i <= numberOfFish; i++) {
                        Scanner newScanner = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Name fish " + i + "/" + numberOfFish);
                        var newName = newScanner.nextLine();
                        System.out.println("");
                        System.out.println("Choose gender (male or female)");
                        var newGender = newScanner.nextLine().toLowerCase();
                        var newFish = new Fish(newName, newGender);
                        player.animals.add(newFish);
                        player.animalNumbers.set(0, (player.animalNumbers.get(0) + 1));
                        player.money = player.money - 60;
                    }
                }
                else {
                    System.out.println("You didn't bring enough coins. Would you like to try again?");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimals(player);
                    }
                    break;
                }
                break;
            case 2:
                System.out.println("How many turtles would you like to buy?");
                var numberOfTurtles = scan.nextInt();
                if (player.money > numberOfTurtles * 200) {
                    for (var i = 1; i <= numberOfTurtles; i++) {
                        Scanner newScanner = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Name turtle " + i + "/" + numberOfTurtles);
                        var newName = newScanner.nextLine();
                        System.out.println("");
                        System.out.println("Choose gender (male or female)");
                        var newGender = newScanner.nextLine().toLowerCase();
                        player.animals.add(new Turtle(newName, newGender));
                        player.animalNumbers.set(1, (player.animalNumbers.get(1) + 1));
                        player.money = player.money - 200;
                    }
                }
                else {
                    System.out.println("You didn't bring enough coins. Would you like to try again?");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimals(player);
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("How many bunnies would you like to buy?");
                var numberOfBunnies = scan.nextInt();
                if (player.money > numberOfBunnies * 600) {
                    for (var i = 1; i <= numberOfBunnies; i++) {
                        Scanner newScanner = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Name bunny " + i + "/" + numberOfBunnies);
                        var newName = newScanner.nextLine();
                        System.out.println("");
                        System.out.println("Choose gender (male or female)");
                        var newGender = newScanner.nextLine().toLowerCase();
                        player.animals.add(new Bunny(newName, newGender));
                        player.animalNumbers.set(2, (player.animalNumbers.get(2) + 1));
                        player.money = player.money - 600;
                    }
                }
                else {
                    System.out.println("You didn't bring enough coins. Would you like to try again?");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimals(player);
                    }
                    break;
                }
                break;
            case 4:
                System.out.println("How many cats would you like to buy?");
                var numberOfCats = scan.nextInt();
                if (player.money > numberOfCats * 2000) {
                    for (var i = 1; i <= numberOfCats; i++) {
                        Scanner newScanner = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Name cat " + i + "/" + numberOfCats);
                        var newName = newScanner.nextLine();
                        System.out.println("");
                        System.out.println("Choose gender (male or female)");
                        var newGender = newScanner.nextLine().toLowerCase();
                        player.animals.add(new Cat(newName, newGender));
                        player.animalNumbers.set(3, (player.animalNumbers.get(3) + 1));
                        player.money = player.money - 2000;
                    }
                }
                else {
                    System.out.println("You didn't bring enough coins. Would you like to try again?");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimals(player);
                    }
                    break;
                }
                break;
            case 5:
                System.out.println("How many dogs would you like to buy?");
                var numberOfDogs = scan.nextInt();
                if (player.money > numberOfDogs * 6000) {
                    for (var i = 1; i <= numberOfDogs; i++) {
                        Scanner newScanner = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Name dog " + i + "/" + numberOfDogs);
                        var newName = newScanner.nextLine();
                        System.out.println("");
                        System.out.println("Choose gender (male or female)");
                        var newGender = newScanner.nextLine().toLowerCase();
                        player.animals.add(new Dog(newName, newGender));
                        player.animalNumbers.set(4, (player.animalNumbers.get(4) + 1));
                        player.money = player.money - 6000;
                    }
                }
                else {
                    System.out.println("You didn't bring enough coins. Would you like to try again?");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimals(player);
                    }
                    break;
                }
                break;
        }
    }

    public void sellAnimalFoods(Player player){
        System.out.println("");
        System.out.println("Which food would you like to buy?");
        System.out.println("1. Fishfood, 50 coins per kg");
        System.out.println("2. Carrots, 10 coins per kg");
        System.out.println("3. Catfood, 100 coins per kg");
        System.out.println("4. Dogfood, 150 coins per kg");
        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();
        System.out.println("");

        switch (menuItem){
            case 1:
                System.out.println("How many kgs of fishfood would you like to buy?");
                var kgsFishfood = scan.nextInt();
                if (player.money > kgsFishfood * 50) {
                    for (var i = 0; i < kgsFishfood; i++) {
                        player.foods.add(new Fishfood());
                        player.foodNumbers.set(0, (player.foodNumbers.get(0)) + 1);
                        player.money = player.money - 50;
                    }
                }
                else {
                    System.out.println("");
                    System.out.println("You didn't bring enough coins. Would you like to try again? (yes/no)");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimalFoods(player);
                    }
                    break;
                }
                break;
            case 2:
                System.out.println("How many kgs of carrots would you like to buy?");
                var kgsCarrots = scan.nextInt();
                if (player.money > kgsCarrots * 10) {
                    for (var i = 0; i < kgsCarrots; i++) {
                        player.foods.add(new Carrot());
                        player.foodNumbers.set(1, (player.foodNumbers.get(1)) + 1);
                        player.money = player.money - 10;
                    }
                }
                else {
                    System.out.println("");
                    System.out.println("You didn't bring enough coins. Would you like to try again? (yes/no)");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimalFoods(player);
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("How many kgs of catfood would you like to buy?");
                var kgsCatfood = scan.nextInt();
                if (player.money > kgsCatfood * 100) {
                    for (var i = 0; i < kgsCatfood; i++) {
                        player.foods.add(new Catfood());
                        player.foodNumbers.set(2, (player.foodNumbers.get(2)) + 1);
                        player.money = player.money - 100;
                    }
                }
                else {
                    System.out.println("");
                    System.out.println("You didn't bring enough coins. Would you like to try again? (yes/no)");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimalFoods(player);
                    }
                    break;
                }
                break;
            case 4:
                System.out.println("How many kgs of dogfood would you like to buy?");
                var kgsDogfood = scan.nextInt();
                if (player.money > kgsDogfood * 150) {
                    for (var i = 0; i < kgsDogfood; i++) {
                        player.foods.add(new Dogfood());
                        player.foodNumbers.set(3, (player.foodNumbers.get(3)) + 1);
                        player.money = player.money - 150;
                    }
                }
                else {
                    System.out.println("");
                    System.out.println("You didn't bring enough coins. Would you like to try again? (yes/no)");
                    Scanner finalScan = new Scanner(System.in);
                    var option = finalScan.nextLine().toLowerCase();
                    if (option.equals("yes")) {
                        System.out.println("");
                        sellAnimalFoods(player);
                    }
                    break;
                }
                break;
        }
    }

    public void buyAnimal(Player player){
        System.out.println("");
        System.out.println("Which animal would you like to sell?");
        for (var i = 0; i < player.animals.size(); i++){
            System.out.println((i+1) + ". Your " + player.animals.get(i).type + " named " + player.animals.get(i).name
                    + " with the health percent " + player.animals.get(i).healthPercent + "/100");
        }
        Scanner scan = new Scanner(System.in);
        var animalNumber = scan.nextInt();
        System.out.println("");
        try {
            player.money += player.animals.get(animalNumber - 1).price * (player.animals.get(animalNumber - 1).healthPercent * 0.01);
            Math.round(player.money);
            System.out.println("A " + player.animals.get(animalNumber - 1).type + " named "
                    + player.animals.get(animalNumber - 1).name + " sold for " + Math.round(player.animals.get(animalNumber - 1).price
                    * (player.animals.get(animalNumber - 1).healthPercent * 0.01)) + ".");
            switch (player.animals.get(animalNumber -1).type){
                case "Fish":
                    player.animalNumbers.set(0, player.animalNumbers.get(0) -1);
                    break;
                case "Turtle":
                    player.animalNumbers.set(1, player.animalNumbers.get(1) -1);
                    break;
                case "Bunny":
                    player.animalNumbers.set(2, player.animalNumbers.get(2) -1);
                    break;
                case "Cat":
                    player.animalNumbers.set(3, player.animalNumbers.get(3) -1);
                    break;
                case "Dog":
                    player.animalNumbers.set(4, player.animalNumbers.get(4) -1);
                    break;
            }
            player.animals.remove(animalNumber - 1);
        }
        catch (Exception wrongNumber){
            System.out.println("");
            System.out.println("Transaction failed.");
        }
        System.out.println("");
        System.out.println("Would you like to sell another animal? (yes/no)");
        Scanner newScanner = new Scanner(System.in);
        var answer = newScanner.nextLine().toLowerCase();
        if (answer.equals("yes")){
            buyAnimal(player);
        }
    }
}
