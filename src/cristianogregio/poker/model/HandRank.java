package cristianogregio.poker.model;

/**
 * Enum representing the rank of a poker hand.
 */
public enum HandRank {
    ROYAL_FLUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(1);

    private final int rankValue;

    /**
     * Constructor to initialize the rank value.
     *
     * @param value The integer value representing the hand rank.
     */
    HandRank(int value) {
        this.rankValue = value;
    }

    public int getRankValue() {
        return rankValue;
    }
}
