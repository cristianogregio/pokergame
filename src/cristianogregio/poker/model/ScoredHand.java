package cristianogregio.poker.model;

import java.util.List;

// Here can be converted to record =) 
/**
 * Class representing a poker hand along with its evaluated rank and kickers.
 */
public class ScoredHand {
    private final Hand hand;
    private final HandRank rank;
    private final List<Integer> kickers;

    /**
     * Constructor to initialize a scored hand with its hand, rank, and kickers.
     */
    public ScoredHand(Hand hand, HandRank rank, List<Integer> kickers) {
        this.hand = hand;
        this.rank = rank;
        this.kickers = kickers;
    }

    public Hand getHand() {
        return hand;
    }

    public HandRank getRank() {
        return rank;
    }

    public List<Integer> getKickers() {
        return kickers;
    }

    @Override
    public String toString() {
        return hand + " -> " + rank;
    }
}
