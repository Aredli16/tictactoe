package fr.aredli.tictactoe.main.grid;

/**
 * Represent a char in the grid
 *
 * @author Corentin Lempereur
 * @version 1.0
 */
public class Token {
    /**
     * Represent the token
     *
     * <p>In the default game, it's represent by "O" or "X" but value can be change in the constructor</p>
     */
    private char tokenChar;

    /**
     * Token Constructor
     *
     * @param tokenChar Specify the token char ("O" or "X" for example)
     */
    public Token(char tokenChar) {
        this.tokenChar = tokenChar;
    }

    /**
     * Used to represent graphically the token in the grid
     * @return String representation of token char
     */
    @Override
    public String toString() {
        return Character.toString(tokenChar);
    }
}
