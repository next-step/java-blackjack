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
    private static final String BUST_MESSAGE = "21을 초과하여 패배하였습니다.";
    public static final String EARNING_MONEY_MESSAGE = "%s: %d\n";

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

    public void printBust() {
        System.out.println(BUST_MESSAGE);
    }

    public void showEarningMoney(String name, int money) {
        System.out.printf(EARNING_MONEY_MESSAGE, name, money);
    }
}
