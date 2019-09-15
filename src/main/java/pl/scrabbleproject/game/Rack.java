package pl.scrabbleproject.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Rack {

    private @Getter
    List<Letters> playerListOfLetters;

    public Rack() {
        playerListOfLetters = new ArrayList<>();
    }

    public Rack(ListOfLetters list) {
        this.playerListOfLetters = HelperMethods.createListOfPlayerLetters(list);
    }


    public void printList() {
        System.out.println();
        for (Letters letter : playerListOfLetters) {
            System.out.print(letter.getLetter() + " ");
        }
        System.out.println();
    }

    public boolean remove(char letter) {
        if (playerListOfLetters.isEmpty()) return false;
        playerListOfLetters.remove(new Letters(letter));
        return true;
    }

    public void setPlayerListOfLetters(List<Letters> playerListOfLetters) {
        this.playerListOfLetters = playerListOfLetters;
    }


}
