package cristianogregio.poker.model;

/**
 * Class representing a playing card with a rank and suit.
 */
public class Card {

    private final String rank;
    private final String suit;

    /**
     * Constructs a Card with the specified rank and suit.
     *
     * @param rank the rank of the card (e.g., "2", "3", ..., "10", "J", "Q", "K", "A")
     * @param suit the suit of the card (e.g., "H" for hearts, "D" for diamonds, "C" for clubs, "S" for spades)
     */
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}
