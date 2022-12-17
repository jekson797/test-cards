package by.jekslab.cfr.poker;

import by.jekslab.cfr.poker.card.Card;
import by.jekslab.cfr.poker.card.CardRank;
import by.jekslab.cfr.poker.card.CardSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

class DeckTest {

    @Test
    void given_ValidDeck_When_Pick_Then_CardPickedSuccessful() {
        List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardRank.ACE),
                new Card(CardSuit.SPADES, CardRank.EIGHT)
        );
        Deck deck = new Deck(cards);
        Assertions.assertEquals(2, deck.size());

        Card card1 = deck.pick();
        Card card2 = deck.pick();
        Set<Card> resultCards = Set.of(card1, card2);

        Assertions.assertTrue(resultCards.containsAll(cards));
        Assertions.assertEquals(0, deck.size());
    }

    @Test
    void given_ValidDeck_When_Reset_Then_DeckResetSuccessfully() {
        List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardRank.ACE),
                new Card(CardSuit.SPADES, CardRank.EIGHT)
        );
        Deck deck = new Deck(cards);
        Assertions.assertEquals(2, deck.size());

        deck.pick();
        deck.pick();
        Assertions.assertEquals(0, deck.size());

        deck.reset();
        Assertions.assertEquals(2, deck.size());
    }

    @Test
    void given_EmptyDeck_When_Pick_Then_ThrowException() {
        Deck deck = new Deck(Collections.emptyList());
        Assertions.assertThrows(NoSuchElementException.class, deck::pick);
    }
}
