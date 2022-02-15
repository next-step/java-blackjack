package blackjack.domain.Card;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private Players players;
    private Dealer dealer;

    public GameResult(Players players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    // list 승 1 패 0 players 3명 yang 1, woo 1 ,jeung 0
    public List<Integer> getGameResult() {
        List<Integer> gameResultList = new ArrayList<>();
        for(Player player : players.getPlayers()) {
            if(player.getPlayerCardSum(player) > dealer.getPlayerCardSum(dealer)) {
                gameResultList.add(1);
            }
            if(player.getPlayerCardSum(player) < dealer.getPlayerCardSum(dealer)) {
                gameResultList.add(0);
            }
            if(player.getPlayerCardSum(player) == dealer.getPlayerCardSum(dealer)) {
                gameResultList.add(2);
            }
        }
        return gameResultList;
    }
}
