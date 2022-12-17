package by.jekslab.cfr.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class PotTest {

    @Test
    void Given_PlayersContributions_When_GetTotal_Then_CorrectTotalReturned() {
        Pot pot = new Pot();
        Player firstPlayer = new Player("Mr.One", 2000, pot);
        Player secondPlayer = new Player("Mr.Two", 2000, pot);

        pot.addChips(firstPlayer, 120);
        pot.addChips(firstPlayer, 542);
        pot.addChips(secondPlayer, 12);
        pot.addChips(secondPlayer, 131);

        Assertions.assertEquals(805, pot.getTotalPot());
    }

    @Test
    void Given_PlayersContribution_When_ComputeSidePots_Then_SidePotsComputedCorrectly() {
        Pot pot = new Pot();
        Player firstPlayer = new Player("Mr.One", 2000, pot);
        Player secondPlayer = new Player("Mr.Two", 2000, pot);
        Player thirdPlayer = new Player("Mr.Three", 2000, pot);

        pot.addChips(firstPlayer, 20);
        pot.addChips(secondPlayer, 200);
        pot.addChips(thirdPlayer, 200);

        List<Map<String, Double>> sidePots = pot.computeSidePots();

        Assertions.assertEquals(2, sidePots.size());
        Assertions.assertEquals(3, sidePots.get(0).size());
        Assertions.assertEquals(2, sidePots.get(1).size());
    }
}
