package by.jekslab.cfr.poker;

import java.util.List;

public class PokerTable {

    private final List<Player> players;
    private final Pot pot;

    private double totalChipsOntTable;

    public PokerTable(List<Player> players, Pot pot, Dealer dealer) {
        this.players = players;
        this.pot = pot;
    }

    public void update() {
        totalChipsOntTable = players.stream().mapToDouble(Player::getChipsBet).sum();
    }
}
