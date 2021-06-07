package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> users = new ArrayList<>();

    public Players(List<String> users) {
        for (String user : users) {
            this.users.add(PlayerFactory.of(user));
        }
    }

    public List<Player> getUser() {
        return this.users;
    }

    public List<String> getUserNames() {

        return this.users.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
