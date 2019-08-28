package pl.scrabbleProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

    private GameBoard board;
    private Tacka playerLetters;
    private Letters letter;
    private ListOfLetters bagOfLetter;

    @Before
    public void setUp(){
        board = new GameBoard();
        playerLetters = new Tacka();
        letter = new Letters('A',1);
        playerLetters.getPlayerListOfLetters().add(letter);
        bagOfLetter = new ListOfLetters();
    }

    @Test
    public void shouldAppendAddedLetterStringBuilder(){
        Assert.assertEquals("A",board.addLetter(0,0,letter,playerLetters,bagOfLetter));
    }

    @Test
    public void addedLetterShouldBeOnBoard(){
        board.addLetter(0,0,letter,playerLetters,bagOfLetter);
        Assert.assertEquals('A',board.getGameBoard()[0][0].getLetter());
        Assert.assertNull(board.getGameBoard()[0][1]);
    }

}
