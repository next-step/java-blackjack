package blackjack.domain;

import java.util.List;
import java.util.Objects;

public class Players {
    private final List<Player> players;
    private Integer currentPlayerIdx;
    private Player currentPlayer;

    public Players(List<Player> players) {
        this.players = players;
        this.currentPlayerIdx = 0;
        this.currentPlayer = players.get(currentPlayerIdx);
    }
    
    public Players(List<Player> players, Integer currentPlayerIdx) {
        this.players = players;
        this.currentPlayerIdx = currentPlayerIdx;
        this.currentPlayer = players.get(currentPlayerIdx);
    }

    public void doAction(boolean isDrawCard, Deck deck) {
        if (isDrawCard) {
            currentPlayer.requestCard(deck);
        } else {
            currentPlayer = players.get(++currentPlayerIdx);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players) && Objects.equals(currentPlayerIdx, players1.currentPlayerIdx) && Objects.equals(currentPlayer, players1.currentPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, currentPlayerIdx, currentPlayer);
    }

}
