package pl.scrabbleproject.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class ListOfLetters {


    private @Getter
    List<Letters> lettersList;

    public ListOfLetters() {
        this.lettersList = new ArrayList<>();
        lettersList.add(new Letters('A', 1));
        lettersList.add(new Letters('B', 3));
        lettersList.add(new Letters('C', 2));
        //TODO delete rest of unnecessary variables
        lettersList.add(new Letters('D', 2));
        lettersList.add(new Letters('E', 1));
        lettersList.add(new Letters('F', 2));
        lettersList.add(new Letters('G', 3));
        lettersList.add(new Letters('H', 3));
        lettersList.add(new Letters('I', 1));
        lettersList.add(new Letters('J', 3));
        lettersList.add(new Letters('K', 2));
        lettersList.add(new Letters('L', 2));
        lettersList.add(new Letters('M', 2));
        lettersList.add(new Letters('N', 1));
        lettersList.add(new Letters('O', 1));
        lettersList.add(new Letters('P', 2));
        lettersList.add(new Letters('R', 1));
        lettersList.add(new Letters('S', 1));
        lettersList.add(new Letters('T', 2));
        lettersList.add(new Letters('U', 3));
        lettersList.add(new Letters('W', 1));
        lettersList.add(new Letters('Y', 2));
        lettersList.add(new Letters('Z', 1));

    }


    public void print() {//TODO fix typo
        for (Letters letter : lettersList) {
            System.out.println(letter.getLetter());
        }
    }
    //ConcurrentModificationException?

    public void exchangeLetters(List<Character> lettersToExchange, pl.scrabbleproject.game.Player player) {
        List<Letters> tempList = new ArrayList<>();
        for (Letters letter : player.getPlayerLetters().getPlayerListOfLetters()) {
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
