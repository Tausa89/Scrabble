package pl.scrabbleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelperMethods {


    public static List<Letters> listOfSevenPlayerLetters(ListOfLetters lettersList){

        List<Letters> playerList = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            shufflingBagOfLettersAndAddingLetterToPlayerList(playerList, lettersList);
            removingLetterFromBagOfLetters(lettersList);
        }
        return playerList;
    }

    public static void drawingNewLetter(List<Letters> playerListOfLetters, ListOfLetters lettersList){
            shufflingBagOfLettersAndAddingLetterToPlayerList(playerListOfLetters, lettersList);
            removingLetterFromBagOfLetters(lettersList);

    }

    public static void shufflingBagOfLettersAndAddingLetterToPlayerList(List<Letters> playerListOfLetters, ListOfLetters lettersList) {
        Collections.shuffle(lettersList.getLettersList());
        playerListOfLetters.add(lettersList.getLettersList().get(0));
    }

    public static void removingLetterFromBagOfLetters(ListOfLetters lettersList) {
        lettersList.getLettersList().remove(0);
    }

    public static void removingLetterFromPlayerListOfLetter(List<Letters> playerListOfLetters, Letters letter){
        if(!playerListOfLetters.isEmpty()){
            playerListOfLetters.remove(letter);
        }else
            System.out.println("No more Letters");

    }

    public static void exchangeingLetters(List<Letters> playerListOfLetters, ListOfLetters lettersList, Letters letter){
        removingLetterFromPlayerListOfLetter(playerListOfLetters,letter);
        shufflingBagOfLettersAndAddingLetterToPlayerList(playerListOfLetters,lettersList);

    }






}
