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

    public static void printDealerCardsSetting(Dealer dealer) {
        System.out.print(dealer.getName() + ": ");
        printPlayerCards(dealer.getCards());
    }

    public static void printPlayerStatus(Players players) {
        for(Player player : players.getPlayers()) {
            System.out.print(player.getName() + "카드: ");
            printPlayerCards(player.getCards());
        }
    }

    public static void printPlayerCards(List<Card> cards) {
        for(Card card : cards) {
            System.out.print(card.getDenomination().getName() + card.getSuit().getValue());
        }
        System.out.println();
    }


}

