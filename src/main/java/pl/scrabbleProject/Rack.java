package pl.scrabbleProject;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Rack {

    private @Getter List<Letters> playerListOfLetters;

    public Rack() {
        playerListOfLetters = new ArrayList<>();
    }

    public Rack(ListOfLetters list) {
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

    public void setPlayerListOfLetters(List<Letters> playerListOfLetters) {
        this.playerListOfLetters = playerListOfLetters;
    }
}
