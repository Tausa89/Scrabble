package pl.scrabbleProject;

public class Game {

    GameBoard board = new GameBoard();
    ConsoleController console = new ConsoleController();
    ListOfLetters bagOfLetters = new ListOfLetters();

    public void gameLoop() {

//        while (true) {
//            printGameMenu();
//            setNumberOfPlayers(console.choseNumberOfPlayers());
//            setPlayersTurns();
//            board.print();
//            printListOfPlayers();
//
//
//        }


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

        switch (console.printPlayerMenu()) {

            case 1:
                console.addLetterMenu();
                board.addLetter(console.getPosX(), console.getPosY(), console.getLetter(), player.getPlayerLetters());
                console.chosePositionOfLetterToRemove();
                removeAddedLetter(console.getPosX(), console.getPosY(), player, board);
                HelperMethods.drawNewLetter(player, bagOfLetters);
                break;
            case 2:
                bagOfLetters.exchangeLetters(console.choseLettersToExchange(), player);
                HelperMethods.drawNewLetter(player, bagOfLetters);
                break;
            case 3:
                skipTurn();
                break;

            default:
                skipTurn();
        }

    }



    public void removeAddedLetter(int posX, int posY, Player player, GameBoard board) {

        if (board.getGameBoard()[posX][posY] != null) {
            player.getPlayerLetters().getPlayerListOfLetters().add(board.getGameBoard()[posX][posY]);
            board.getGameBoard()[posX][posY] = null;
        }

    }

    public void skipTurn() {
//        Need to be implemented.
    }

}
