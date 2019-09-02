package pl.scrabbleProject;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Tacka {

    private @Getter List<Letters> playerListOfLetters;

    public Tacka(){
        playerListOfLetters = new ArrayList<>();
    }

    public Tacka(ListOfLetters list) {
        this.playerListOfLetters = HelperMethods.createListOfPlayerLetters(list);
    }

    public List<Letters> createPlayerList(ListOfLetters list){

        return HelperMethods.createListOfPlayerLetters(list);
    }

    public void printList(){
        List<Letters> list = this.playerListOfLetters;
        for (Letters letter : list){
            System.out.println(letter.getLetter());
        }
    }


}
