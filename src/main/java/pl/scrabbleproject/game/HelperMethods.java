package pl.scrabbleproject.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelperMethods {


    public static List<pl.scrabbleproject.game.Letters> createListOfPlayerLetters(pl.scrabbleproject.game.ListOfLetters lettersList) {

        List<pl.scrabbleproject.game.Letters> playerList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            shuffleLettersAddNewLetterToPlayerList(playerList, lettersList);
            removeLetterFromBag(lettersList);
        }
        return playerList;
    }

    public static void drawNewLetter(pl.scrabbleproject.game.Player player, pl.scrabbleproject.game.ListOfLetters bagOfLetters) {
        int listSize = 7 - player.getPlayerLetters().getPlayerListOfLetters().size();
        for (int i = 0; i < listSize; i++) {
            shuffleLettersAddNewLetterToPlayerList(player.getPlayerLetters().getPlayerListOfLetters(), bagOfLetters);
            removeLetterFromBag(bagOfLetters);
        }

    }

    public static void shuffleLettersAddNewLetterToPlayerList(List<pl.scrabbleproject.game.Letters> playerListOfLetters, pl.scrabbleproject.game.ListOfLetters bagOfLetters) {
        Collections.shuffle(bagOfLetters.getLettersList());
        playerListOfLetters.add(bagOfLetters.getLettersList().get(0));
    }

    public static void removeLetterFromBag(pl.scrabbleproject.game.ListOfLetters lettersList) {
        lettersList.getLettersList().remove(0);
    }

    public static void removeLetterFromTacka(List<pl.scrabbleproject.game.Letters> playerListOfLetters, pl.scrabbleproject.game.Letters letter) {
        if (!playerListOfLetters.isEmpty()) {
            playerListOfLetters.remove(letter);
        } else
            System.out.println("No more Letters");

    }


}
