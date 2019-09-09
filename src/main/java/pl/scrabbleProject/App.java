package pl.scrabbleProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");

        GameBoard board = new GameBoard();
        ConsoleController controller = new ConsoleController();
        board.print();
        ListOfLetters bagOfLetters = new ListOfLetters();

//        Player player = new Player("Tom", bagOfLetters);
//        System.out.println("" +
//                "");
//
//        player.getPlayerLetters().printList();
//        bagOfLetters.exchangeLetters(controller.choseLettersToExchange(), player);
//        System.out.println("*************************");
//        player.getPlayerLetters().printList();









    }
}
