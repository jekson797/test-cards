package by.jekslab.cfr.poker;

import by.jekslab.cfr.poker.card.Card;
import by.jekslab.cfr.settings.PokerObjectsInitializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void init() {
        dealer = new Dealer(PokerObjectsInitializer.initializeDeck());
    }

    @Test
    void when_DealPrivateCard_Then_PrivateCardsSuccessfullyDealt() {
        ArgumentCaptor<Card> cardCaptor = ArgumentCaptor.forClass(Card.class);
        Player firstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);

        List<Player> players = List.of(firstPlayer, secondPlayer);
        dealer.dealPrivateCards(players);

        Mockito.verify(firstPlayer, times(2)).addPrivateCard(cardCaptor.capture());
        Mockito.verify(secondPlayer, times(2)).addPrivateCard(cardCaptor.capture());

        Set<Card> dealtCards = new HashSet<>(cardCaptor.getAllValues());
        Assertions.assertEquals(4, dealtCards.size());
    }
}
