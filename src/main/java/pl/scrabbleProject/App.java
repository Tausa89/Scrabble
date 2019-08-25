package pl.scrabbleProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");

        ListOfLetters bagOfLetters = new ListOfLetters();
        GameBoard scrabbleBoard = new GameBoard();
        Letters oneLetter = new Letters('A',1);
        scrabbleBoard.addingLetter(0,0,oneLetter);

        scrabbleBoard.printScrabbleBoard();

        List<Letters> list = HelperMethods.listOfSevenPlayerLetters(bagOfLetters);
        System.out.println("" +
                "");

        for(Letters letter : list){
            System.out.println(letter.getLetter());
        }




    }
}
