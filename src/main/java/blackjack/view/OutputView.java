package blackjack.view;

import blackjack.domain.Game;
import blackjack.dto.PlayerDTO;
import blackjack.dto.FinalScoreDTO;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String CARD_TAG = "카드: ";
    private static final String RESULT_FLAG = " - 결과: ";
    private static final String RESULT_FIRST_DEAL = "딜러와 %s에게 2장의 카드를 나누었습니다.";
    private static final String DEALER_HIT_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public static void printCards(String playerNames, List<PlayerDTO> results) {
        System.out.printf((RESULT_FIRST_DEAL) + "%n", playerNames);
        for (PlayerDTO result : results) {
            printCard(result);
        }
    }

    public static void printCard(PlayerDTO result) {
        System.out.println(
            result.getName() + CARD_TAG
                + result.getCards()
        );
    }

    public static void printDealerHit() {
        System.out.println();
        System.out.println(DEALER_HIT_MESSAGE);
    }

    public static void printGameResults(List<FinalScoreDTO> results) {
        System.out.println();
        for (FinalScoreDTO result : results) {
            printResult(result);
        }
    }

    public static void printResult(FinalScoreDTO result) {
        System.out.println(
            result.getName() + CARD_TAG
                + result.getCards()
                + RESULT_FLAG + result.getScore()
        );
    }

    public static void printWinOrLose(Game game) {
        System.out.println();
        System.out.println("##최종 승패");
        printDealerResult(game);
        printPlayerResults(game.getPlayerResults());
    }

    private static void printDealerResult(Game game) {
        System.out.println(
            "딜러: " + game.getDealerWin() + game.getDealerPush() + game.getDealerLose()
        );
    }

    private static void printPlayerResults(Map<String, String> results) {
        results.forEach((name, result) -> System.out.println(name + ": " + result));
    }

}
