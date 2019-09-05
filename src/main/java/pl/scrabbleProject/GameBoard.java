package pl.scrabbleProject;

import lombok.Getter;

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

//    public List<Letters> addLetter(int posX, int posY, Letters letter, Tacka playerListOfLetter, ListOfLetters bagOfLetters) {
//
//        List<Letters> word = new ArrayList<>();
//        while (playerListOfLetter.getPlayerListOfLetters().contains(letter)) {
//            this.gameBoard[posX][posY] = letter;
//            HelperMethods.removeLetterFromTacka(playerListOfLetter.getPlayerListOfLetters(),letter);
//            word.add(letter);
//        }
//        HelperMethods.drawNewLetter(playerListOfLetter.getPlayerListOfLetters(), bagOfLetters);
//
//        return word;
//    }

    public int countPoints(List<Letters> word) {
        int numberOfPoints = 0;
        for (int i = 0; i < word.size(); i++) {
            numberOfPoints += word.get(i).getPointsForLetter();
        }
        return numberOfPoints;
    }

//    public List<Letters> addLetter(Tacka listOfLetters, ListOfLetters bagOfLetters) {
//        Scanner input = new Scanner(System.in);
//        List<Letters> word = new ArrayList<>();
//        while (true) {
//            System.out.println("cord x");
//            int posX = Integer.parseInt(input.nextLine());
//            if (posX == 16) {
//                break;
//            }
//            System.out.println("cord y");
//            int posY = Integer.parseInt(input.nextLine());
//            System.out.println("Wrote a letter");
//            char letter = input.nextLine().toUpperCase().charAt(0);
//            for (int i = 0; i < listOfLetters.getPlayerListOfLetters().size(); i++) {
//                if (listOfLetters.getPlayerListOfLetters().get(i).getLetter() == letter) {
//                    this.gameBoard[posX][posY] = listOfLetters.getPlayerListOfLetters().get(i);
//                    word.add(listOfLetters.getPlayerListOfLetters().get(i));
//                    HelperMethods.removeLetterFromTacka(listOfLetters.getPlayerListOfLetters(), listOfLetters.getPlayerListOfLetters().get(i));
//
//                }
//            }
//        }
//        HelperMethods.drawNewLetter(listOfLetters.getPlayerListOfLetters(), bagOfLetters);
//        return word;
//    }


//    public List<Letters> addLetter(int posX, int posY, char letter, Tacka playerListOfLetter, ListOfLetters bagOfLetters) {
//
//        List<Letters> word = new ArrayList<>();
//        for (int i = 0; i < playerListOfLetter.getPlayerListOfLetters().size(); i++) {
//            if (playerListOfLetter.getPlayerListOfLetters().get(i).getLetter() == letter) {
//                this.gameBoard[posX][posY] = playerListOfLetter.getPlayerListOfLetters().get(i);
//                word.add(playerListOfLetter.getPlayerListOfLetters().get(i));
//                HelperMethods.removeLetterFromTacka(playerListOfLetter.getPlayerListOfLetters(), playerListOfLetter.getPlayerListOfLetters().get(i));
//
//            }
//        }
//        HelperMethods.drawNewLetter(playerListOfLetter.getPlayerListOfLetters(), bagOfLetters);
//
//        return word;
//    }

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
