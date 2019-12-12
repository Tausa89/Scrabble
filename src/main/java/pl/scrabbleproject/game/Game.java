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
        while ((!bagOfLetters.getLettersList().isEmpty()) || !players.isEmpty()) {
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
                addLetterToTheBoard(player);
                letPlayerRemoveLetterFromAddedWord(player);
                board.setAllLetterIsNewFiledToFalse();
                HelperMethods.drawNewLetter(player, bagOfLetters);
                board.print();
                break;
            case 2:
                List<Letters> tempList = createTemporallyLetterList(player);
                bagOfLetters.exchangeLetters(console.choseLettersToExchange(), player);
                HelperMethods.drawNewLetter(player, bagOfLetters);
                returnLettersToBagOfLetters(tempList);
                break;
            case 3:
                List<Letters> tempList2 = createTemporallyLetterList(player);
                bagOfLetters.exchangeAllLetters(player);
                HelperMethods.drawNewLetter(player, bagOfLetters);
                returnLettersToBagOfLetters(tempList2);
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

    private void addLetterToTheBoard(Player player) {
        board.print();
        player.getPlayerLetters().printList();

        do {
            AddLetterObject tempLetter = console.addLetterMenu();
            board.addLetter(tempLetter, player.getPlayerLetters());
            board.print();
            if (console.removeJustAddedLetterOption() == 'R') {
                removeJustAddedLetter(player, tempLetter);
                board.print();
            }

        } while ((console.addNextLetterMenu() != 'E') || (player.getPlayerLetters() == null));
    }

    private void letPlayerRemoveLetterFromAddedWord(Player player) {
        if (console.letChoseRemoveLetterMenu() == 'X') {
//            try {
            do {
                System.out.println("Which letter you want to remove?");
                int cordX = console.getCordsXToRemoveLetter();
                int cordY = console.getCordsYoRemoveLetter();
                if (board.getGameBoard()[cordX][cordY] == null) {
                    System.out.println("There is no letter at this position");
                } else if (board.getGameBoard()[cordX][cordY].isNew()) {
                    player.getPlayerLetters().addLetter(board.getGameBoard()[cordX][cordY].getLetter());
                    board.getGameBoard()[cordX][cordY] = null;
                    System.out.println("Letter " + board.getGameBoard()[cordX][cordY].getLetter() + " was added " +
                            " to Your letters poll and removed from board");
                } else
                    System.out.println("You can only remove letter from a word just added by you");

            } while (console.removeLetterMenu() != 'X');

//            } catch (NullPointerException e) {
//                System.out.println("There is no letter at this position");
//            }
        }
    }

    private void removeJustAddedLetter(Player player, AddLetterObject tempLetter) {
        board.getGameBoard()[tempLetter.getPosX()][tempLetter.getPosY()] = null;
        player.getPlayerLetters().addLetter(tempLetter.getLetter());
    }

//    public void skipTurn() {
////        Need to be implemented.
//    }

    private void returnLettersToBagOfLetters(List<Letters> exchangedLetters) {
        bagOfLetters.getLettersList().addAll(exchangedLetters);
    }

    private List<Letters> createTemporallyLetterList(Player player) {
        return player.getPlayerLetters().getPlayerListOfLetters();
    }


}
