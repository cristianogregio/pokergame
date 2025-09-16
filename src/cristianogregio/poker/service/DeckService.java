package cristianogregio.poker.service;

import cristianogregio.poker.model.Card;
import cristianogregio.poker.model.Hand;

import java.util.*;

/**
 * Service class for creating and dealing a deck of cards.
 */
public class DeckService {

    /**
     * Array of card ranks from 2 to Ace.
     */
    private static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    /**
     * Array of card suits: Hearts (H), Diamonds (D), Clubs (C), Spades (S).
     */
    private static final String[] SUITS = {"H", "D", "C", "S"};

    /**
     * Creates and shuffles a standard 52-card deck.
     *
     * @return A shuffled list of cards representing the deck.
     */
    public List<Card> createDeck()
    {
        List<Card> deck = new ArrayList<>();
        for (String rank : RANKS)
        {
            for (String suit : SUITS)
            {
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    /**
     * Deals hands to players from the given deck.
     *
     * @param deck       The deck of cards to deal from.
     * @param numPlayers The number of players to deal hands to.
     * @return A list of hands, one for each player.
     */
    public List<Hand> dealHands(List<Card> deck, int numPlayers)
    {
        List<Hand> hands = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++)
        {
            hands.add(new Hand(new ArrayList<>()));
        }

        for (int round = 0; round < 5; round++)
        {
            for (int i = 0; i < numPlayers; i++)
            {
                hands.get(i).getCards().add(deck.remove(0));
            }
        }
        return hands;
    }
}
