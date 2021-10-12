package fr.aredli.tictactoe.main.game;

import fr.aredli.tictactoe.main.grid.Grid;
import fr.aredli.tictactoe.main.player.Player;

import java.util.Scanner;

/**
 * Represent the Game
 */
public class Game {
    /**
     * The Board Game
     */
    private Grid board;

    /**
     * First player
     */
    Player player1;

    /**
     * Second player
     */
    Player player2;

    /**
     * Current player represent the Player's turn
     */
    Player currentPlayer;

    /**
     * Game Constructor
     */
    public Game() {
        board = new Grid(); // Initialize the board game
        player1 = new Player(1, 'O'); // First player (ID=1) with the '0' char
        player2 = new Player(2, 'X'); // Second player (ID=2) with the 'X' char
        currentPlayer = player1; // Player who starts is player1
    }

    /**
     * Start the game
     */
    public void start() {
        // Global fields
        Scanner scanner = new Scanner(System.in);
        //Game Loop
        while (true) {
            // Print board
            printBoard();

            // Get the input number
            System.out.print("'Player " + currentPlayer.getToken() + "': Type a number (1-9): ");
            int input = currentPlayer.getInput(scanner) - 1;
            if (input < 0) // If getInput() return -1
                continue;

            // Add the input into the grid
            if (!board.addCase(input, currentPlayer))
                continue;

            // Check win
            if (board.checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Congrats! 'Player " + currentPlayer.getToken() + "' won the game");
                break;
            }

            // Check grid full
            if (board.isFull()) {
                printBoard();
                System.out.println("Deuce! No one won the game");
                break;
            }

            // Swap player
            swapPlayer();
        }
    }

    /**
     * Swap the current player
     */
    private void swapPlayer() {
        if (currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }

    /**
     * Print the board
     */
    private void printBoard() {
        System.out.println(board);
    }
}
