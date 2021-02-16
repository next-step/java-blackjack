package blackjack.domain;

import blackjack.dto.PersonMatchProfitInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PersonCardsInfo;
import blackjack.dto.ScoreInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static Players create(Map<String, Integer> playerItems) {
        return new Players(
            playerItems
                .entrySet()
                .stream()
                .map(map -> new Player(map.getKey(), map.getValue()))
                .collect(Collectors.toList())
        );
    }

    public void initializeFromDeck(Deck deck) {
        players.forEach(player -> player.initializeFromDeck(deck));
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

    public List<PersonMatchProfitInfo> playMatch(Dealer dealer) {
        List<PersonMatchProfitInfo> peopleProfitInfo = players
            .stream()
            .map(player -> player.getPlayerMatchProfitInfo(dealer))
            .collect(Collectors.toList());
        peopleProfitInfo.add(0, dealer.getDealerProfitInfo());

        return peopleProfitInfo;
    }

    public NameInfo getActivePlayerNameInfo() {
        return getActivePlayer().getNameInfo();
    }

    public PersonCardsInfo getActivePlayerCardsInfo() {
        return getActivePlayer().getPersonCardsInfo();
    }

    public List<NameInfo> getPlayersNameInfo() {
        return players
            .stream()
            .map(Person::getNameInfo)
            .collect(Collectors.toList());
    }

    public List<PersonCardsInfo> getPlayersCardsInfo() {
        return players
            .stream()
            .map(Person::getPersonCardsInfo)
            .collect(Collectors.toList());
    }

    public List<ScoreInfo> getPlayersScoreInfo() {
        return players
            .stream()
            .map(Person::getScoreInfo)
            .collect(Collectors.toList());
    }
}
