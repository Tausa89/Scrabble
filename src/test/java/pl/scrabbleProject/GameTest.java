package pl.scrabbleProject;

import org.junit.Before;

import java.util.List;

public class GameTest {

    List<Character> listOfLettersToExchange;
    Player player;
    ListOfLetters bagOfLetters;
    Tacka tacka;
    List<Letters> list;
    Game game;

    @Before
    public void setUp() {
        listOfLettersToExchange.add('A');
        list.add(new Letters('A', 1));
        player = new Player("Tom", bagOfLetters);

    }




}
