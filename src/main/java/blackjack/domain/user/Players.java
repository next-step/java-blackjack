package blackjack.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

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
}
