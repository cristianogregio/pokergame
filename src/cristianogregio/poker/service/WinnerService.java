package cristianogregio.poker.service;

import cristianogregio.poker.model.Hand;
import cristianogregio.poker.model.ScoredHand;

import java.util.List;

/**
 * Service class to determine the winning poker hand among multiple hands.
 */
public class WinnerService {
    private final HandEvaluator evaluator = new HandEvaluator();

    /**
     * Determines the winning hand from a list of hands.
     *
     * @param hands List of hands to evaluate.
     * @return The winning scored hand.
     */
    public ScoredHand determineWinner(List<Hand> hands) {
        return hands.stream()
                .map(evaluator::scoreHand)
                .max((scoredHand1, scoredHand2) -> {
                    if (scoredHand1.getRank().getRankValue() != scoredHand2.getRank().getRankValue()) {
                        return Integer.compare(scoredHand1.getRank().getRankValue(), scoredHand2.getRank().getRankValue());
                    } else {
                        for (int i = 0; i < Math.min(scoredHand1.getKickers().size(), scoredHand2.getKickers().size()); i++) {
                            int cmp = Integer.compare(scoredHand1.getKickers().get(i), scoredHand2.getKickers().get(i));
                            if (cmp != 0) return cmp;
                        }
                        return 0;
                    }
                })
                .get();
    }
}
