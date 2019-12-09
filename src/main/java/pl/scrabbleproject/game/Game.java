package pl.scrabbleproject.game;

import lombok.Getter;
import pl.scrabbleproject.controllers.console.ConsoleController;
import pl.scrabbleproject.game.dto.AddLetterObject;

import java.util.LinkedList;
import java.util.List;

public class Game {
    @Getter
    private GameBoard board = new GameBoard();
    private ConsoleController console;
    private ListOfLetters bagOfLetters = new ListOfLetters();
    @Getter
    private List<Player> players = new LinkedList<>();


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

    public void addPlayer(Player player) {
        if (players.size() <= 4) {
            players.add(player);
            HelperMethods.drawNewLetter(player, bagOfLetters);
        } else {
            throw new IndexOutOfBoundsException("Too many players");
        }
    }


    public void playerTurn(Player player) {

        if (player == null) {
            throw new IllegalArgumentException("Player is null");
        }

        switch (console.printPlayerMenu(player)) {
            case 1:
                board.print();
                player.getPlayerLetters().printList();

                do {
                    AddLetterObject tempLetter = console.addLetterMenu();
                    board.addLetter(tempLetter, player.getPlayerLetters());
                    board.print();
                    if (console.removeJustAddedLetterOption() == 'R') {
                        board.getGameBoard()[tempLetter.getPosX()][tempLetter.getPosY()] = null;
                        player.getPlayerLetters().addLetter(tempLetter.getLetter());
                        board.print();
                    }

                } while ((console.addNextLetterMenu() != 'E') || (player.getPlayerLetters() == null));
                board.setAllLetterIsNewFiledToFalse();
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
                HelperMethods.drawNewLetter(player, bagOfLetters);
                break;

            default:
                break;

        }

    }

//    public void skipTurn() {
////        Need to be implemented.
//    }

}
