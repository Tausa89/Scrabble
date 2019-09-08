package pl.scrabbleProject;

import lombok.Getter;

import java.util.List;

public class GameBoard {

    private @Getter Letters[][] gameBoard;


    public GameBoard() {
        this.gameBoard = new Letters[15][15];

    }

    public void print() {

        for(int i = 0; i < 15; i++){
            System.out.println();
            for (int j = 0; j <15; j++){
                System.out.print(" ");
                if(this.gameBoard[i][j]==null){
                    System.out.print(".");
                }else
                    System.out.print(this.gameBoard[i][j].toString());
            }
        }
    }


    public int countPoints(List<Letters> word) {
        int numberOfPoints = 0;
        for (int i = 0; i < word.size(); i++) {
            numberOfPoints += word.get(i).getPointsForLetter();
        }
        return numberOfPoints;
    }


    public char addLetter(int posX, int posY, char letter, Tacka playerListOfLetter) {


        char addedLetter = 'x';
        for (int i = 0; i < playerListOfLetter.getPlayerListOfLetters().size(); i++) {
            if (playerListOfLetter.getPlayerListOfLetters().get(i).getLetter() == letter) {
                this.gameBoard[posX][posY] = playerListOfLetter.getPlayerListOfLetters().get(i);
                addedLetter = playerListOfLetter.getPlayerListOfLetters().get(i).getLetter();
                HelperMethods.removeLetterFromTacka(playerListOfLetter.getPlayerListOfLetters(), playerListOfLetter.getPlayerListOfLetters().get(i));

            }
        }

        return addedLetter;
    }


}
