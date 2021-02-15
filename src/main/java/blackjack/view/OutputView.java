package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Player;

public class OutputView {

    private static final String DEALERS_DRAW_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String PLAYER_SCORE_FORMAT = " - 결과 : %d\n";
    public static void outputPlayerStatus(Player player){
        System.out.println(player.toString());
    }

    public static void outputDealersDraw() {
        System.out.println(DEALERS_DRAW_MESSAGE);
    }
    public static void outputPlayerScore(Player player){
        System.out.print(player.toString());
        System.out.printf(PLAYER_SCORE_FORMAT,player.getCardHandScore());
    }
}
