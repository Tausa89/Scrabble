package pl.scrabbleProject;

public class Game {

    GameBoard board = new GameBoard();
    ConsoleController console = new ConsoleController();

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
                playerOne = new Player(console.chosePlayerName());
                playerTwo = new Player(console.chosePlayerName());
//                setFirstPlayer();
                break;
            case 3:
                playerOne = new Player(console.chosePlayerName());
                playerTwo = new Player(console.chosePlayerName());
                playerThree = new Player(console.chosePlayerName());
                //                setFirstPlayer();
                break;
            case 4:
                playerOne = new Player(console.chosePlayerName());
                playerTwo = new Player(console.chosePlayerName());
                playerThree = new Player(console.chosePlayerName());
                playerFour = new Player(console.chosePlayerName());
                //                setFirstPlayer();
                break;
            default:
                System.out.println("Wrong number of players");
                break;

        }

    }

    private void playerTurn(Player player) {


    }

}
