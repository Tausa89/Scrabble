package pl.scrabbleProject;

public class Player {

    private String name;
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfLoses;
    private int currentAmountOfPoints;

    public Player(String name) {
        this.name = name;
        this.currentAmountOfPoints = 0;
    }
}
