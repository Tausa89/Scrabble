package pl.scrabbleProject;

import lombok.Getter;

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
            posX = Integer.parseInt(input.nextLine());
            System.out.println("Enter column number ");
            posY = Integer.parseInt(input.nextLine());
            System.out.println("Please enter the letter you want to add");
            letter = input.nextLine().toUpperCase().charAt(0);
            System.out.println("If you want to end write : e to stop or c to continue");
            temp = input.nextLine().toUpperCase().charAt(0);
        } while (temp != 'E');
//        while (true) {
//            System.out.println("Enter coordinates of of your letter starting from row number ");
//            posX = Integer.parseInt(input.nextLine());
//            System.out.println("Enter column number ");
//            posY = Integer.parseInt(input.nextLine());
//            System.out.println("Please enter the letter you want to add");
//            letter = input.nextLine().toUpperCase().charAt(0);
//            System.out.println("If you want to end write : e to stop or c to continue");
//            temp = input.nextLine().toUpperCase().charAt(0);
//            if (temp == 'E'){
//                break;
//            }
//        }

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
}
