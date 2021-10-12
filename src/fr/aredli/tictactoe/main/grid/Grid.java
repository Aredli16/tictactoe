package fr.aredli.tictactoe.main.grid;

import fr.aredli.tictactoe.main.player.Player;

/**
 * Represent the Grid
 *
 * @author Corentin Lempereur
 * @version 1.0
 */
public class Grid {
    /**
     * Cases of the Grid
     */
    private final GridCase[] cases;

    /**
     * Grid Constructor
     *
     * <p>Initialize the tab with 9 GridCases and each case with an ID between 1-9</p>
     */
    public Grid() {
        cases = new GridCase[9];
        for (int i = 0; i < cases.length; i++) {
            cases[i] = new GridCase(i+1);
        }
    }

    /**
     * Add the token into a specific case
     *
     * <p>Check if the case is also busy</p>
     *
     * @param caseIndex Where the token need to be place
     * @param player Which player must place the token
     * @return Return placement result
     */
    public boolean addCase(int caseIndex, Player player) {
        if (cases[caseIndex].getContent() == null) {
            cases[caseIndex].setContent(player.getToken());
            return true; // Token placed
        }
        return false; // Unable to place token
    }

    /**
     * Check line, column, diagonal of the grid
     *
     * @param player Player to check win
     * @return True if we have a winner, false otherwise
     */
    public boolean checkWin(Player player) {
        return checkLine(player) || checkColumn(player) || checkDiagonal(player);
    }

    /**
     * Check each line and verify if player is winner
     *
     * @param player Player to check win
     * @return Return true if player is winner
     */
    private boolean checkLine(Player player) {
        for (int i = 0; i < 3; i++) {
            if (cases[i * 3].getContent() == player.getToken()
                    && cases[i * 3 + 1].getContent() == player.getToken()
                        && cases[i * 3 + 2].getContent() == player.getToken())
                return true;
        }
        return false;
    }

    /**
     * Check each column and verify if player is winner
     *
     * @param player Player to check win
     * @return Return true if player is winner
     */
    private boolean checkColumn(Player player) {
        for (int i = 0; i < 3; i++) {
            if (cases[i].getContent() == player.getToken()
                    && cases[i + 3].getContent() == player.getToken()
                        && cases[i + 6].getContent() == player.getToken())
                return true;
        }
        return false;
    }

    /**
     * Check the 2 diagonals and verify if player is winner
     *
     * @param player Player to check win
     * @return Return true if player is winner
     */
    private boolean checkDiagonal(Player player) {
        if (cases[0].getContent() == player.getToken()
                && cases[4].getContent() == player.getToken()
                    && cases[8].getContent() == player.getToken())
            return true;
        return cases[3].getContent() == player.getToken()
                && cases[4].getContent() == player.getToken()
                && cases[6].getContent() == player.getToken();
    }

    /**
     * Check if the grid is full
     *
     * @return True if the grid is full
     */
    public boolean isFull() {
        for (int i = 0; i < cases.length; i++) {
            if (cases[i].getContent() == null)
                return false;
        }
        return true;
    }

    /**
     * @return Grid representation
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cases.length; i++) {
            builder.append("[").append(cases[i]).append("]");
            if (i == 2 || i == 5)
                builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
