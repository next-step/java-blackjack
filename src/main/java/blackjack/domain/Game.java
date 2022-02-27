package blackjack.domain;

import blackjack.domain.card.CardDeck;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Hit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final int PASS_CARD_NUMBER = 2;
    private static final String DEALER_NAME = "딜러";
    private final static int DEALER_THRESHOLD = 16;

    private final List<Player> players;
    private final Dealer dealer;

    public Game(Dealer dealer, List<Player> players) {
        this.players = players;
        this.dealer = dealer;
    }

    public Game(List<String> playerNames) {
        this(new Dealer(DEALER_NAME, handOutCards()), playerNames.stream()
            .map(Game::createPlayer)
            .collect(Collectors.toList()));
    }

    private static Player createPlayer(String name) {
        return new Player(name, handOutCards());
    }

    private static Hit handOutCards() {
        CardDeck.makeCardDeck();
        return new Hit(CardDeck.pop(PASS_CARD_NUMBER));
    }

    public boolean giveCardToDealer() {
        if (dealer.getCards().cards().sumScore() <= DEALER_THRESHOLD) {
            dealer.getCards().cards().add(CardDeck.pop());
            return true;
        }
        return false;
    }

    public List<Integer> getScoresOfPlayers() {
        return players.stream()
            .mapToInt(Player::getTotalScoreOfPlayer)
            .boxed().collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Dealer getDealer() {
        return dealer;
    }
}
