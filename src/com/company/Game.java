package com.company;
import com.company.animals.*;
import com.company.foods.*;
import java.util.*;


public class Game {
    private int numberOfRounds;
    public ArrayList<Player> players = new ArrayList<Player>();

    public Game(){
        createNewGame();
    }

    public void createNewGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this game");
        System.out.println("How many players are you?");
        var numberOfPlayers = Integer.parseInt(scanner.nextLine());
        for (var i = 1; i <= numberOfPlayers; i++){
            System.out.println("Player " + i + ", what is your name?");
            var playerName = scanner.nextLine();
            players.add(new Player(playerName));
            System.out.println(playerName);
        }
        for (var player : players){
            player.animalNumbers.add(0, 0);
            player.animalNumbers.add(1, 0);
            player.animalNumbers.add(2, 0);
            player.animalNumbers.add(3, 0);
            player.animalNumbers.add(4, 0);
            player.foodNumbers.add(0, 0.0);
            player.foodNumbers.add(1, 0.0);
            player.foodNumbers.add(2, 0.0);
            player.foodNumbers.add(3, 0.0);
        }
        System.out.println("How many rounds would you like to play? (5-30 rounds acceptable)");
        numberOfRounds = Integer.parseInt(scanner.nextLine());
        if (numberOfRounds < 5 || numberOfRounds > 30) {
            System.out.println("Try again. Acceptable number of rounds are between 5 and 30.");
            numberOfRounds = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(numberOfRounds + " rounds.");
        startGame();
    }

    public void startGame(){
        for (var rounds = 1; rounds <= numberOfRounds; rounds++) {
            System.out.println("Round " + rounds + "/" + numberOfRounds);
            for (var player : players) {
                player.animalHealth(player);
                System.out.println(player.name + ", it is your turn to play!");
                System.out.println("You have " + player.money + " coins left.");
                System.out.println("You have the following animals: " + player.animalNumbers.get(0) + " fish, "
                + player.animalNumbers.get(1) + " turtles, " + player.animalNumbers.get(2) + " bunnies, "
                + player.animalNumbers.get(3) + " cats and " + player.animalNumbers.get(4) + " dogs.");
                System.out.println("You have the following foods: " + player.foodNumbers.get(0) + "kg(s) of fishfood, "
                + player.foodNumbers.get(1) + "kg(s) of carrots, " + player.foodNumbers.get(2) + "kg(s) of catfood and "
                + player.foodNumbers.get(3) + "kg(s) of dogfood.");
                System.out.println("Choose one of the following options:");
                System.out.println("1. Buy animals");
                System.out.println("2. Buy animal foods");
                System.out.println("3. Feed your animals");
                System.out.println("4. Let two of your animals of the same race but different genders mate");
                System.out.println("5. Sell animal(s)");
                Scanner menuScanner = new Scanner(System.in);
                var menuItem = menuScanner.nextInt();

                switch (menuItem) {
                    case 1:
                        buyAnimals(player);
                        break;
                    case 2:
                        buyAnimalFoods(player);
                        break;
                    case 3:
                        player.feedYourAnimals(player);
                    case 4:
                        matingTime(player);
                        break;
                    case 5:
                        sellAnimal(player);
                }

            }
        }
        endGame();
    }

    public void endGame(){
        System.out.println("The game has ended!");
        var currentLeader = "";
        var currentLeaderMoney = -999999999;
        for (var player : players){
            for (var animal : player.animals){
                player.money += animal.price * animal.healthPercent;
            }
            player.animals.clear();
            System.out.println(player.name + " has finally ended up with " + player.money + " coins.");
            if (currentLeaderMoney < player.money){
                currentLeader = player.name;
                currentLeaderMoney = player.money;
            }
        }
        System.out.println("The winner is " + currentLeader + " with " + currentLeaderMoney + " coins!");
        System.out.println("Would you like to play again? (yes/no)");
        Scanner scan = new Scanner(System.in);
        var answer = scan.nextLine();
        if (answer.equals("yes")){
            players.clear();
            createNewGame();
        }
        else {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }

    public void buyAnimals(Player player){
        System.out.println("Which animal would you like to buy?");
        System.out.println("1. Fish, 60 coins each");
        System.out.println("2. Turtles, 200 coins each" );
        System.out.println("3. Bunnies, 600 coins each");
        System.out.println("4. Cats, 2000 coins each");
        System.out.println("5. Dogs, 6000 coins each");

        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();

        switch (menuItem) {
            case 1:
                System.out.println("How many fish would you like to buy?");
                var numberOfFish = scan.nextInt();
                for (var i = 1; i <= numberOfFish; i++){
                    Scanner newScanner = new Scanner(System.in);
                    System.out.println("Name fish " + i + "/" + numberOfFish);
                    var newName = newScanner.nextLine();
                    System.out.println("Choose gender (male or female)");
                    var newGender = newScanner.nextLine();
                    var newFish = new Fish(newName, newGender);
                    player.animals.add(newFish);
                    player.animalNumbers.set(0, (player.animalNumbers.get(0) + 1));
                    player.money = player.money - 60;
                }
                break;
            case 2:
                System.out.println("How many turtles would you like to buy?");
                var numberOfTurtles = scan.nextInt();
                for (var i = 1; i <= numberOfTurtles; i++){
                    Scanner newScanner = new Scanner(System.in);
                    System.out.println("Name turtle " + i + "/" + numberOfTurtles);
                    var newName = newScanner.nextLine();
                    System.out.println("Choose gender (male or female)");
                    var newGender = newScanner.nextLine();
                    player.animals.add(new Turtle(newName, newGender));
                    player.animalNumbers.set(1, (player.animalNumbers.get(1) + 1));
                    player.money = player.money - 200;
                }
                break;
            case 3:
                System.out.println("How many bunnies would you like to buy?");
                var numberOfBunnies = scan.nextInt();
                for (var i = 1; i <= numberOfBunnies; i++){
                    Scanner newScanner = new Scanner(System.in);
                    System.out.println("Name bunny " + i + "/" + numberOfBunnies);
                    var newName = newScanner.nextLine();
                    System.out.println("Choose gender (male or female)");
                    var newGender = newScanner.nextLine();
                    player.animals.add(new Bunny(newName, newGender));
                    player.animalNumbers.set(2, (player.animalNumbers.get(2) + 1));
                    player.money = player.money - 600;
                }
                break;
            case 4:
                System.out.println("How many cats would you like to buy?");
                var numberOfCats = scan.nextInt();
                for (var i = 1; i <= numberOfCats; i++){
                    Scanner newScanner = new Scanner(System.in);
                    System.out.println("Name cat " + i + "/" + numberOfCats);
                    var newName = newScanner.nextLine();
                    System.out.println("Choose gender (male or female)");
                    var newGender = newScanner.nextLine();
                    player.animals.add(new Cat(newName, newGender));
                    player.animalNumbers.set(3, (player.animalNumbers.get(3) + 1));
                    player.money = player.money - 2000;
                }
                break;
            case 5:
                System.out.println("How many dogs would you like to buy?");
                var numberOfDogs = scan.nextInt();
                for (var i = 1; i <= numberOfDogs; i++){
                    Scanner newScanner = new Scanner(System.in);
                    System.out.println("Name dog " + i + "/" + numberOfDogs);
                    var newName = newScanner.nextLine();
                    System.out.println("Choose gender (male or female)");
                    var newGender = newScanner.nextLine();
                    player.animals.add(new Dog(newName, newGender));
                    player.animalNumbers.set(4, (player.animalNumbers.get(4) + 1));
                    player.money = player.money - 6000;
                }
                break;
        }
    }

    public void buyAnimalFoods(Player player){
        System.out.println("Which food would you like to buy?");
        System.out.println("1. Fishfood, 50 coins per kg");
        System.out.println("2. Carrots, 10 coins per kg");
        System.out.println("3. Catfood, 50 coins per kg");
        System.out.println("4. Dogfood, 60 coins per kg");
        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();

        switch (menuItem){
            case 1:
                System.out.println("How many kgs of fishfood would you like to buy?");
                var kgsFishfood = scan.nextInt();
                for (var i = 0; i < kgsFishfood; i++){
                    player.foods.add(new Fishfood());
                    player.foodNumbers.set(0, (player.foodNumbers.get(0)) + 1);
                    player.money = player.money - 50;
                }
                break;
            case 2:
                System.out.println("How many kgs of carrots would you like to buy?");
                var kgsCarrots = scan.nextInt();
                for (var i = 0; i < kgsCarrots; i++){
                    player.foods.add(new Carrot());
                    player.foodNumbers.set(1, (player.foodNumbers.get(1)) + 1);
                    player.money = player.money - 10;
                }
                break;
            case 3:
                System.out.println("How many kgs of catfood would you like to buy?");
                var kgsCatfood = scan.nextInt();
                for (var i = 0; i < kgsCatfood; i++){
                    player.foods.add(new Catfood());
                    player.foodNumbers.set(2, (player.foodNumbers.get(2)) + 1);
                    player.money = player.money - 50;
                }
                break;
            case 4:
                System.out.println("How many kgs of dogfood would you like to buy?");
                var kgsDogfood = scan.nextInt();
                for (var i = 0; i < kgsDogfood; i++){
                    player.foods.add(new Dogfood());
                    player.foodNumbers.set(3, (player.foodNumbers.get(3)) + 1);
                    player.money = player.money - 60;
                }
                break;
        }
    }

    public void matingTimeOld(Player player){
        System.out.println("What kind of animals would you like to mate?");
        System.out.println("1. my fish");
        System.out.println("2. my turtles");
        System.out.println("3. my bunnies");
        System.out.println("4. my cats");
        System.out.println("5. my dogs");
        Scanner scan = new Scanner(System.in);
        var menuItem = scan.nextInt();

        switch (menuItem){
            case 1:
                for (var i = 0; i < player.animals.size(); i++){
                    if (player.animals.get(i).type.equals("Fish") && player.animals.get(i).gender.equals("male")){
                        for (var j = 0; j < player.animals.size(); j++){
                            if (player.animals.get(j).type.equals("Fish") && player.animals.get(j).gender.equals("female")){
                                var matingSuccessful = Math.random();
                                if (matingSuccessful > 0.5){
                                    var howManyChildren = Math.round(Math.random() * 30);
                                    System.out.println("The mating was successful! You now have " + howManyChildren
                                            + " baby fish.");
                                    for (var k = 1; k <= howManyChildren; k++){
                                        System.out.println("Name baby fish number " + k + ":");
                                        var newName = scan.nextLine();
                                        player.animals.add(new Fish(newName, setRandomGender()));
                                        player.animalNumbers.set(0, (player.animalNumbers.get(0) +1));
                                    }

                                }
                                else {
                                    System.out.println("The mating was unsuccessful");
                                    break;
                                }
                            }
                            else {
                                System.out.println("The mating was unsuccessful. You have no female fish.");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("The mating was unsuccessful. You have no male fish.");
                        break;
                    }
                }
            case 2:
                for (var i = 0; i < player.animals.size(); i++){
                    if (player.animals.get(i).type.equals("Turtle") && player.animals.get(i).gender.equals("male")){
                        for (var j = 0; j < player.animals.size(); j++){
                            if (player.animals.get(j).type.equals("Turtle") && player.animals.get(j).gender.equals("female")){
                                var matingSuccessful = Math.random();
                                if (matingSuccessful > 0.5){
                                    var howManyChildren = Math.round(Math.random() * 15);
                                    System.out.println("The mating was successful! You now have " + howManyChildren
                                            + " baby turtle(s).");
                                    for (var k = 1; k <= howManyChildren; k++){
                                        System.out.println("Name baby turtle number " + k + ":");
                                        var newName = scan.nextLine();
                                        player.animals.add(new Turtle(newName, setRandomGender()));
                                        player.animalNumbers.set(1, (player.animalNumbers.get(1) +1));
                                    }

                                }
                                else {
                                    System.out.println("The mating was unsuccessful");
                                    break;
                                }
                            }
                            else {
                                System.out.println("The mating was unsuccessful. You have no female turtle.");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("The mating was unsuccessful. You have no male turtle.");
                        break;
                    }
                }
            case 3:
                for (var i = 0; i < player.animals.size(); i++){
                    if (player.animals.get(i).type.equals("Bunny") && player.animals.get(i).gender.equals("male")){
                        for (var j = 0; j < player.animals.size(); j++){
                            if (player.animals.get(j).type.equals("Bunny") && player.animals.get(j).gender.equals("female")){
                                var matingSuccessful = Math.random();
                                if (matingSuccessful > 0.5){
                                    var howManyChildren = Math.round(Math.random() * 10);
                                    System.out.println("The mating was successful! You now have " + howManyChildren
                                            + " baby bunny(/bunnies).");
                                    for (var k = 1; k <= howManyChildren; k++){
                                        System.out.println("Name baby bunny number " + k + ":");
                                        var newName = scan.nextLine();
                                        player.animals.add(new Bunny(newName, setRandomGender()));
                                        player.animalNumbers.set(2, (player.animalNumbers.get(2) +1));
                                    }

                                }
                                else {
                                    System.out.println("The mating was unsuccessful");
                                    break;
                                }
                            }
                            else {
                                System.out.println("The mating was unsuccessful. You have no female bunny.");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("The mating was unsuccessful. You have no male bunny.");
                        break;
                    }
                }
            case 4:
                for (var i = 0; i < player.animals.size(); i++){
                    if (player.animals.get(i).type.equals("Cat") && player.animals.get(i).gender.equals("male")){
                        for (var j = 0; j < player.animals.size(); j++){
                            if (player.animals.get(j).type.equals("Cat") && player.animals.get(j).gender.equals("female")){
                                var matingSuccessful = Math.random();
                                if (matingSuccessful > 0.5){
                                    var howManyChildren = Math.round((Math.random() * 5) + 0.52);
                                    System.out.println("The mating was successful! It resulted in " + howManyChildren
                                            + " kitten(s).");
                                    for (var k = 1; k <= howManyChildren; k++){
                                        System.out.println("Name kitten number " + k + ":");
                                        Scanner newScanner = new Scanner(System.in);
                                        var newName = newScanner.nextLine();
                                        player.animals.add(new Cat(newName, setRandomGender()));
                                        player.animalNumbers.set(3, (player.animalNumbers.get(3) +1));
                                    }
                                    break;
                                }
                                else {
                                    System.out.println("The mating was unsuccessful");
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 5:
                for (var i = 0; i < player.animals.size(); i++){
                    if (player.animals.get(i).type.equals("Dog") && player.animals.get(i).gender.equals("male")){
                        for (var j = 0; j < player.animals.size(); j++){
                            if (player.animals.get(j).type.equals("Dog") && player.animals.get(j).gender.equals("female")){
                                var matingSuccessful = Math.random();
                                if (matingSuccessful > 0.5){
                                    var howManyChildren = Math.round(Math.random() * 5);
                                    System.out.println("The mating was successful! You now have " + howManyChildren
                                            + " puppies.");
                                    for (var k = 1; k <= howManyChildren; k++){
                                        System.out.println("Name puppy number " + k + ":");
                                        var newName = scan.nextLine();
                                        player.animals.add(new Dog(newName, setRandomGender()));
                                        player.animalNumbers.set(4, (player.animalNumbers.get(4) +1));
                                    }

                                }
                                else {
                                    System.out.println("The mating was unsuccessful");
                                    break;
                                }
                            }
                            else {
                                System.out.println("The mating was unsuccessful. You have no female dog.");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("The mating was unsuccessful. You have no male dog.");
                        break;
                    }
                }
        }
    }

    public void matingTime(Player player){
        System.out.println("Pick your male animal to mate:");
        for (var i = 0; i < player.animals.size(); i++){
            if (player.animals.get(i).gender.equals("male")) {
                System.out.println((i+1) + ". Your " + player.animals.get(i).type + " named " + player.animals.get(i).name);
            }
        }
        Scanner scan = new Scanner(System.in);
        var maleAnimalNumber = scan.nextInt() - 1;
        System.out.println("Pick your female animal to mate:");
        for (var i = 0; i < player.animals.size(); i++){
            if (player.animals.get(i).gender.equals("female")) {
                System.out.println((i+1) + ". Your " + player.animals.get(i).type + " named " + player.animals.get(i).name);
            }
        }
        var femaleAnimalNumber = scan.nextInt() - 1;
        if (player.animals.get(maleAnimalNumber).type.equals(player.animals.get(femaleAnimalNumber).type)){
            var matingSuccessful = Math.random();
            if (matingSuccessful > 0.5){
                switch (player.animals.get(maleAnimalNumber).type){
                    case "Fish":
                        var howManyFish = Math.round((Math.random() * 15) + 15);
                        System.out.println("The mating was successful! It resulted in " + howManyFish
                                + " baby fish.");
                        for (var k = 1; k <= howManyFish; k++){
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
                System.out.println("The mating was unsuccessful");
            }
        }
    }

    public void sellAnimal(Player player){
        System.out.println("Which animal would you like to sell?");
        for (var i = 0; i < player.animals.size(); i++){
            System.out.println((i+1) + ". Your " + player.animals.get(i).type + " named " + player.animals.get(i).name
                    + " with the health percent " + player.animals.get(i).healthPercent + "/1");
        }
        Scanner scan = new Scanner(System.in);
        var animalNumber = scan.nextInt();
        player.money += player.animals.get(animalNumber - 1).price * player.animals.get(animalNumber - 1).healthPercent;
        Math.round(player.money);
        System.out.println("A " + player.animals.get(animalNumber - 1).type + " named "
                + player.animals.get(animalNumber - 1).name + " sold for " + Math.round(player.animals.get(animalNumber - 1).price
        * player.animals.get(animalNumber - 1).healthPercent) + ".");
        player.animals.remove(animalNumber - 1);
        System.out.println("Would you like to sell another animal? (yes/no)");
        Scanner newScanner = new Scanner(System.in);
        var answer = newScanner.nextLine();
        if (answer.equals("yes")){
            sellAnimal(player);
        }
        else {
            return;
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

}
