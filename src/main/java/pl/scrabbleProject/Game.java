package pl.scrabbleProject;

import java.util.List;

public class Game {

    GameBoard board = new GameBoard();
    ConsoleController console = new ConsoleController();
    ListOfLetters bagOfLetters = new ListOfLetters();

    public void gameloop() {

        setNumberOfPlayers(console.choseNumberOfPlayers());

    }

    private void setNumberOfPlayers(int numberOfPlayers) {

        Player playerOne;
        Player playerTwo;
        Player playerThree;
        Player playerFour;

        switch (numberOfPlayers) {
            case 2:
                playerOne = new Player(console.chosePlayerName(), bagOfLetters);
                playerTwo = new Player(console.chosePlayerName(), bagOfLetters);
//                setFirstPlayer();
                break;
            case 3:
                playerOne = new Player(console.chosePlayerName(), bagOfLetters);
                playerTwo = new Player(console.chosePlayerName(), bagOfLetters);
                playerThree = new Player(console.chosePlayerName(), bagOfLetters);
                //                setFirstPlayer();
                break;
            case 4:
                playerOne = new Player(console.chosePlayerName(), bagOfLetters);
                playerTwo = new Player(console.chosePlayerName(), bagOfLetters);
                playerThree = new Player(console.chosePlayerName(), bagOfLetters);
                playerFour = new Player(console.chosePlayerName(), bagOfLetters);
                //                setFirstPlayer();
                break;
            default:
                System.out.println("Wrong number of players");
                break;

        }

    }

    private void playerTurn(Player player) {

        board.addLetter(console.getPosX(), console.getPosY(), console.getLetter(), player.getPlayerLetters(), bagOfLetters);
        exchangeLetters(console.choseLettersToExchange(), player);


    }

    public void exchangeLetters(List<Character> lettersToExchange, Player player) {
        for (int i = 0; i < player.getPlayerLetters().getPlayerListOfLetters().size(); i++) {
            for (int j = 0; j < lettersToExchange.size(); j++) {
                if (player.getPlayerLetters().getPlayerListOfLetters().get(i).getLetter() == lettersToExchange.get(j)) {
                    player.getPlayerLetters().getPlayerListOfLetters().remove(i);

                }
            }
        }
        HelperMethods.drawNewLetter(player.getPlayerLetters().getPlayerListOfLetters(), bagOfLetters);
    }

    public void removeAddedLetter(int posX, int posY, Player player) {

        if (board.getGameBoard()[posX][posY] != null) {
            player.getPlayerLetters().getPlayerListOfLetters().add(board.getGameBoard()[posX][posY]);
            board.getGameBoard()[posX][posY] = null;
        }

    }

}
