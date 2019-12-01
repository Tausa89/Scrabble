package pl.scrabbleproject.game;

import lombok.Getter;
import pl.scrabbleproject.controllers.console.ConsoleController;

import java.util.LinkedList;
import java.util.List;

public class Game {
    @Getter
    GameBoard board = new GameBoard();
    ConsoleController console;
    ListOfLetters bagOfLetters = new ListOfLetters();
    @Getter
    List<Player> players = new LinkedList<>();


    public Game(ConsoleController consoleController) {
        console = consoleController;
    }

    public void gameLoop() {
        while ((!bagOfLetters.getLettersList().isEmpty())) {//TODO add check of players letters after bag
            for (Player x : players) {
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

    public void addPlayer(Player player) throws Exception {
        if (players.size() <= 4) {
            players.add(player);
            HelperMethods.drawNewLetter(player, bagOfLetters);
        } else {
            throw new Exception("Too many players");
        }
    }


    private void playerTurn(Player player) {

        switch (console.printPlayerMenu(player)) {
            case 1:
                board.print();
                player.getPlayerLetters().printList();

                do {
                    board.addLetter(console.addLetterMenu(), player.getPlayerLetters());
                    board.print();
                } while ((console.addNextLetterMenu() != 'E') || (player.getPlayerLetters() == null));
                HelperMethods.drawNewLetter(player, bagOfLetters);
                board.print();
                break;
            case 2:
                bagOfLetters.exchangeLetters(console.choseLettersToExchange(), player);
                HelperMethods.drawNewLetter(player, bagOfLetters);
                break;
            case 3:
                bagOfLetters.exchangeAllLetters(player);
                HelperMethods.drawNewLetter(player, bagOfLetters);
                System.out.println("All letters was replaced, this are your new letters");
                player.getPlayerLetters().printList();
                break;
            case 4:
                skipTurn();
                HelperMethods.drawNewLetter(player, bagOfLetters);
                break;

            default:
                skipTurn();

        }

    }


    public void skipTurn() {
//        Need to be implemented.
    }

}
