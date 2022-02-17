package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.gamer.Dealer;
import blackjack.domain.gamer.Gamer;
import blackjack.domain.matchInfo.DealerMatchResultInfo;
import blackjack.domain.matchInfo.PlayerMatchResultInfo;
import blackjack.domain.gamer.Player;
import blackjack.domain.gamer.Players;
import java.util.List;

public class OutputView {
    private static final String REQUEST_PLAYERS_NAME = "게임에 참여할 사람의 이름을 입력하세요";
    private static final String DELIMITER = ", ";
    private static final String REQUEST_RECEIVE_CARD = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String DEALER_ADD_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String FINAL_GAME_RESULT = "## 최종 승패";
    private static final String MATCH_SCORE_INFO_FMT = "%s: %s\n";
    private static final String DEALER_MATCH_SCORE_DELIMITER = " ";

    private OutputView() {}

    public static void requestPlayersName() {
        System.out.println(REQUEST_PLAYERS_NAME);
    }

    public static void printGamePlayer(String[] players) {
        System.out.println(String.join(DELIMITER, players));
    }

    public static void printCardsSetting(String[] players) {
        System.out.println("딜러와 " + String.join(DELIMITER, players) + "에게 2장의 카드를 나누었습니다.");
    }

    public static void printDealerCardsSetting(Gamer dealer, boolean flag) {
        System.out.print(dealer.getName() + ": ");
        printPlayerCards(dealer.getCards(), flag);
    }

    public static void printPlayersStatus(Players players) {
        for(Player player : players.getPlayers()) {
            System.out.print(player.getName() + "카드: ");
            printPlayerCards(player.getCards(), true);
        }
    }

    public static void printPlayerCards(List<Card> cards, boolean flag) {
        for(Card card : cards) {
            System.out.print(card.getDenomination().getName() + card.getSuit().getValue());
        }
        if(flag) System.out.println();
    }

    public static void requestAddCardOrNot(Player player) {
        System.out.println(player.getName() + REQUEST_RECEIVE_CARD);
    }

    public static void printPlayerStatus(Player player) {
        System.out.print(player.getName() + ": ");
        printPlayerCards(player.getCards(), true);
    }

    public static void printDealerAddCard() {
        System.out.println(DEALER_ADD_CARD);
        System.out.println();
    }

    public static void printDealerCardSum(Gamer dealer) {
        printDealerCardsSetting(dealer, false);
        System.out.println("- 결과:" + dealer.calcScore(dealer));

    }

    public static void printPlayerCardSum(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.print(player.getName() + ": ");
            printPlayerCards(player.getCards(), false);
            System.out.println("- 결과" + player.calcScore(player));
        }
    }

    public static void printFinalGameResult() {
        System.out.println(FINAL_GAME_RESULT);
    }

    public static void printDealerMatchResult(Gamer dealer, DealerMatchResultInfo dealerMatchScoreInfo) {
        System.out.format(
            MATCH_SCORE_INFO_FMT,
            dealer.getName(),
            String.join(
                DEALER_MATCH_SCORE_DELIMITER,
                dealerMatchScoreInfo.getMatchResult()
            )
        );
    }

    public static void printPlayersMatchResult(List<PlayerMatchResultInfo> playerMatchScoreInfos) {
        for(PlayerMatchResultInfo playerMatchScoreInfo : playerMatchScoreInfos) {
            printPlayerMatchResult(playerMatchScoreInfo);
        }
    }

    public static void printPlayerMatchResult(PlayerMatchResultInfo playerMatchScoreInfo) {
        System.out.println(playerMatchScoreInfo.getName() + ":" + playerMatchScoreInfo.getMatchResult());
    }
}
