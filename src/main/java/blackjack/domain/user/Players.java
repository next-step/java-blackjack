package blackjack.domain.user;

import blackjack.domain.card.Deck;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static final int START_CARD_INIT_SIZE = 2;

    private final List<Player> players = new ArrayList<>();

    public Players(Dealer dealer, List<Player> players) {
        this.players.add(dealer);
        this.players.addAll(players);
    }

    public List<Player> findOnlyPlayers() {
        return players.stream()
            .filter(Player::isPlayer)
            .collect(Collectors.toList());
    }

    public Player findDealer() {
        return players.stream()
            .filter(Player::isDealer)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 딜러가 존재하지 않습니다."));
    }

    public boolean hasBlackJack() {
        return players.stream()
            .anyMatch(Player::isBlackJack);
    }

    public void drawStartCards(Deck deck) {
        for (int i = 0; i < START_CARD_INIT_SIZE; i++) {
            players.forEach(player -> player.drawCard(deck.spreadCard()));
        }
    }
}
