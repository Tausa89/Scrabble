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
    private pl.scrabbleproject.game.Rack playerLetters;

    public Player(String name, pl.scrabbleproject.game.ListOfLetters bagOfLetters) {
        this.name = name;
        this.currentAmountOfPoints = 0;
        this.numberOfWins = 0;
        this.numberOfDraws = 0;
        this.numberOfLoses = 0;
        this.playerLetters = new pl.scrabbleproject.game.Rack(bagOfLetters);

    }

    public Player(String name) {
        this.name = name;
        this.currentAmountOfPoints = 0;
        this.numberOfWins = 0;
        this.numberOfDraws = 0;
        this.numberOfLoses = 0;
        this.playerLetters = new pl.scrabbleproject.game.Rack();
    }

}
