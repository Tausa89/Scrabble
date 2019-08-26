package pl.scrabbleProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App

{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");

        ListOfLetters bagOfLetters = new ListOfLetters();
        bagOfLetters.pritn();
        System.out.println("********************");
        GameBoard scrabbleBoard = new GameBoard();
        Letters oneLetter = new Letters('A',1);
        Letters twoLetter = new Letters('B',1);
        Letters threeLetter = new Letters('C',1);
        Tacka playerListOfLetter = new Tacka(bagOfLetters);
        playerListOfLetter.printList();
        scrabbleBoard.addingLetter(0,0,oneLetter,playerListOfLetter,bagOfLetters);
//        scrabbleBoard.addingLetter(0,1,twoLetter,playerListOfLetter,bagOfLetters);
//        scrabbleBoard.addingLetter(0,2,threeLetter,playerListOfLetter,bagOfLetters);


        scrabbleBoard.printScrabbleBoard();
        HelperMethods.removingLetterFromPlayerListOfLetter(playerListOfLetter.getPlayerListOfLetters(),oneLetter);

        playerListOfLetter.printList();
        System.out.println("********************************");
        bagOfLetters.pritn();




    }
}
