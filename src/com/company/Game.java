package com.company;
import java.util.*;


public class Game {
    private int numberOfRounds;
    public ArrayList<Player> players = new ArrayList<Player>();

    public Game(){
        createNewGame();
        startGame();

    }

    public void createNewGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this game");
        System.out.println("How many players are you?");
        var numberOfPlayers = scanner.nextInt();
        for (var i = 0; i < numberOfPlayers + 1; i++){
            if (i>0){System.out.println("Player " + i + ", what is your name?");}
            var playerName = scanner.nextLine();
            players.add(new Player(playerName));
            System.out.println(playerName);
        }
        System.out.println("How many rounds would you like to play? (5-30 rounds acceptable)");
        numberOfRounds = scanner.nextInt();
        if (numberOfRounds < 5 || numberOfRounds > 30) {
            System.out.println("Try again. Acceptable number of rounds are between 5 and 30.");
            numberOfRounds = scanner.nextInt();
        }
        System.out.println(numberOfRounds + " rounds.");
    }

    public void startGame(){
    for (var player : players){
        System.out.println(player.name + ", it is your turn to play!");
        System.out.println("You have " + player.money + " coins left.");
        System.out.println("You have the following animals: " + player.animals);
        System.out.println("You have the following foods: " + player.foods);
        System.out.println("Choose one option of the following:");
        System.out.println("1. Buy animals");
        System.out.println("2. Buy animal foods");
        System.out.println("3. Feed your animals");
        System.out.println("4. Let two of your animals mate");
        Scanner menuScanner = new Scanner(System.in);
        var menuItem = menuScanner.nextInt();

        switch (menuItem) {
            case 1:
                buyAnimals(player);
                break;
            case 2:
                //buyAnimalFoods();
                break;
            case 3:
                //feedYourAnimals();
                break;
            case 4:
                //matingTime();
                break;
        }

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
                for (var i = 0; i < numberOfFish; i++){
                    var newFish = new Fish("Gustav");
                    player.animals.add(newFish);
                    player.money = player.money - 60;
                }
                break;
            case 2:
                System.out.println("How many turtles would you like to buy?");
                var numberOfTurtles = scan.nextInt();
                for (var i = 0; i < numberOfTurtles; i++){
                    player.animals.add(new Turtle("Dante"));
                    player.money = player.money - 200;
                }
                break;
            case 3:
                System.out.println("How many bunnies would you like to buy?");
                var numberOfBunnies = scan.nextInt();
                for (var i = 0; i < numberOfBunnies; i++){
                    player.animals.add(new Bunny("Carl"));
                    player.money = player.money - 600;
                }
                break;
            case 4:
                System.out.println("How many cats would you like to buy?");
                var numberOfCats = scan.nextInt();
                for (var i = 0; i < numberOfCats; i++){
                    player.animals.add(new Cat("Felicia"));
                    player.money = player.money - 2000;
                }
                break;
            case 5:
                System.out.println("How many dogs would you like to buy?");
                var numberOfDogs = scan.nextInt();
                for (var i = 0; i < numberOfDogs; i++){
                    player.animals.add(new Dog("Dennis"));
                    player.money = player.money - 6000;
                }
                break;
        }
    }
}
