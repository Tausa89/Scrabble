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

        List<Letters> list = HelperMethods.listOfSevenPlayerLetters();

        for(Letters letter : list){
            System.out.println(letter.getLetter());
        }




    }
}
