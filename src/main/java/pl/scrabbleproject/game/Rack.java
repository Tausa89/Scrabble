package pl.scrabbleproject.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Rack {

    private @Getter
    List<pl.scrabbleproject.game.Letters> playerListOfLetters;

    public Rack() {
        playerListOfLetters = new ArrayList<>();
    }

    public Rack(pl.scrabbleproject.game.ListOfLetters list) {
        this.playerListOfLetters = pl.scrabbleproject.game.HelperMethods.createListOfPlayerLetters(list);
    }


    public void printList() {
        System.out.println();
        for (pl.scrabbleproject.game.Letters letter : playerListOfLetters) {
            System.out.print(letter.getLetter() + " ");
        }
        System.out.println();
    }

    public boolean remove(char letter) {
        if (playerListOfLetters.isEmpty()) return false;
        playerListOfLetters.remove(new pl.scrabbleproject.game.Letters(letter));
        return true;
    }

    public void setPlayerListOfLetters(List<pl.scrabbleproject.game.Letters> playerListOfLetters) {
        this.playerListOfLetters = playerListOfLetters;
    }


}
