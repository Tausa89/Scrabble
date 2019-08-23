package pl.scrabbleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelperMethods {


    public static List<Letters> listOfSevenPlayerLetters(){

        ListOfLetters list = new ListOfLetters();
        List<Letters> playerList = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            Collections.shuffle(list.getLettersList());
            playerList.add(list.getLettersList().get(0));
            list.getLettersList().remove(0);
        }
        return playerList;
    }


}
