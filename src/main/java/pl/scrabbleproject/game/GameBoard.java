package pl.scrabbleproject.game;

import lombok.Getter;
import pl.scrabbleproject.game.dto.AddLetterObject;

import java.util.List;

public class GameBoard {

    private @Getter
    Letters[][] gameBoard;


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
        if (playerListOfLetter.remove(letter)) {
            this.gameBoard[posX][posY] = new Letters(letter);
            return true;
        }

        /*char addedLetter = 'x';
        for (Letters letterToAdd : playerListOfLetter.getPlayerListOfLetters()) {
            if (letterToAdd.getLetter() == letter) {
                addedLetter = letterToAdd.getLetter();
                HelperMethods.removeLetterFromTacka(playerListOfLetter.getPlayerListOfLetters(), letterToAdd);
            }
        }*/

        return false;
    }

    public void removeAddedLetter(int posX, int posY, pl.scrabbleproject.game.Player player, GameBoard board) {

        if (board.getGameBoard()[posX][posY] != null) {
            player.getPlayerLetters().getPlayerListOfLetters().add(board.getGameBoard()[posX][posY]);
            board.getGameBoard()[posX][posY] = null;
        }

    }


}
