package pl.scrabbleproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.scrabbleproject.game.Letters;
import pl.scrabbleproject.game.ListOfLetters;
import pl.scrabbleproject.game.Player;

import java.util.ArrayList;
import java.util.List;

public class ListOfLetterTest {

    private ListOfLetters bagOfLetters;
    private Player one;
    private List<Character> listOfLetterToRemove;
    private List<Letters> tempPlayerList;


    @Before
    public void setUp() {
        bagOfLetters = new ListOfLetters();
        one = new Player("Tom", bagOfLetters);
        tempPlayerList = new ArrayList<>();
        listOfLetterToRemove = new ArrayList<>();
        listOfLetterToRemove.add('A');
        listOfLetterToRemove.add('B');
        tempPlayerList.add(new Letters('A', 1));
        tempPlayerList.add(new Letters('B', 2));


    }

    @Test
    public void shouldRemoveLettersFromPlayerList() {
        bagOfLetters.exchangeLetters(one);
        one.getPlayerLetters().setPlayerListOfLetters(tempPlayerList);
        bagOfLetters.exchangeLetters(listOfLetterToRemove, one);
        Assert.assertTrue(one.getPlayerLetters().getPlayerListOfLetters().isEmpty());


    }

    @Test
    public void shouldRemoveLetterFromPlayerList() {
        bagOfLetters.exchangeLetters(one);
        tempPlayerList.add(new Letters('C', 2));
        one.getPlayerLetters().setPlayerListOfLetters(tempPlayerList);
        bagOfLetters.exchangeLetters(listOfLetterToRemove, one);
        Assert.assertEquals('C', one.getPlayerLetters().getPlayerListOfLetters().get(0).getLetter());
    }

    @Test
    public void shouldRemoveAllLettersFromPlayerList() {
        bagOfLetters.exchangeLetters(one);
        Assert.assertTrue(one.getPlayerLetters().getPlayerListOfLetters().isEmpty());
    }
}
