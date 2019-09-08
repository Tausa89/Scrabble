package pl.scrabbleProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameBoardTest {

    private GameBoard board;
    private Rack playerLetters;
    private Letters letter;
    private Letters lettertwo;
    private Letters letterthree;
    private ListOfLetters bagOfLetter;
    private List<Letters> listOfLetters;

    @Before
    public void setUp(){
        board = new GameBoard();
        playerLetters = new Rack();
        listOfLetters = new ArrayList<>();
        letter = new Letters('A',1);
        lettertwo = new Letters('B', 2);
        letterthree = new Letters('C', 3);
        playerLetters.getPlayerListOfLetters().add(letter);
        bagOfLetter = new ListOfLetters();
        listOfLetters.add(letter);
        listOfLetters.add(lettertwo);
        listOfLetters.add(letterthree);


    }

//    @Test
//    public void shouldAppendAddedLetterStringBuilder(){
//        Assert.assertEquals("A",board.addLetter(0,0,letter,playerLetters,bagOfLetter));
//    }

//    @Test
//    public void addedLetterShouldBeOnBoard(){
//        board.addLetter(playerLetters, bagOfLetter);
//
//        Assert.assertEquals('A',board.getGameBoard()[0][0].getLetter());
//        Assert.assertNull(board.getGameBoard()[0][1]);
//    }

    @Test
    public void goodCountPoints() {

        Assert.assertEquals(6, board.countPoints(listOfLetters));
    }

}
