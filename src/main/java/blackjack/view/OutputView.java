package blackjack.view;

import blackjack.domain.Card;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    String START_MESSAGE = "딜러와 %s 에게 2장을 나누었습니다.\n";
    String CURRENT_STATE_MESSAGE = "%s 카드 : %s\n";
    String RESULT_MESSAGE = "%s 카드 : %s - 결과: %s\n";

    public void printStartMessage(List<String> players) {
        System.out.printf(START_MESSAGE, String.join(", ", players));
    }

    public void printCurrentCardsState(String name, List<Card> cards) {
        System.out.printf(CURRENT_STATE_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(", ")));
    }

    public void printResult(String name, List<Card> cards, int score) {
        System.out.printf(RESULT_MESSAGE, name, cards.stream().map(Card::toString)
            .collect(Collectors.joining(", ")), score);
    }
}
