package pl.scrabbleproject.game;

import lombok.Data;

public @Data
class Player {

    private String name;
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfLoses;
    private int currentAmountOfPoints;
    private boolean playerTurn = true;
    private Rack playerLetters;

    public Player(String name, ListOfLetters bagOfLetters) {
        this.name = name;
        this.currentAmountOfPoints = 0;
        this.numberOfWins = 0;
        this.numberOfDraws = 0;
        this.numberOfLoses = 0;
        this.playerLetters = new Rack(bagOfLetters);

    }

    public Player(String name) {
        this.name = name;
        this.currentAmountOfPoints = 0;
        this.numberOfWins = 0;
        this.numberOfDraws = 0;
        this.numberOfLoses = 0;
        this.playerLetters = new Rack();
    }

    @Override
    public String toString() {
        return name.toUpperCase() + "\n" +
                " Current amount of points " + currentAmountOfPoints + "\n" +
                " Number of wins = " + numberOfWins + "\n" +
                " Number of draws = " + numberOfDraws + "\n" +
                " Number of loses = " + numberOfLoses + "\n";

//                "name='" + name + '\'' +
//                ", numberOfWins=" + numberOfWins +
//                ", numberOfDraws=" + numberOfDraws +
//                ", numberOfLoses=" + numberOfLoses +
//                ", currentAmountOfPoints=" + currentAmountOfPoints +
//                ", playerTurn=" + playerTurn +
//                ", playerLetters=" + playerLetters +
//                '}';
    }
}
