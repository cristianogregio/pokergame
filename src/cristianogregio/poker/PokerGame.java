package cristianogregio.poker;

import cristianogregio.poker.model.Hand;
import cristianogregio.poker.service.*;

import java.util.List;

/**
 * Main class to run the Poker game simulation.
 */
public class PokerGame {
    public static void main(String[] args) {
        DeckService deckService = new DeckService();
        HandEvaluator evaluator = new HandEvaluator();
        WinnerService winnerService = new WinnerService();

        var deck = deckService.createDeck();
        List<Hand> hands = deckService.dealHands(deck, 5);

        System.out.println("Players' Hands:");
        for (int i = 0; i < hands.size(); i++) {
            var scored = evaluator.scoreHand(hands.get(i));
            System.out.printf("Player %d *** Hand: %s -> Score: %s%n", i + 1, hands.get(i), scored.getRank());
        }

        var winner = winnerService.determineWinner(hands);
        System.out.println("\nWinner:");
        System.out.println(winner.getHand() + " -> " + winner.getRank());
    }
}
