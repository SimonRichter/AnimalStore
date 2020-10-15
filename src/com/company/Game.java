package com.company;
import java.util.*;


public class Game {
    private int numberOfRounds;
    public ArrayList<Player> players = new ArrayList<Player>();
    public Store store = new Store();

    public Game(){
        createNewGame();
    }

    public void createNewGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n".repeat(60));
        System.out.println("Welcome to this game");
        System.out.println("How many players are you?");
        var numberOfPlayers = Integer.parseInt(scanner.nextLine());
        System.out.println("");
        for (var i = 1; i <= numberOfPlayers; i++){
            System.out.println("Player " + i + ", what is your name?");
            var playerName = scanner.nextLine();
            players.add(new Player(playerName));
            System.out.println("");
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
        startGame();
    }

    public void startGame(){
        for (var rounds = 1; rounds <= numberOfRounds; rounds++) {
            System.out.println("");
            System.out.println("Round " + rounds + "/" + numberOfRounds);
            for (var player : players) {
                System.out.println("");
                System.out.println(player.name + ", it is your turn to play!");
                System.out.println("You have " + player.money + " coins left.");
                System.out.println("You have the following animals: " + player.animalNumbers.get(0) + " fish, "
                + player.animalNumbers.get(1) + " turtles, " + player.animalNumbers.get(2) + " bunnies, "
                + player.animalNumbers.get(3) + " cats and " + player.animalNumbers.get(4) + " dogs.");
                System.out.println("You have the following foods: " + player.foodNumbers.get(0) + "kg(s) of fishfood, "
                + player.foodNumbers.get(1) + "kg(s) of carrots, " + player.foodNumbers.get(2) + "kg(s) of catfood and "
                + player.foodNumbers.get(3) + "kg(s) of dogfood.");
                player.animalHealth(player);
                System.out.println("");
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
                        store.sellAnimals(player);
                        break;
                    case 2:
                        store.sellAnimalFoods(player);
                        break;
                    case 3:
                        player.feedYourAnimals(player);
                        break;
                    case 4:
                        player.matingTime(player);
                        break;
                    case 5:
                        store.buyAnimal(player);
                        break;
                }
            }
            checkIfNoMoneyAndNoAnimals();
        }
        endGame();
    }

    public void checkIfNoMoneyAndNoAnimals(){
        for (var i = players.size() - 1; i >= 0; i--){
            if (players.get(i).money <= 0 && players.get(i).animals.isEmpty()){
                System.out.println("");
                System.out.println("Player named " + players.get(i).name
                        + " has no more money or animals and has therefore lost.");
                players.remove(i);
            }
        }
        if (players.size() == 1){
            endGame();
        }
    }

    public void endGame(){
        System.out.println("");
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
        System.out.println("");
        System.out.println("The winner is " + currentLeader + " with " + currentLeaderMoney + " coins!");
        System.out.println("");
        System.out.println("Would you like to play again? (yes/no)");
        Scanner scan = new Scanner(System.in);
        var answer = scan.nextLine();
        if (answer.equals("yes")){
            players.clear();
            createNewGame();
        }
        else {
            System.out.println("");
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }
}
