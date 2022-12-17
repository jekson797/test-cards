package by.jekslab.cfr.poker;

import by.jekslab.cfr.poker.card.Card;

import java.util.*;

public class Deck {

    private final List<Card> defaultCards;
    private final List<Card> cardsInDeck = new LinkedList<>();

    public Deck(List<Card> defaultCards) {
        this.defaultCards = defaultCards;
        reset();
    }

    public int size() {
        return cardsInDeck.size();
    }

    public void reset() {
        cardsInDeck.clear();
        cardsInDeck.addAll(defaultCards);
        Collections.shuffle(cardsInDeck);
    }

    public Card pick() {
        if (size() <= 0) {
            throw new NoSuchElementException("Deck is empty - please reset the deck");
        }
        return cardsInDeck.remove(0);
    }
}
