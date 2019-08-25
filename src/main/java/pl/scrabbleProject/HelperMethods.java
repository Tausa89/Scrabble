package pl.scrabbleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelperMethods {


    public static List<Letters> listOfSevenPlayerLetters(ListOfLetters lettersList){

        List<Letters> playerList = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            Collections.shuffle(lettersList.getLettersList());
            playerList.add(lettersList.getLettersList().get(0));
            lettersList.getLettersList().remove(0);
        }
        return playerList;
    }






}
