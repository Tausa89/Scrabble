package pl.scrabbleProject;

import java.util.ArrayList;
import java.util.List;

public class Tacka {

    private List<Letters> playerListOfLetters = new ArrayList<>();

    public List<Letters> creatingPlayerList(ListOfLetters list){

        return this.playerListOfLetters = HelperMethods.listOfSevenPlayerLetters(list);
    }
}
