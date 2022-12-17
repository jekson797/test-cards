package by.jekslab.cfr.poker.card;

import by.jekslab.cfr.poker.card.Card;
import by.jekslab.cfr.poker.card.CardRank;
import by.jekslab.cfr.poker.card.CardSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardTest {

    @Test
    void given_CardsList_When_Sort_Then_SortedSuccessfully() {
        Card lowerCard = new Card(CardSuit.SPADES, CardRank.EIGHT);
        Card higherCard = new Card(CardSuit.CLUBS, CardRank.ACE);
        List<Card> cards = new LinkedList<>(Arrays.asList(
                higherCard,
                lowerCard
        ));
        Collections.sort(cards);

        Assertions.assertEquals(lowerCard, cards.get(0));
        Assertions.assertEquals(higherCard, cards.get(1));
    }
}
