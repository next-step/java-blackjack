package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.NamesInfo;
import blackjack.dto.PeopleInfo;
import blackjack.dto.PersonInfo;

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

    public static Players create(String[] names) {
        return new Players(
            Arrays
                .stream(names)
                .map(Player::new)
                .collect(Collectors.toList())
        );
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

    public void drawActivePlayerFromDeck(Deck deck) {
        getActivePlayer().drawCardFromDeck(deck);
    }

    public void endActivePlayerTurn() {
        activePlayerIdx++;
    }

    public MatchScoreBoard playMatch(Dealer dealer) {
        return new MatchScoreBoard(
            players
                .stream()
                .collect(Collectors.toMap(
                    player -> player,
                    player -> player.getMatchScore(dealer)
                ))
        );
    }

    public PersonInfo getActivePlayerInfo() {
        return getActivePlayer().getPersonInfo();
    }

    public PeopleInfo getPlayersInfo() {
        return new PeopleInfo(
            players
                .stream()
                .map(player -> player.getPersonInfo())
                .collect(Collectors.toList())
        );
    }

    public NameInfo getActivePlayerNameInfo() {
        return getActivePlayer().getNameInfo();
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
