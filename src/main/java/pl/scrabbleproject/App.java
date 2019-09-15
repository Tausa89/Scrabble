package pl.scrabbleproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.scrabbleproject.controllers.console.ConsoleController;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");
        ConsoleController consoleController = new ConsoleController();
        try {
            consoleController.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
