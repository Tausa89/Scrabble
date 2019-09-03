package pl.scrabbleProject;

import lombok.Data;

public @Data
class Player {

    private String name;
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfLoses;
    private int currentAmountOfPoints;
    private boolean playerTurn = true;
    private Tacka playerLetters;

    public Player(String name, ListOfLetters bagOfLetters) {
        this.name = name;
        this.currentAmountOfPoints = 0;
        this.numberOfWins = 0;
        this.numberOfDraws = 0;
        this.numberOfLoses = 0;
        this.playerLetters = new Tacka(bagOfLetters);

    }
}
