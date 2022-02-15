package blackjack.view;

import blackjack.domain.Card.Card;
import blackjack.domain.Card.Dealer;
import blackjack.domain.Card.Player;
import blackjack.domain.Card.Players;
import java.util.List;

public class OutputView {
    private static final String REQUEST_PLAYERS_NAME = "게임에 참여할 사람의 이름을 입력하세요";
    private static final String DELIMITER = ", ";
    private static final String REQUEST_RECEIVE_CARD = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String DEALER_ADD_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String FINAL_GAME_RESULT = "## 최종 승패";

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

    public static void printDealerCardsSetting(Dealer dealer, boolean flag) {
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

    public static void printDealerCardSum(Dealer dealer) {
        printDealerCardsSetting(dealer, false);
        System.out.println("- 결과:" + dealer.getPlayerCardSum(dealer));

    }

    public static void printPlayerCardSum(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.print(player.getName() + ": ");
            printPlayerCards(player.getCards(), false);
            System.out.println("- 결과" + player.getPlayerCardSum(player));
        }
    }

    public static void printFinalGameResult() {
        System.out.println(FINAL_GAME_RESULT);
    }

    public static void printGameResult(List<Integer> gameResultList, Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        long win = gameResultList.stream().filter(result -> result == 0).count();
        long lose = gameResultList.stream().filter(result -> result == 1).count();
        stringBuilder.append("딜러: ").append(win + "승").append(lose + "패");
        System.out.println(stringBuilder);
        // 플레이어
        for(int i = 0; i < gameResultList.size(); i++) {
            if(gameResultList.get(i) == 1) {
                System.out.println(players.getPlayers().get(i).getName() + "승");
            }
            if(gameResultList.get(i) == 0) {
                System.out.println(players.getPlayers().get(i).getName() + "패");
            }
        }

    }
}
