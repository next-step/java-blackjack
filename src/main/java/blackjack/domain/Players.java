package blackjack.domain;

import blackjack.dto.CardInfo;
import blackjack.dto.MatchInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public boolean checkActivePlayerCanDrawCard() {
        return getActivePlayer().canDrawCard();
    }

    private Player getActivePlayer() {
        return players.get(activePlayerIdx);
    }

    public NameInfo getActivePlayerNameInfo() {
        return new NameInfo(getActivePlayer().userName);
    }

    public void drawCardToActivePlayer(Deck deck) {
        getActivePlayer().drawCard(deck);
    }

    public CardInfo getActivePlayerCardsInfo() {
        Player player = getActivePlayer();
        return new CardInfo(player.userName, player.cards.openCardAll());
    }

    public void nextActivePlayer() {
        activePlayerIdx++;
    }

    public boolean hasActivePlayer() {
        return activePlayerIdx < players.size();
    }

    public List<ScoreInfo> getScoreInfo() {
        return players.stream().map(Player::getScoreInfo).collect(Collectors.toList());
    }

    public ScoreBoard match(Dealer dealer) {
        Map<Player, Score> map = new LinkedHashMap<>();
        for (Player player: players) {
            map.put(player, player.compareScore(dealer));
        }

        return new ScoreBoard(map);
    }
}
