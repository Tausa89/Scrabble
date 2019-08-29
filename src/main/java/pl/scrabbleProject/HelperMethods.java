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

    public static void drawNewLetter(List<Letters> playerListOfLetters, ListOfLetters lettersList) {
        int listSize = 7 - playerListOfLetters.size();
        for (int i = 0; i < listSize; i++) {
            shuffleLettersAddNewLetterToPlayerList(playerListOfLetters, lettersList);
            removeLetterFromBag(lettersList);
        }

    }

    public static void shuffleLettersAddNewLetterToPlayerList(List<Letters> playerListOfLetters, ListOfLetters lettersList) {
        Collections.shuffle(lettersList.getLettersList());
        playerListOfLetters.add(lettersList.getLettersList().get(0));
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

    public static void exchengeLetter(List<Letters> playerListOfLetters, ListOfLetters lettersList, Letters letter) {
        removeLetterFromTacka(playerListOfLetters, letter);
        shuffleLettersAddNewLetterToPlayerList(playerListOfLetters, lettersList);

    }


}
