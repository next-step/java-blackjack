package blackjack.view;

import blackjack.domain.Player;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DEALER_RECEIVED_ONE_MORE_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String RESULT_DELIMITER = " - 결과: ";
    private static final String FINAL_RESULT = "## 최종 승패";
    private static final String COLON = ": ";

    public static void printInitialCardDistribute(List<String> players) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("딜러와 ");
        String playersString = String.join(", ", players);
        stringBuilder.append(playersString);
        stringBuilder.append("에게 2장의 카드를 나누었습니다.");

        System.out.println(stringBuilder);
    }

    public static void printPlayersCard(List<Player> players) {
        players.forEach(OutputView::printJoinedCardInfo);
        printNextLine();
    }

    public static void printNextLine() {
        System.out.println();
    }

    public static void printJoinedCardInfo(Player player) {
        List<String> cardsInfo = player.getCards().stream()
            .map(card -> card.getDenomiationCountstring() + card.getSuitName())
            .collect(Collectors.toList());
        System.out.print(player.getName() + "카드: " + String.join(", ", cardsInfo));
    }

    public static void printDealerReceived() {
        System.out.println(DEALER_RECEIVED_ONE_MORE_CARD);
    }

    public static void printGameResult(List<Player> players) {
        players.forEach(player -> {
            printJoinedCardInfo(player);
            System.out.println(RESULT_DELIMITER + player.calculateScore());
        });
    }

    public static void printFinalResult(Map<String, String> results) {
        System.out.println(FINAL_RESULT);
        results.forEach((name, result) -> {
            System.out.println(name + COLON + result);
        });

    }

}
