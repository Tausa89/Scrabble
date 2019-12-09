package pl.scrabbleproject.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelperMethods {

    private HelperMethods() {
    }

    static List<Letters> createListOfPlayerLetters(ListOfLetters lettersList) {

        List<Letters> playerList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            shuffleLettersAddNewLetterToPlayerList(playerList, lettersList);
            removeLetterFromBag(lettersList);
        }
        return playerList;
    }

    static void drawNewLetter(Player player, ListOfLetters bagOfLetters) {
        int listSize = 7 - player.getPlayerLetters().getPlayerListOfLetters().size();
        for (int i = 0; i < listSize; i++) {
            shuffleLettersAddNewLetterToPlayerList(player.getPlayerLetters().getPlayerListOfLetters(), bagOfLetters);
            removeLetterFromBag(bagOfLetters);
        }

    }

    static void shuffleLettersAddNewLetterToPlayerList(List<Letters> playerListOfLetters, ListOfLetters bagOfLetters) {
        Collections.shuffle(bagOfLetters.getLettersList());
        playerListOfLetters.add(bagOfLetters.getLettersList().get(0));
    }

    static void removeLetterFromBag(ListOfLetters lettersList) {
        lettersList.getLettersList().remove(0);
    }

    static void removeLetterFromTacka(List<Letters> playerListOfLetters, Letters letter) {
        if (!playerListOfLetters.isEmpty()) {
            playerListOfLetters.remove(letter);
        } else
            System.out.println("No more Letters");

    }

    public static void savePlayerToDB(Player player) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.save(player);
        transaction.commit();
        session.close();

    }

    public static void updatingPlayers(List<Player> list) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        for (Player player : list) {
            List<Player> results = session.createQuery("FROM Player WHERE name = " + "\'" + player.getName() + "\'", Player.class).getResultList();
            Player loadedPlayer = results.get(0);
            loadedPlayer.setNumberOfDraws(player.getNumberOfDraws());
            loadedPlayer.setNumberOfWins(player.getNumberOfWins());
            loadedPlayer.setNumberOfLoses(player.getNumberOfLoses());
            session.update(loadedPlayer);
        }
        transaction.commit();

        session.close();
    }

    public static boolean checkIfPlayerExistInDB(String name) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var transaction = session.beginTransaction();
            List<Player> results = session.createQuery("FROM Player WHERE name = " + "\'" + name + "\'", Player.class).getResultList();
            if (results.isEmpty()) {
                return true;
            }
            transaction.commit();
            session.close();
        }
        return false;
    }
}
