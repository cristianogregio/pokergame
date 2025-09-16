package cristianogregio.poker.model;

import java.util.List;

/**
 * Represents a hand of playing cards.
 */
public class Hand {
    private final List<Card> cards;

    /**
     * Constructs a Hand with the given list of cards.
     *
     * @param cards The list of cards in the hand.
     */
    public Hand(List<Card> cards)
    {
        this.cards = cards;
    }

    public List<Card> getCards()
    {
        return cards;
    }

    @Override
    public String toString()
    {
        return cards.toString();
    }
}
