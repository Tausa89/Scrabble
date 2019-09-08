package pl.scrabbleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelperMethods {


    public static List<Letters> createListOfPlayerLetters(ListOfLetters lettersList) {

        List<Letters> playerList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            shuffleLettersAddNewLetterToPlayerList(playerList, lettersList);
            removeLetterFromBag(lettersList);
        }
        return playerList;
    }

    public static void drawNewLetter(Player player, ListOfLetters bagOfLetters) {
        int listSize = 7 - player.getPlayerLetters().getPlayerListOfLetters().size();
        for (int i = 0; i < listSize; i++) {
            shuffleLettersAddNewLetterToPlayerList(player.getPlayerLetters().getPlayerListOfLetters(), bagOfLetters);
            removeLetterFromBag(bagOfLetters);
        }

    }

    public static void shuffleLettersAddNewLetterToPlayerList(List<Letters> playerListOfLetters, ListOfLetters bagOfLetters) {
        Collections.shuffle(bagOfLetters.getLettersList());
        playerListOfLetters.add(bagOfLetters.getLettersList().get(0));
    }

    public static void removeLetterFromBag(ListOfLetters lettersList) {
        lettersList.getLettersList().remove(0);
    }

    public static void removeLetterFromTacka(List<Letters> playerListOfLetters, Letters letter) {
        if (!playerListOfLetters.isEmpty()) {
            playerListOfLetters.remove(letter);
        } else
            System.out.println("No more Letters");

    }


}
