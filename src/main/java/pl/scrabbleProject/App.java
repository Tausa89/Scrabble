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


        ListOfLetters bagOfLetter = new ListOfLetters();
        GameBoard board = new GameBoard();
        ConsoleController console = new ConsoleController();
        Game game = new Game();


        bagOfLetter.pritn();
        Player one = new Player("Tom", bagOfLetter);
        System.out.println("***************");
        one.getPlayerLetters().printList();
        board.printScrabbleBoard();
        System.out.println("" +
                "");
        console.addLetterMenu();
        board.addLetter(console.getPosX(), console.getPosY(), console.getLetter(), one.getPlayerLetters(), bagOfLetter);
        board.printScrabbleBoard();
        one.getPlayerLetters().printList();
        console.chosePositionOfLetterToRemove();
        game.removeAddedLetter(console.getPosX(), console.getPosY(), one, board);
        board.printScrabbleBoard();
        one.getPlayerLetters().printList();


    }
}
