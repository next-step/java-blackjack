package blackjack.domain;

import blackjack.dto.NamesInfo;
import blackjack.dto.PeopleInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;
    private int activePlayerIdx;

    public Players(List<Player> players) {
        this.players = players;
        this.activePlayerIdx = 0;
    }

    public Players(List<Player> players, int activePlayerIdx) {
        this.players = players;
        this.activePlayerIdx = activePlayerIdx;
    }

    // TODO : Change to create Players
    public static List<Player> create(String[] names) {
        return Arrays
            .stream(names)
            .map(Player::new)
            .collect(Collectors.toList());
    }

    public void initPlayers(Deck deck) {
        players
            .forEach(player -> {
                IntStream
                    .range(0, 2)
                    .forEach(i -> player.drawCardFromDeck(deck));
            });
    }

    private Player getActivePlayer() {
        return players.get(activePlayerIdx);
    }

    public boolean hasActivePlayer() {
        return activePlayerIdx < players.size();
    }

    public boolean checkActivePlayerCanDrawCard() {
        return getActivePlayer().canDrawCard();
    }

    public void drawActivePlayer(Deck deck) {
        getActivePlayer().drawCardFromDeck(deck);
    }

    public void EndActivePlayerTurn() {
        activePlayerIdx++;
    }

    public PeopleInfo getPlayersInfo() {
        return new PeopleInfo(
            players
                .stream()
                .map(player -> player.getPersonInfo())
                .collect(Collectors.toList())
        );
    }

    public NamesInfo getNamesInfo() {
        return new NamesInfo(
            players
                .stream()
                .map(player -> player.getNameInfo())
                .collect(Collectors.toList())
        );
    }
}
