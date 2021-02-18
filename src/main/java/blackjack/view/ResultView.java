package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.Gamer;
import blackjack.domain.Gamers;
import blackjack.domain.Score;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String PRINT_DIVIDED_CARD = "딜러와 %s에게 2장의 카드를 나누었습니다.\n";
    private static final String PRINT_IS_GOT_MORE_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String RESULT_DEALER = "딜러 카드: %s - 결과: %s\n";
    private static final String RESULT_GAMER = "%s - 결과: %s\n";
    private static final String FINAL_RESULT_MESSAGE = "\n## 최종 승패";
    private static final String FINAL_RESULT_DEALER = "딜러: %d승 %d패\n";
    private static final String GAMER_RESULT = "%s: %s\n";

    public void printGamers(Gamers gamers) {
        String gamersNames = gamers.getGamers().stream().map(Gamer::getName).collect(
                Collectors.joining(", "));
        System.out.printf(PRINT_DIVIDED_CARD, gamersNames);
    }

    public void printInitialCards(Dealer dealer, Gamers gamers) {
        System.out.println(dealer.toString());
        System.out.println(gamers.toString());
        System.out.println();
    }

    public void printCards(Gamer gamer) {
        System.out.println(gamer.toString());
    }

    public void printIsGotMoreCard(Boolean isGotMoreCard) {
        System.out.println();
        if (isGotMoreCard) {
            System.out.println(PRINT_IS_GOT_MORE_CARD);
        }
        System.out.println();
    }

    public void showResultDealer(Dealer dealer) {
        System.out.printf(RESULT_DEALER, dealer.getCards().toString(), dealer.getScore().getValue());
    }

    public void showResultGamer(Gamer gamer) {
        System.out.printf(RESULT_GAMER, gamer.toString(), gamer.getScore().getValue());
    }

    public void showWinLoseCountDealer(int winCount, int loseCount) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.printf(FINAL_RESULT_DEALER, winCount, loseCount);
    }

    public void showWinLoseResultGamers(Map<String, String> finalResult) {
        finalResult.forEach((name, result) -> System.out.printf(GAMER_RESULT, name, result));
    }
}
