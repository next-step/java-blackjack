package blackjack.domain;

import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players create(List<String> names) {
        return new Players(
            names.stream()
                .map(name -> new Player(name, new Cards(new ArrayList<>())))
                .collect(Collectors.toList())
        );
    }

    public void initializeDeck(Deck deck) {
        players.stream().forEach(player -> player.initializeDeck(deck));
    }

    public List<NameInfo> getPlayersName(){
        return players.stream().map(Person::mapToNameInfo).collect(Collectors.toList());
    }

    public List<CardInfo> openCards(){
        return players.stream().map(Player::openCards).collect(Collectors.toList());
    }

}
