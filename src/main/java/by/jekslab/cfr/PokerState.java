package by.jekslab.cfr;

import by.jekslab.cfr.poker.Player;

import java.util.List;

// TODO tests ??
public class PokerState {

    public PokerState(
            List<Player> players,
            int smallBlind,
            int bigBlind
            //TODO Load the "LookupTable" from system
    ) {
        if (players.size() <= 1) {
            throw new IllegalArgumentException("At least 2 players must be provided");
        }
    }
}
