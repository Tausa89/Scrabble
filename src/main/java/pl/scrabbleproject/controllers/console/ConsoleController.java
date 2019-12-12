package pl.scrabbleproject.controllers.console;

import pl.scrabbleproject.controllers.console.enums.Menu;
import pl.scrabbleproject.game.Game;
import pl.scrabbleproject.game.HelperMethods;
import pl.scrabbleproject.game.HibernateUtil;
import pl.scrabbleproject.game.Player;
import pl.scrabbleproject.game.dto.AddLetterObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private Game game;
    private Menu menu = Menu.MAIN;
    private boolean endGame = false;
    private Scanner input = new Scanner(System.in);

    public void run() throws Exception {
        do {
            switch (menu) {
                case MAIN:
                    mainMenu();
                    break;
                case NEW_GAME:
                    newGameMenu();
                    break;

                case GAME:
                    //TODO give control to the Game
                    game.gameLoop();
                    break;

                case EXIT:
                    exitMenu();
                    break;
            }
        } while (!endGame);
    }
    //ToDo validacje trzeba dodać.

    private void mainMenu() {
        System.out.println("Main Menu:\n");
        System.out.println("If you want to start game press 1\n");
        System.out.println("If you want to exit press 2\n");
        try {
            int operation = Integer.parseInt(input.nextLine());
            if (operation == 1) {
                menu = Menu.NEW_GAME;
                game = new Game(this);
            } else if (operation == 2) {
                menu = Menu.EXIT;
            } else {
                System.out.println("You can chose only option 1 or 2.");
            }
        } catch (NumberFormatException e) {
            e.getMessage();
            System.out.println("You can't use any other symbols than 1 or 2.");
        }

//        switch (operation) {
//            case 1: {
//                menu = Menu.NEW_GAME;
//                game = new Game(this);
//                break;
//            }
//            case 2: {
//                menu = Menu.EXIT;
//                break;
//            }
//        }
    }

    private void exitMenu() {
        System.out.println("Are you sure? If yes press y\n");
        System.out.println("Press n if you want go back to main menu");
        String xxx = input.nextLine().toUpperCase();
        switch (xxx) {
            case "Y":
                menu = Menu.EXIT;
                endGame = true;
                break;
            case "N":
                menu = Menu.MAIN;
                break;
            default:
                System.out.println("Wrong input try again using y or n.\n");


        }
    }

    private void newGameMenu() throws Exception {
        System.out.println("New Game Menu:\n");
        System.out.println("If you want to add player press 1\n");
        System.out.println("If you did play before and you want to load your profile press 2\n");
        System.out.println("If you want to start game press 3\n");
        System.out.println("If you want to delete game press 4\n");
        try {
            int operation = Integer.parseInt(input.nextLine());
            switch (operation) {
                case 1:
                    addNewPlayer();
                    break;
                case 2:
                    loadPlayerFromDatabase();
                    break;
                case 3:
                    startGameAndAddNewPlayerToDatabase();
                    break;
                case 4:
                    deleteGameMenu();
                    break;
                default:
                    System.out.println("Wrong input");

            }
        } catch (NumberFormatException e) {
            e.getMessage();
            System.out.println("Use only numbers from 1 to 4\n");
        }
    }

    private void startGameAndAddNewPlayerToDatabase() {
        if (!game.getPlayers().isEmpty()) {
            var session = HibernateUtil.getSessionFactory().openSession();
            var transaction = session.beginTransaction();
            transaction.commit();
            session.close();
            menu = Menu.GAME;
        } else
            System.out.println("You can't start a game when there is no players\n");
    }

    private void loadPlayerFromDatabase() throws Exception {
        System.out.println("Pleas write your profile name");
        String name = input.nextLine();
        Player newPlayer;
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var transaction = session.beginTransaction();
            List<Player> results = session.createQuery("FROM Player WHERE name = " + "\'" + name + "\'", Player.class).getResultList();
            if (results.size() == 1) {
                newPlayer = results.get(0);
                newPlayer.setPlayerLetters();
                game.addPlayer(newPlayer);
                System.out.println("Player " + newPlayer.getName() + " was successfully loaded and added to game");
                System.out.println(newPlayer.toString());
            } else if (results.isEmpty()) {
                System.out.println("There is no profile with name " + name + " in database");
                menu = Menu.NEW_GAME;
            } else {
                menu = Menu.NEW_GAME;
                throw new Exception("Something went wrong, there can't be more than 1 profile with this same name in data base");

            }

            transaction.commit();
            session.close();
        }

    }

    private void addNewPlayer() throws Exception {
        if (game == null) {
            throw new NullPointerException("Trying to add player to non-existing game");
        }
        System.out.println("Write player name or r to return to previous screen");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            menu = Menu.NEW_GAME;
        } else {
            if (HelperMethods.checkIfPlayerExistInDB(name)) {
                Player temporaryPlayer = new Player(name);
                game.addPlayer(temporaryPlayer);
                HelperMethods.savePlayerToDB(temporaryPlayer);
            } else {
                System.out.println("Chose other name, player " + name + " already exist");
                menu = Menu.NEW_GAME;
            }
        }
        //done but atm in not working because there is not enough letters for 4 players.
        System.out.println(game.getPlayers().size());
        if (game.getPlayers().size() == 4) {
            System.out.println("You can't add more players\n" +
                    "Four it is maximum number of players");
        }
    }


    public AddLetterObject addLetterMenu() {

        System.out.println("Enter coordinates of of your letter starting from row number ");
        int posX = Integer.parseInt(input.nextLine());
        System.out.println("Enter column number ");
        int posY = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the letter you want to add");
        char letter = input.nextLine().toUpperCase().charAt(0);
        return new AddLetterObject(posX, posY, letter);

    }

//    public int choseNumberOfPlayers() {
//        int numberOfPlayers;
//        System.out.println("Chose number of players between 2 to 4");
//        numberOfPlayers = Integer.parseInt(input.nextLine());
//        return numberOfPlayers;
//    }

//    public String chosePlayerName() {
//
//        String playerName;
//        System.out.println("Write Your name");
//        playerName = input.nextLine();
//        return playerName;
//    }


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

//    public void chosePositionOfLetterToRemove() {
//        System.out.println("Row number");
//        //this.posX = Integer.parseInt(input.nextLine());
//        System.out.println("Column number");
//        //this.posY = Integer.parseInt(input.nextLine());
//
//    }

    public int printPlayerMenu(Player player) {
        System.out.println("Turn: " + player.toString());
        System.out.print("Letters: ");
        player.getPlayerLetters().printList();
        System.out.println("If you want to add letters to the board press 1\n");
        System.out.println("If you want to exchange letter or letters press 2\n");
        System.out.println("If you want to exchange all letters press 3\n");
        System.out.println("If you want to skip your turn press 4\n");
        int value = 0;
        try {
            value = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
            System.out.println("Only number from 1 to 4\n");
        }
        return value;
    }

//    public void printPlayerList(List<Player> listOfPlayers) {
//        for (Player player : listOfPlayers) {
//            System.out.println(player.getName());
//        }
//    }

    private void deleteGameMenu() {
        System.out.println("Are you sure you want delete game? All your progress would be lost?\n" +
                "If you still want to close game press d if you want to continue to play press c");
        String option = input.nextLine().toUpperCase();

        switch (option) {
            case "D":
                game.getPlayers().clear();
                game.getBoard().clearBoard();
                menu = Menu.MAIN;
                break;
            case "C":
                menu = Menu.NEW_GAME;
                break;
            default:
                System.out.println("Wrong input try again using d or c");
        }
    }

    public char addNextLetterMenu() {
        System.out.println("If you want to end write e to stop or c to continue.");
        char letter = input.nextLine().toUpperCase().charAt(0);
        if (!Character.toString(letter).matches("[A-Z]")) {
            System.out.println("Wrong input");
        }
        return letter;
    }

    public char removeJustAddedLetterOption() {
        System.out.println("If you want to cancel your last move press r");
        return input.nextLine().toUpperCase().charAt(0);
    }

    public char removeLetterMenu() {
        System.out.println("Are you done? If yes press x");
        return input.nextLine().toUpperCase().charAt(0);
    }

    public int getCordsXToRemoveLetter() {
        System.out.println("Enter coordinates of letter you want to remove starting from row number");
        return Integer.parseInt(input.nextLine());
    }

    public int getCordsYoRemoveLetter() {
        System.out.println("Enter column number");
        return Integer.parseInt(input.nextLine());
    }

    public char letChoseRemoveLetterMenu() {
        System.out.println("Your just added word is correct? Or you want to change something?\n" +
                "If you want to remove some letter press x, if everything is ok press anything");
        return input.nextLine().toUpperCase().charAt(0);
    }
}
