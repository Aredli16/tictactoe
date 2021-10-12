package fr.aredli.tictactoe.main.grid;

/**
 * Represent a unique case of the grid
 *
 * @author Corentin Lempereur
 * @version 1.0
 */
public class GridCase {
    /**
     * Represent the unique ID of the case
     *
     * <p>Case can be identified by his ID</p>
     */
    private int id;
    /**
     * Represent the Token content in the case
     */
    private Token content;

    /**
     * GridCase Constructor
     *
     * @param id Unique ID for the case
     *
     * <p>Define the ID for the case and a null content</p>
     * <p>If the ID isn't unique, problems can appear during win check</p>
     */
    public GridCase(int id) {
        this.id = id;
        content = null;
    }

    /**
     * @return The content of the case
     */
    public Token getContent() {
        return content;
    }

    /**
     * @param content Set the new content
     */
    public void setContent(Token content) {
        this.content = content;
    }

    /**
     * @return String representation of the case
     *
     * <p>Value depends on content value</p>
     */
    @Override
    public String toString() {
        if (content == null)
            return Integer.toString(id);
        else
            return content.toString();
    }
}
