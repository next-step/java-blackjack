package blackjack.controller;

import blackjack.domain.card.CardFactory;
import blackjack.domain.card.Deck;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import blackjack.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJack {

    private final Players players;
    private final Deck deck;

    private BlackJack(Players players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public static BlackJack init(List<String> playerNames) {
        Dealer dealer = new Dealer();
        Players candidates = playerNames.stream()
            .map(Player::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(),
                players -> new Players(dealer, players)));
        CardFactory cardFactory = CardFactory.getInstance();
        Deck deck = new Deck(cardFactory.createCards());
        return new BlackJack(candidates, deck);
    }

    public void runGame() {
        spreadStartCards();
    }

    private void spreadStartCards() {
        players.drawStartCards(deck);
    }
}
