package pl.scrabbleProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


/**
 * Hello world!
 */
public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");

        ListOfLetters bagOfLetters = new ListOfLetters();
        GameBoard scrabbleBoard = new GameBoard();
        Tacka playerListOfLetter = new Tacka(bagOfLetters);
        playerListOfLetter.printList();
        ConsoleController z = new ConsoleController();

        z.addLetterMenu();

        char letter = scrabbleBoard.addLetter(z.getPosX(), z.getPosX(), z.getLetter(), playerListOfLetter, bagOfLetters);


//        Letters oneLetter = new Letters('A', 1);
//        Letters twoLetter = new Letters('B', 1);
//        Letters threeLetter = new Letters('C', 1);
//        Tacka playerListOfLetter = new Tacka(bagOfLetters);
//
////        playerListOfLetter.getPlayerListOfLetters().add(oneLetter);
//        playerListOfLetter.printList();
//
//        scrabbleBoard.countPoints(scrabbleBoard.addLetter(0, 0, oneLetter, playerListOfLetter, bagOfLetters));
////        scrabbleBoard.addLetter(0,1,twoLetter,playerListOfLetter,bagOfLetters);
//        scrabbleBoard.addLetter(0,2,threeLetter,playerListOfLetter,bagOfLetters);


        scrabbleBoard.printScrabbleBoard();
        System.out.println("" +
                "");
        playerListOfLetter.printList();


    }
}
