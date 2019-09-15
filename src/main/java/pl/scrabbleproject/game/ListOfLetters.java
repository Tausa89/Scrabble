package pl.scrabbleproject.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class ListOfLetters {


    private @Getter
    List<pl.scrabbleproject.game.Letters> lettersList;

    public ListOfLetters() {
        this.lettersList = new ArrayList<>();
        lettersList.add(new pl.scrabbleproject.game.Letters('A', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('B', 3));
        lettersList.add(new pl.scrabbleproject.game.Letters('C', 2));
        //TODO delete rest of unnecessary variables
        lettersList.add(new pl.scrabbleproject.game.Letters('D', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('E', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('F', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('G', 3));
        lettersList.add(new pl.scrabbleproject.game.Letters('H', 3));
        lettersList.add(new pl.scrabbleproject.game.Letters('I', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('J', 3));
        lettersList.add(new pl.scrabbleproject.game.Letters('K', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('L', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('M', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('N', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('O', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('P', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('R', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('S', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('T', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('U', 3));
        lettersList.add(new pl.scrabbleproject.game.Letters('W', 1));
        lettersList.add(new pl.scrabbleproject.game.Letters('Y', 2));
        lettersList.add(new pl.scrabbleproject.game.Letters('Z', 1));

    }


    public void pritn() {//TODO fix typo
        for (pl.scrabbleproject.game.Letters letter : lettersList) {
            System.out.println(letter.getLetter());
        }
    }
    //ConcurrentModificationException?

    public void exchangeLetters(List<Character> lettersToExchange, pl.scrabbleproject.game.Player player) {
        List<pl.scrabbleproject.game.Letters> tempList = new ArrayList<>();
        for (pl.scrabbleproject.game.Letters letter : player.getPlayerLetters().getPlayerListOfLetters()) {
            for (char letterToExchange : lettersToExchange) {
                if (letter.getLetter() == letterToExchange) {
                    tempList.add(letter);
                }
            }
        }
        player.getPlayerLetters().getPlayerListOfLetters().removeAll(tempList);

    }

    public void exchangeLetters(pl.scrabbleproject.game.Player player) {
        player.getPlayerLetters().getPlayerListOfLetters().clear();
    }//TODO fix name

}
