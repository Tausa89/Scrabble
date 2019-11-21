package pl.scrabbleproject.game;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "playersData")
public class Player {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "id")
    private int playerId;
    private String name;
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfLoses;
    @Transient
    private int currentAmountOfPoints;
    @Transient
    private boolean playerTurn = true;
    @Transient
    private Rack playerLetters;

    public Player() {

    }

    public Player(String name, int numberOfWins, int numberOfDraws, int numberOfLoses) {
        this.name = name;
        this.numberOfWins = numberOfWins;
        this.numberOfDraws = numberOfDraws;
        this.numberOfLoses = numberOfLoses;
    }

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

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfLoses() {
        return numberOfLoses;
    }

    public void setNumberOfLoses(int numberOfLoses) {
        this.numberOfLoses = numberOfLoses;
    }

    public void setPlayerLetters() {
        this.playerLetters = new Rack();
    }
}
