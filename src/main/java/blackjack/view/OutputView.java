package blackjack.view;

import blackjack.model.Player;
import blackjack.utils.StringUtils;

import java.util.List;

public class OutputView {
    private OutputView() {}

    public static void outputPlayerStatus(Player player) {
        System.out.println(player.toString());
    }

    public static void outputDealersDraw() {
        System.out.println(StringUtils.DEALERS_DRAW_MESSAGE);
    }

    public static void outputPlayerScore(Player player) {
        System.out.print(player.toString());
        System.out.printf(StringUtils.PLAYER_SCORE_FORMAT, player.getCardHandScore());
    }

    public static void outputFinalResult(List<Player> players) {
        System.out.println(StringUtils.FINAL_RESULT_MESSAGE);
        players.forEach(player -> System.out.println(player.getResult()));
    }
}
