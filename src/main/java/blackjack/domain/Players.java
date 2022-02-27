package blackjack.domain;

import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private int activePlayerIndex;

    public Players(final List<Player> players) {
        this.players = players;
        this.activePlayerIndex = 0;
    }

    public static Players create(final List<String> names) {
        final List<Player> players = names.stream()
            .map(name -> new Player(name))
            .collect(Collectors.toList());
        return new Players(players);
    }

    public void initializeDeck(final Deck deck) {
        players.forEach(player -> player.initializeDeck(deck));
    }

    public boolean checkActivePlayerCanDrawCard() {
        return getActivePlayer().canDrawCard();
    }

    public void drawCardToActivePlayer(final Deck deck) {
        getActivePlayer().drawCard(deck);
    }

    public void nextActivePlayer() {
        activePlayerIndex++;
    }

    public boolean hasActivePlayer() {
        return activePlayerIndex < players.size();
    }

    public ScoreBoard match(final Dealer dealer) {
        final Map<Player, Score> result = new LinkedHashMap<>();
        for (Player player : players) {
            result.put(player, player.compareScore(dealer));
        }

        return new ScoreBoard(result);
    }

    public CardInfo getActivePlayerCardInfo() {
        final Player player = getActivePlayer();
        return new CardInfo(player.userName, player.cards.openCardAll());
    }

    public NameInfo getActivePlayerNameInfo() {
        return new NameInfo(getActivePlayer().userName);
    }

    public List<NameInfo> nameInfos() {
        return players.stream().map(Person::nameInfo).collect(Collectors.toList());
    }

    public List<CardInfo> openCards() {
        return players.stream().map(Player::openCards).collect(Collectors.toList());
    }

    public List<ScoreInfo> scoreInfos() {
        return players.stream().map(Player::scoreInfo).collect(Collectors.toList());
    }

    private Player getActivePlayer() {
        if (activePlayerIndex >= players.size()) {
            throw new RuntimeException("해당 플레이어를 찾지 못했습니다.");
        }
        return players.get(activePlayerIndex);
    }
}
