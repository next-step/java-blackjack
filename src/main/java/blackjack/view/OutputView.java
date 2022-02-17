package blackjack.view;

import static blackjack.domain.user.Players.START_CARD_INIT_SIZE;

import blackjack.domain.report.GameReports;
import blackjack.domain.card.Card;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printAllPlayersCard(Players players) {
        List<Player> candiates = players.findOnlyPlayers();
        Player dealer = players.findDealer();
        System.out.printf("\n딜러와 %s에게 %d장 나누었습니다.\n", collectPlayerNames(candiates),
            START_CARD_INIT_SIZE);
        System.out.printf("%s : %s\n", dealer.name(), collectDealerCard(dealer));
        candiates.forEach(OutputView::printEachCardInfo);
        System.out.println();
    }

    public static void printEachCardInfo(Player player) {
        System.out.printf("%s : %s\n", player.name(), collectPlayerCard(player));
    }

    public static void printDealerGetCard() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printResultStatus(List<Player> players) {
        System.out.println();
        players.forEach(OutputView::showEachResult);
    }

    public static void printReports(GameReports reports) {
        System.out.println("\n## 최종 승패");
        showDealerReports(reports);
        reports.reports()
            .stream()
            .map(report -> String.format("%s: %s", report.name(), report.message()))
            .forEach(System.out::println);
    }

    private static void showDealerReports(GameReports reports) {
        int dealerWinCount = reports.getPlayerLoseCount();
        int drawCount = reports.getPlayerDrawCount();
        int dealerLoseCount = reports.getPlayerWinCount();
        System.out.printf("딜러: %d승 %d무 %d패\n", dealerWinCount, drawCount, dealerLoseCount);
    }

    private static String collectPlayerNames(List<Player> candiates) {
        return candiates.stream()
            .map(Player::name)
            .collect(Collectors.joining(","));
    }

    private static String collectDealerCard(Player dealer) {
        List<Card> cards = dealer.getCardBundle();
        return makeCardInfo(cards.get(0));
    }

    private static String makeCardInfo(Card card) {
        return String.join("", card.message(), card.suit());
    }

    private static String collectPlayerCard(Player player) {
        List<Card> cards = player.getCardBundle();
        return cards.stream()
            .map(OutputView::makeCardInfo)
            .collect(Collectors.joining(", "));
    }

    private static void showEachResult(Player player) {
        System.out.printf("%s카드: %s - 결과 : %d\n", player.name(), collectPlayerCard(player),
            player.score());
    }
}
