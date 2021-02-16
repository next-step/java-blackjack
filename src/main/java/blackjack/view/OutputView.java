package blackjack.view;

import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.PlayingCard;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INFO_INIT_RESULT = "\n%s와 %s에게 2장의 카드를 나누었습니다.";
    private static final String COMMA_DELIMITER = ", ";
    private static final String COLON_DELIMITER = "카드: ";
    private static final String INFO_DEALER_STATUS_UNDER = "\n%s는 16이하라 한장의 카드를 더 받았습니다.\n";
    private static final String INFO_DEALER_STATUS_OVER = "\n%s는 16이하라 한장의 카드를 더 받았습니다.\n";
    private static final String RESULT_DASH = " - 결과: ";
    private static final String INFO_AWARDS = "\n## 최종 승패";
    private static final String SPACE = " ";
    private static final String COLON_SPACE = ": ";
    private static final String INFO_WIN_KEYWORD = "승";
    private static final String INFO_LOSE_KEYWORD = "패";

    public static void printGameInitInfo(Dealer dealer, List<Player> players) {
        System.out.print(String.format(INFO_INIT_RESULT, dealer.getName(), players.stream()
            .map(Player::getName)
            .collect(Collectors.joining(COMMA_DELIMITER))) + "\n");

        System.out.print(dealer.getName() + COLON_DELIMITER
            + dealer.getCards().getCardsAsList().stream()
            .filter(PlayingCard::isFlipped)
            .map(card -> String.valueOf(card.getDenomination().getScore()) + card.getSuit())
            .collect(Collectors.joining(COMMA_DELIMITER)) + "\n");

        players.forEach(player -> System.out.print(player.getName() + COLON_DELIMITER
            + player.getState().cards().getCardsAsList().stream()
            .map(card -> String.valueOf(card.getDenomination().getScore()) + card.getSuit())
            .collect(Collectors.joining(COMMA_DELIMITER)) + "\n"));
        System.out.println();
    }

    public static void printDealerStatusUnder(String dealerName) {
        System.out.println(String.format(INFO_DEALER_STATUS_UNDER, dealerName));
    }

    public static void printDealerStatusOver(String dealerName) {
        System.out.println(String.format(INFO_DEALER_STATUS_OVER, dealerName));
    }

    public static void printGameResult(Dealer dealer, List<Player> players) {
        printDealerResult(dealer);
        printPlayersResult(players);
    }

    private static void printDealerResult(Dealer dealer) {
        System.out.print(dealer.getName() + COLON_DELIMITER
            + dealer.getCards().getCardsAsList().stream()
            .map(card -> String.valueOf(card.getDenomination().getScore()) + card.getSuit())
            .collect(Collectors.joining(COMMA_DELIMITER))
            + RESULT_DASH + dealer.getCards().sumScore() + "\n");
    }

    private static void printPlayersResult(List<Player> players) {
        players.forEach(player -> System.out.print(player.getName() + COLON_DELIMITER
            + player.getState().cards().getCardsAsList().stream()
            .map(card -> String.valueOf(card.getDenomination().getScore()) + card.getSuit())
            .collect(Collectors.joining(COMMA_DELIMITER))
            + RESULT_DASH + player.getState().cards().sumScore() + "\n"));

    }

    public static void printPlayerCards(Player player) {
        System.out.println(player.getName() + COLON_DELIMITER
            + player.getState().cards().getCardsAsList().stream()
            .map(card -> String.valueOf(card.getDenomination().getScore()) + card.getSuit())
            .collect(Collectors.joining(COMMA_DELIMITER)));
    }

    public static void printGameAwards(AwardsResult awardsResult) {
        System.out.println(INFO_AWARDS);
        printDealerAwards(awardsResult.getDealerGameResult());
        printPlayersAwards(awardsResult.getPlayersGameResult());

    }

    private static void printDealerAwards(Dealer dealer) {
        System.out.println(dealer.getName() + COLON_SPACE
            + dealer.getWinCount() + INFO_WIN_KEYWORD + SPACE
            + dealer.getLoseCount() + INFO_LOSE_KEYWORD);
    }

    private static void printPlayersAwards(List<Player> players) {
        players.forEach(player -> {
            System.out.print(player.getName() + COLON_SPACE);
            if (player.getIsWin()) {
                System.out.print(INFO_WIN_KEYWORD);
            }
            if (!player.getIsWin()) {
                System.out.print(INFO_LOSE_KEYWORD);
            }
            System.out.println();
        });
    }
}
