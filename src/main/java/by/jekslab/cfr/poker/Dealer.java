package by.jekslab.cfr.poker;

import java.util.List;

// TODO tests ??
public class Dealer {

    private final Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public void dealPrivateCards(List<Player> players) {
        for (int i = 0; i < 2; i++) {
            players.forEach(player -> player.addPrivateCard(deck.pick()));
        }
    }

    public void resetDeck() {
        deck.reset();
    }
}
