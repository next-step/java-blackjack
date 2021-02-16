package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;
import blackjack.dto.PlayersInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;
    private Integer currentPlayerIdx;

    public Players(List<Player> players) {
        this.players = players;
        this.currentPlayerIdx = 0;
    }

    public Players(List<Player> players, Integer currentPlayerIdx) {
        this.players = players;
        this.currentPlayerIdx = currentPlayerIdx;
    }

    public void incrementPlayerIndex() {
        currentPlayerIdx++;
    }

    public boolean hasUser() {
        return currentPlayerIdx < players.size();
    }

    public void drawCurrentPlayerCard(Deck deck) {
        players.get(currentPlayerIdx).drawCard(deck);
    }

    public boolean getCurrentPlayerStatus() {
        return players.get(currentPlayerIdx).canDraw();
    }

    public NameInfo getCurrentPlayerNameInfo() {
        return players.get(currentPlayerIdx).getNameInfo();
    }

    public PersonInfo getCurrentPlayerPersonInfo() {
        return players.get(currentPlayerIdx).getPersonInfo();
    }

    public void initCards(Deck deck) {
        players.forEach(player -> player.initialCard(deck));
    }

    public PlayersInfo getPlayersInfo() {
        return new PlayersInfo(
                players.stream().map(Person::getPersonInfo).collect(Collectors.toList())
        );
    }

    public Map<String, String> getResult(Dealer dealer, ScoreBoard scoreBoard) {
        Map<String, String> result = new HashMap<>();
        for (Player player : players) {
            result.put(player.name, scoreBoard.updateScore(dealer.cardBunch, player.cardBunch).getName());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players) && Objects.equals(currentPlayerIdx, players1.currentPlayerIdx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, currentPlayerIdx);
    }
}
