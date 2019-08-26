package pl.scrabbleProject;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Tacka {

    private @Getter List<Letters> playerListOfLetters;

    public Tacka(ListOfLetters list) {
        this.playerListOfLetters = HelperMethods.listOfSevenPlayerLetters(list);
    }

    public List<Letters> creatingPlayerList(ListOfLetters list){

        return HelperMethods.listOfSevenPlayerLetters(list);
    }

    public void printList(){
        List<Letters> list = this.playerListOfLetters;
        for (Letters letter : list){
            System.out.println(letter.getLetter());
        }
    }


}
