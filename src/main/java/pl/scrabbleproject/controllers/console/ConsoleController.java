package pl.scrabbleproject.controllers.console;

import pl.scrabbleproject.controllers.console.enums.Menu;
import pl.scrabbleproject.game.Game;
import pl.scrabbleproject.game.Player;
import pl.scrabbleproject.game.dto.AddLetterObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    Game game;
    Menu menu = Menu.MAIN;
    boolean endGame = false;
    private Scanner input = new Scanner(System.in);

    public void run() throws Exception {
        do {
            switch (menu) {
                case MAIN: {
                    mainMenu();
                    break;
                }
                case NEW_GAME: {
                    newGameMenu();
                    break;
                }
                case GAME: {
                    //TODO give control to the Game
                    game.gameLoop();
                    break;
                }
                case EXIT: {
                    //TODO are you sure? Y/N check + return to mainMenu
                    endGame = true;
                }
            }
        } while (!endGame);
    }

    public void mainMenu() {
        System.out.println("Main Menu:\n");
        System.out.println("If you want to start game press 1\n");
        System.out.println("If you want to exit press 2\n");
        int operation = Integer.parseInt(input.nextLine());
        switch (operation) {
            case 1: {
                menu = Menu.NEW_GAME;
                game = new Game(this);
                break;
            }
            case 2: {
                menu = Menu.EXIT;
                break;
            }
        }
    }

    private void newGameMenu() throws Exception {
        System.out.println("New Game Menu:\n");
        System.out.println("If you want to add player press 1\n");
        System.out.println("If you want to start game press 2\n");
        System.out.println("If you want to delete game press 3\n");
        int operation = Integer.parseInt(input.nextLine());
        switch (operation) {
            case 1: {
                if (game == null) {
                    throw new Exception("Trying to add player to non-existing game");
                }
                System.out.println("Write player name or r to return to previous screen");
                String name = input.nextLine();
                //TODO check r and return
                //TODO check player count
                game.addPlayer(new Player(name));
                break;
            }
            case 2: {
                menu = Menu.GAME;
                break;
            }
            case 3: {
                //TODO
                break;
            }
        }
    }


    public AddLetterObject addLetterMenu() {
        System.out.println("Enter coordinates of of your letter starting from row number ");
        int posX = Integer.parseInt(input.nextLine());
        System.out.println("Enter column number ");
        int posY = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the letter you want to add");
        char letter = input.nextLine().toUpperCase().charAt(0);
        System.out.println("If you want to end write : e to stop or c to continue");
        return new AddLetterObject(posX, posY, letter);
    }

    public int choseNumberOfPlayers() {
        int numberOfPlayers;
        System.out.println("Chose number of players between 2 to 4");
        numberOfPlayers = Integer.parseInt(input.nextLine());
        return numberOfPlayers;
    }

    public String chosePlayerName() {

        String playerName;
        System.out.println("Write Your name");
        playerName = input.nextLine();
        return playerName;
    }


    public List<Character> choseLettersToExchange() {

        List<Character> lettersToExchange = new ArrayList<>();
        char letterToExchange;

        do {
            System.out.println("Chose which letter you want to exchange");
            letterToExchange = input.nextLine().toUpperCase().charAt(0);
            lettersToExchange.add(letterToExchange);
            System.out.println("One more or that was all? If you want \n" +
                    "exchange more letter press c if not press e");
            letterToExchange = input.nextLine().toUpperCase().charAt(0);
        } while (letterToExchange != 'E');

        return lettersToExchange;

    }

//    public Character choseLetterToRemoveFromBoard(){
//
//        char letterToRemove;
//        System.out.println("Which letter you want to remove?");
//        letterToRemove = input.nextLine().toUpperCase().charAt(0);
//
//        return letterToRemove;
//    }
//
//
//    public boolean addHelperContinue(){
//        String temp;
//        System.out.println("Do you want continue? If yes press y if not press n?");
//        temp = input.nextLine().toUpperCase();
//        return temp.equals("Y");
//    }

    public void chosePositionOfLetterToRemove() {
        System.out.println("Row number");
        //this.posX = Integer.parseInt(input.nextLine());
        System.out.println("Column number");
        //this.posY = Integer.parseInt(input.nextLine());

    }

    public int printPlayerMenu(Player player) {
        System.out.println("Turn: " + player.toString());
        System.out.print("Letters: ");
        player.getPlayerLetters().printList();
        System.out.println("If you want to add letters to the board press 1\n");
        System.out.println("If you want to exchange letter press 2\n");
        System.out.println("If you want to skip your turn press 3\n");
        return Integer.parseInt(input.nextLine());
    }

    public void printPlayerList(List<Player> listOfPlayers) {
        for (Player player : listOfPlayers) {
            System.out.println(player.getName());
        }
    }
}
