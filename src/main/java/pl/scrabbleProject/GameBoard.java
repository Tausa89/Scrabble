package pl.scrabbleProject;

import lombok.Getter;

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

    public String addLetter(int posX, int posY, Letters letter, Tacka playerListOfLetter, ListOfLetters bagOfLetters){

        StringBuilder word = new StringBuilder();
        while (playerListOfLetter.getPlayerListOfLetters().contains(letter)) {
            this.gameBoard[posX][posY] = letter;
            HelperMethods.removeLetterFromTacka(playerListOfLetter.getPlayerListOfLetters(),letter);
            word.append(letter.getLetter());
        }
        HelperMethods.drawNewLetter(playerListOfLetter.getPlayerListOfLetters(), bagOfLetters);

        return word.toString();
    }



}
