package pl.scrabbleproject.game;

import lombok.Getter;
import pl.scrabbleproject.game.dto.AddLetterObject;

import java.util.List;

public class GameBoard {

    @Getter
    private Letters[][] gameBoard;


    public GameBoard() {
        this.gameBoard = new Letters[15][15];

    }


    public void print() {

        for (int i = 0; i < 15; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) {
                System.out.print(" ");
                if (this.gameBoard[i][j] == null) {
                    System.out.print(".");
                } else
                    System.out.print(this.gameBoard[i][j].toString());
            }
        }
        System.out.println();
    }


    public int countPoints(List<Letters> word) {
        int numberOfPoints = 0;
        for (Letters points : word) {
            numberOfPoints += points.getPointsForLetter();
        }
        return numberOfPoints;
    }

    public boolean addLetter(AddLetterObject addLetterObject, Rack playerListOfLetter) {
        return addLetter(addLetterObject.getPosX(), addLetterObject.getPosY(), addLetterObject.getLetter(), playerListOfLetter);
    }

    public boolean addLetter(int posX, int posY, char letter, Rack playerListOfLetter) {

        if (this.gameBoard[posX][posY] == null) {
            for (Letters letterToAdd : playerListOfLetter.getPlayerListOfLetters()) {
                if (letter == letterToAdd.getLetter()) {
                    this.gameBoard[posX][posY] = new Letters(letter);
                    HelperMethods.removeLetterFromTacka(playerListOfLetter.getPlayerListOfLetters(), letterToAdd);
                    return true;
                }

            }
            System.out.println("You don't have this letter try again");
            return false;
        }
        System.out.println("There is already letter on this position, pleas try again");
        return false;

    }

    public void removeAddedLetter(int posX, int posY, Player player, GameBoard board) {

        if (board.getGameBoard()[posX][posY] != null) {
            player.getPlayerLetters().getPlayerListOfLetters().add(board.getGameBoard()[posX][posY]);
            board.getGameBoard()[posX][posY] = null;
        }

    }

    public void clearBoard() {
        this.gameBoard = new Letters[15][15];
    }


    public void setAllLetterIsNewFiledToFalse() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (gameBoard[i][j] != null) {
                    gameBoard[i][j].setNew(false);
                }
            }
        }
    }

    public int countingPoints() {
        int points = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (gameBoard[i][j] != null && gameBoard[i][j].isNew()) {
                    points += gameBoard[i][j].getPointsForLetter();
                }
            }
        }
        return points;
    }


}
