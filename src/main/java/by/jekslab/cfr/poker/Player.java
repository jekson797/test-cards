package by.jekslab.cfr.poker;

import by.jekslab.cfr.poker.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO tests ??
public class Player {

    private final String name;
    private final String uid = UUID.randomUUID().toString();
    private final Pot pot;
    private final List<Card> cards = new ArrayList<>();

    private int order;
    private double chips;
    private double chips_bet;
    private boolean isDealer;
    private boolean isBigBlind;
    private boolean isSmallBlind;
    private boolean isActive = true;

    public Player(String name, int chips, Pot pot) {
        this.name = name;
        this.chips = chips;
        this.pot = pot;
    }

    public void addChips(double chips) {
        this.chips += chips;
    }

    public void fold() {
        isActive = false;
    }

    public void call(List<Player> players) {
        if (!isAllIn()) {
            double biggestBet = players.stream().mapToDouble(Player::getChipsBet).max().orElse(0);
            double chipsToCall = biggestBet - chips_bet;
            addToPot(chipsToCall);
        }
    }

    public void raise(double chipsToRaise) {
        addToPot(chipsToRaise);
    }

    public void addToPot(double chipsToAdd) {
        if (chips - chipsToAdd < 0) {
            // We can't bet more than we have
            chipsToAdd = chips;
        }
        pot.addChips(this, chipsToAdd);
        chips -= chipsToAdd;
    }

    public void addPrivateCard(Card card) {
        cards.add(card);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isAllIn() {
        return isActive && chips == 0;
    }

    public double getChipsBet() {
        return chips_bet;
    }

    public String getName() {
        return name;
    }
}
