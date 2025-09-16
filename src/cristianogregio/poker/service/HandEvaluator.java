package cristianogregio.poker.service;

import cristianogregio.poker.model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to evaluate and score poker hands.
 */
public class HandEvaluator {
    private static final Map<String, Integer> RANK_VALUES = Map.ofEntries(
            Map.entry("2", 2), Map.entry("3", 3), Map.entry("4", 4),
            Map.entry("5", 5), Map.entry("6", 6), Map.entry("7", 7),
            Map.entry("8", 8), Map.entry("9", 9), Map.entry("10", 10),
            Map.entry("J", 11), Map.entry("Q", 12), Map.entry("K", 13),
            Map.entry("A", 14)
    );

    /**
     * Scores a poker hand and returns its rank and relevant kickers/tiebackers.
     *
     * @param hand The hand to score.
     * @return A ScoredHand object containing the hand, its rank, and kickers.
     */
    public ScoredHand scoreHand(Hand hand) {
        List<Integer> values = hand.getCards().stream()
                .map(c -> RANK_VALUES.get(c.getRank()))
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, Long> counts = values.stream()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        boolean flush = hand.getCards().stream().map(Card::getSuit).distinct().count() == 1;
        boolean straight = isStraight(values);

        // Royal Flush
        if (flush && straight && values.containsAll(List.of(10, 11, 12, 13, 14))) {
            return new ScoredHand(hand, HandRank.ROYAL_FLUSH, values);
        }
        // Straight Flush
        if (flush && straight) {
            return new ScoredHand(hand, HandRank.STRAIGHT_FLUSH, List.of(Collections.max(values)));
        }
        // Four of a Kind
        if (counts.containsValue(4L)) {
            int four = counts.entrySet().stream().filter(e -> e.getValue() == 4).map(Map.Entry::getKey).findFirst().get();
            return new ScoredHand(hand, HandRank.FOUR_OF_A_KIND, List.of(four));
        }
        // Full House
        if (counts.containsValue(3L) && counts.containsValue(2L)) {
            int three = counts.entrySet().stream().filter(e -> e.getValue() == 3).map(Map.Entry::getKey).findFirst().get();
            int pair = counts.entrySet().stream().filter(e -> e.getValue() == 2).map(Map.Entry::getKey).findFirst().get();
            return new ScoredHand(hand, HandRank.FULL_HOUSE, List.of(three, pair));
        }
        // Flush
        if (flush) {
            return new ScoredHand(hand, HandRank.FLUSH, reverseSort(values));
        }
        // Straight
        if (straight) {
            return new ScoredHand(hand, HandRank.STRAIGHT, List.of(Collections.max(values)));
        }
        // Three of a Kind
        if (counts.containsValue(3L)) {
            int three = counts.entrySet().stream().filter(e -> e.getValue() == 3).map(Map.Entry::getKey).findFirst().get();
            return new ScoredHand(hand, HandRank.THREE_OF_A_KIND, List.of(three));
        }
        // Two Pair
        if (counts.values().stream().filter(v -> v == 2).count() == 2) {
            List<Integer> pairs = counts.entrySet().stream()
                    .filter(e -> e.getValue() == 2)
                    .map(Map.Entry::getKey)
                    .sorted(Comparator.reverseOrder())
                    .toList();
            return new ScoredHand(hand, HandRank.TWO_PAIR, pairs);
        }
        // One Pair
        if (counts.containsValue(2L)) {
            int pair = counts.entrySet().stream().filter(e -> e.getValue() == 2).map(Map.Entry::getKey).findFirst().get();
            return new ScoredHand(hand, HandRank.ONE_PAIR, List.of(pair));
        }
        // High Card
        return new ScoredHand(hand, HandRank.HIGH_CARD, reverseSort(values));
    }

    /** Check if the list of values represents a straight */
    private boolean isStraight(List<Integer> values) {
        // Handle A-2-3-4-5 straight
        if (values.equals(List.of(2, 3, 4, 5, 14))) {
            return true;
        }
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i + 1) - values.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    /** Return a list sorted in reverse order
     * This is used for kickers/tiebackers in high card and flush hands
     * because higher cards are more significant than lower cards.
     * */
    private List<Integer> reverseSort(List<Integer> values) {
        return values.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
