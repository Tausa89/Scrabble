package pl.scrabbleProject;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private @Getter Letters[][] gameBoard;

    public GameBoard() {
        this.gameBoard = new Letters[15][15];

    }

    public void printScrabbleBoard(){
        for(int i = 0; i < 15; i++){
            System.out.print("\n");

            for (int j = 0; j <15; j++){
                System.out.print(" ");
                if(this.gameBoard[i][j]==null){
                    System.out.print(".");
                }else
                    System.out.print(this.gameBoard[i][j].toString());
            }
        }
    }

    public void addingLetter(int posX, int posY, Letters letter,Tacka playerListOfLetter, ListOfLetters bagOfLetters){

        StringBuilder word = new StringBuilder();
        List<Letters> playerList = playerListOfLetter.creatingPlayerList(bagOfLetters);
        if (playerList.contains(letter)){
            this.gameBoard[posX][posY] = letter;
            playerList.remove(letter);

        }
        word.append(letter.getLetter());
    }



}
