package blackjack.view;

import blackjack.model.Player;

import java.util.List;

public class OutputView {

    private static final String DEALERS_DRAW_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String PLAYER_SCORE_FORMAT = " - 결과 : %d\n";
    private static final String FINAL_RESULT_MESSAGE = "\n## 최종승패";
    public static void outputPlayerStatus(Player player){
        System.out.println(player.toString());
    }

    public static void outputDealersDraw() {
        System.out.println(DEALERS_DRAW_MESSAGE);
    }
    public static void outputPlayerScore(Player player){
        //TODO: outputPlayerScore 에서는 딜러 또한 모든 카드를 출력해야 함.
        System.out.print(player.toString());
        System.out.printf(PLAYER_SCORE_FORMAT,player.getCardHandScore());
    }

    public static void outputFinalResult(List<Player> players) {
        System.out.println(FINAL_RESULT_MESSAGE);
        players.forEach(player -> System.out.println(player.getResult()));
    }
}
