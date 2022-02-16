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
        if (dealer.getDealerCardSum(dealer) > 21) {
            for (Player player : players.getPlayers()) {
                if (player.getPlayerCardSum(player) <= 21) {
                    gameResultList.add(0);
                }
                else {
                    gameResultList.add(1);
                }
            }
            return gameResultList;
        }

        for (Player player : players.getPlayers()) { // dealer 25 player 23 24
            if (player.getPlayerCardSum(player) > 21) {
                gameResultList.add(0);
                continue;
            }
            if(player.getPlayerCardSum(player) > dealer.getDealerCardSum(dealer)) {
                gameResultList.add(1);
            }
            if(player.getPlayerCardSum(player) < dealer.getDealerCardSum(dealer)) {
                gameResultList.add(0);
            }
            if(player.getPlayerCardSum(player) == dealer.getDealerCardSum(dealer)) {
                gameResultList.add(2);
            }
        }
        return gameResultList;
    }
}
