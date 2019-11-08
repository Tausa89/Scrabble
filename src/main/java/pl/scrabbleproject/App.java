package pl.scrabbleproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.scrabbleproject.game.HibernateUtil;
import pl.scrabbleproject.game.Player;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
//        logger.info("Hello World");
//        ConsoleController consoleController = new ConsoleController();
//        try {
//            consoleController.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        Player one = new Player("Tomek", 10, 0, 5);
        Player two = new Player("Tomekk", 1, 10, 2);

        var sesion = HibernateUtil.getSessionFactory().openSession();
        var transaction = sesion.beginTransaction();
        sesion.save(two);
        transaction.commit();
        sesion.close();


//        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Player.class).buildSessionFactory();
//
//        Session session = factory.openSession();
//
//        try {
//            session.beginTransaction();
//            session.save(one);
//
//            session.getTransaction().commit();
//
//
//        }finally {
//            session.close();
//        }







    }
}
