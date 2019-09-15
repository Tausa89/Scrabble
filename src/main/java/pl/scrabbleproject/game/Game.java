package pl.scrabbleproject.game;

import pl.scrabbleproject.controllers.console.ConsoleController;

import java.util.LinkedList;
import java.util.List;

public class Game {
    pl.scrabbleproject.game.GameBoard board = new pl.scrabbleproject.game.GameBoard();
    ConsoleController console;
    pl.scrabbleproject.game.ListOfLetters bagOfLetters = new pl.scrabbleproject.game.ListOfLetters();
    List<pl.scrabbleproject.game.Player> players = new LinkedList<>();

    public Game(ConsoleController consoleController) {
        console = consoleController;
    }

    public void gameLoop() {
        while (bagOfLetters.getLettersList().size() > 0) {//TODO add check of players letters after bag
            for (pl.scrabbleproject.game.Player x : players) {
                playerTurn(x);
            }
        }
//        while (true) {
//            printGameMenu();
//            setNumberOfPlayers(console.choseNumberOfPlayers());
//            setPlayersTurns();
//            board.print();
//            printListOfPlayers();
//        }


    }

    public void addPlayer(pl.scrabbleproject.game.Player player) throws Exception {
        if (players.size() < 4) {
            players.add(player);
            pl.scrabbleproject.game.HelperMethods.drawNewLetter(player, bagOfLetters);
        } else {
            throw new Exception("Too many players");
        }
    }


    private void playerTurn(pl.scrabbleproject.game.Player player) {

        switch (console.printPlayerMenu(player)) {
            case 1:
                board.print();
                player.getPlayerLetters().printList();
                board.addLetter(console.addLetterMenu(), player.getPlayerLetters());
                board.print();
                pl.scrabbleproject.game.HelperMethods.drawNewLetter(player, bagOfLetters);
                break;
            case 2:
                bagOfLetters.exchangeLetters(console.choseLettersToExchange(), player);
                pl.scrabbleproject.game.HelperMethods.drawNewLetter(player, bagOfLetters);
                break;
            case 3:
                skipTurn();
                break;

            default:
                skipTurn();
        }

    }


    public void skipTurn() {
//        Need to be implemented.
    }

}
