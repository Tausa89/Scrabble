package pl.scrabbleproject;

import org.junit.Before;
import pl.scrabbleproject.game.*;

import java.util.List;

public class GameTest {

    List<Character> listOfLettersToExchange;
    Player player;
    ListOfLetters bagOfLetters;
    Rack rack;
    List<Letters> list;
    Game game;

    @Before
    public void setUp() {
        listOfLettersToExchange.add('A');
        list.add(new Letters('A', 1));
        player = new Player("Tom", bagOfLetters);

    }




}