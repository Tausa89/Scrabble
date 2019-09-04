package pl.scrabbleProject;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {

    private @Getter
    int posX;
    private @Getter
    int posY;
    private @Getter
    char letter;
    private Scanner input = new Scanner(System.in);

    public void addLetterMenu() {

        char temp;

        do {
            System.out.println("Enter coordinates of of your letter starting from row number ");
            this.posX = Integer.parseInt(input.nextLine());
            System.out.println("Enter column number ");
            this.posY = Integer.parseInt(input.nextLine());
            System.out.println("Please enter the letter you want to add");
            this.letter = input.nextLine().toUpperCase().charAt(0);
            System.out.println("If you want to end write : e to stop or c to continue");
            temp = input.nextLine().toUpperCase().charAt(0);
        } while (temp != 'E');

    }

    public int choseNumberOfPlayers() {

        int numberOfPlayers;
        System.out.println("Chose number of players between 2 to 4");
        numberOfPlayers = Integer.parseInt(input.nextLine());
        return numberOfPlayers;
    }

    public String chosePlayerName() {

        String playerName;
        System.out.println("Write Your name");
        playerName = input.nextLine();
        return playerName;
    }


    public List<Character> choseLettersToExchange() {

        List<Character> lettersToExchange = new ArrayList<>();
        char letterToExchange;

        do {
            System.out.println("Chose which letter you want to exchange");
            letterToExchange = input.nextLine().toUpperCase().charAt(0);
            lettersToExchange.add(letterToExchange);
            System.out.println("One more or that was all? If you want \n" +
                    "exchange more letter press c if not press e");
            letterToExchange = input.nextLine().toUpperCase().charAt(0);
        } while (letterToExchange != 'E');

        return lettersToExchange;

    }

//    public Character choseLetterToRemoveFromBoard(){
//
//        char letterToRemove;
//        System.out.println("Which letter you want to remove?");
//        letterToRemove = input.nextLine().toUpperCase().charAt(0);
//
//        return letterToRemove;
//    }
//
//
//    public boolean addHelperContinue(){
//        String temp;
//        System.out.println("Do you want continue? If yes press y if not press n?");
//        temp = input.nextLine().toUpperCase();
//        return temp.equals("Y");
//    }

    public void chosePositionOfLetterToRemove() {
        System.out.println("Row number");
        posX = Integer.parseInt(input.nextLine());
        System.out.println("Column number");
        posY = Integer.parseInt(input.nextLine());

    }
}
