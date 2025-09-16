Problem Statement: 

You are required to write a program that simulates shuffling a deck of cards, dealing a poker hand for player, and scoring that hand based on standard poker hand rankings. 
After hands are dealt, determinte winner of the round. 
The deck contains 52 cards, and a poker hand consists of 5 cards. 

Requirements:
Form the Deck:
- Implement a function to create a standard deck of 52 cards.
- Create a data structure to present the card.
- Each card is represented by its rank and suit, for example, '2H' for Two of Hearts, 'QD' for Queen of Diamonds, etc.
- The ranks are: '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'.
- The suits are: 'H' (Hearts), 'D' (Diamonds), 'C' (Clubs), 'S' (Spades).
- Shuffle the deck to random order.


Deal 4 Poker Hands:
- Implement a function to deal a hand of 5 cards from a shuffled deck to 4 players. Poker hands are dealt by giving players one card in-turn until everyone has 5 cards in their hand.

Score the Hand:
- Implement a function to score the hand based on standard poker hand rankings. The possible rankings from highest to lowest are: Royal Flush Straight Flush Four of a Kind Full House Flush Straight Three of a Kind Two Pair One Pair High Card

Determine winning player: 
- Compare player's hands and print winning player, their score and hand.
