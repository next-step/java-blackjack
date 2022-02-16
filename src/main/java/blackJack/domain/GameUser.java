package blackJack.domain;

import java.util.ArrayList;
import java.util.List;

public class GameUser {

    private final Dealer dealer;
    private final List<Player> players;

    private GameUser(List<String> userNames) {
        this.dealer = Dealer.create();
        this.players = new ArrayList<>();

        userNames.forEach(userName -> this.append(Player.of(userName)));
    }

    public static GameUser from(List<String> userNames) {
        return new GameUser(userNames);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public GameUser append(Player user) {
        players.add(user);
        return this;
    }
}
