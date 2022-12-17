package by.jekslab.cfr.settings;

import by.jekslab.cfr.poker.Deck;
import by.jekslab.cfr.poker.card.Card;
import by.jekslab.cfr.poker.card.CardRank;
import by.jekslab.cfr.poker.card.CardSuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO Add property usage
public class PokerObjectsInitializer {

    public static Deck initializeDeck() {
        CardRank[] ranks = Arrays
                .stream(CardRank.values())
                .filter(rank -> rank.getIntValue() >= 10)
                .toArray(CardRank[]::new);
        CardSuit[] suits = CardSuit.values();

        List<Card> cards = new ArrayList<>();
        for (CardSuit suit : suits) {
            for (CardRank rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        return new Deck(cards);
    }
}
