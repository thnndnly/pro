/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package newchess;

import newchess.domain.*;
import newchess.ui.CommandLineInputParser;

public class App {

    boolean appRunning;
    Game game;
    CommandLineInputParser clui;

    public static void main(String[] args) {
       App app = new App();
       app.run();
    }

    public App() {
        appRunning = true;
        clui = new CommandLineInputParser();
    }

    public void run() {
        System.out.println("Willkommen im Schachgame du Hund.");
        while (appRunning) {
            printMenu();
            String input = getInput();
            processInput(input);
        }
    }

    private void printMenu(){
        clearCL();
        System.out.println("1. neues Spiel starten");
        System.out.println("2. App beenden");

        System.out.println("Gib mir eine Zahl von 1 bis 2 zurück:");
    }

    private String getInput() {
        return clui.getInput();
    }

    private void processInput(String input) {
        switch (input) {
            case "1":
                game = new Game();
                game.startGame();
                break;
            case "2":
                appRunning = false;
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void clearCL() {
        System.out.print("\033[H\033[2J");
    }
}
