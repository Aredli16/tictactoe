package fr.aredli.tictactoe.main.player;

import fr.aredli.tictactoe.main.grid.Token;

import java.util.Scanner;

/**
 * Represent a player in the game
 */
public class Player {
    /**
     * The unique ID of the player
     */
    private int id;

    /**
     * Token player
     */
    private Token token;

    /**
     * Player Constructor
     * @param id Unique ID for the player
     * @param token Char who represent the player in the grid
     */
    public Player(int id, char token) {
        this.id = id;
        this.token = new Token(token);
    }

    /**
     * Get the input for the player
     *
     * <p>Check if the input is between 1-9 and check if the scanner is ok</p>
     * <p>If error during scanner or not between 1-9, return -1</p>
     *
     * @param scanner System.in Scanner
     * @return int between 1-9 if OK; If error, return -1
     */
    public int getInput(Scanner scanner) {
        int input;
        try {
            String sinput = scanner.nextLine();
            input = Integer.parseInt(sinput);
            if (input > 0 && input < 10)
                return input;
            else return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * @return The token of the player
     */
    public Token getToken() {
        return token;
    }
}
