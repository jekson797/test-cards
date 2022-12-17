package by.jekslab.cfr.poker.card;

public class Card implements Comparable<Card> {

    private final CardSuit cardSuit;
    private final CardRank cardRank;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.cardRank.getIntValue(), card.cardRank.getIntValue());
    }

    @Override
    public String toString() {
        return cardRank.getCharValue() + " " + cardSuit;
    }
}
