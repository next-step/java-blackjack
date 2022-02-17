package blackjack.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Players players;
    private final Dealer dealer;
    private final CardDeck deck;

    public Game(Dealer dealer, Players players, CardDeck deck) {
        this.players = players;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void init() {
        dealer.deal(deck);
        players.deal(deck);
    }
}
