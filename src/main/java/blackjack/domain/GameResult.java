package blackjack.domain;

import static blackjack.utils.Constant.LOSE;
import static blackjack.utils.Constant.PUSH;
import static blackjack.utils.Constant.WIN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final Map<String, String> playerResults = new HashMap<>();
    private final Map<String, Integer> dealersResults = new HashMap<>();

    public void mapResults(Players players, Dealer dealer) {
        for (Player player : players.get()) {
            playerResults.put(player.getName(), player.getGameResult(dealer));
        }
        updateDealerResult(dealer);
    }

    private void updateDealerResult(Dealer dealer) {
        for (String result : playerResults.values()) {
            if (dealer.isBusted()) {
                dealersResults.put(LOSE, dealersResults.getOrDefault(LOSE, 0) + 1);
                continue;
            }
            String deal = WIN;
            if (result.equals(WIN)) {
                deal = LOSE;
            }
            if (result.equals(PUSH)) {
                deal = PUSH;
            }
            dealersResults.put(deal, dealersResults.getOrDefault(deal, 0) + 1);
        }
    }

    public Map<String, String> getPlayerResults() {
        return playerResults;
    }

    public String getDealerResult() {
        StringBuilder result = new StringBuilder();
        List<String> orders = Arrays.asList(WIN, PUSH, LOSE);

        for (String order : orders) {
            if (dealersResults.containsKey(order)) {
                result.append(dealersResults.get(order)).append(order);
            }
        }

        return result.toString();
    }

}
