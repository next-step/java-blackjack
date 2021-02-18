package blackjack.view;

import blackjack.model.Player;

import java.util.List;

public class OutputView {

    private static final String DEALERS_DRAW_MESSAGE = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String PLAYER_SCORE_FORMAT = " - 결과 : %d\n";
    private static final String FINAL_RESULT_MESSAGE = "\n## 최종 승패";
    private static final String FINAL_REVENUE_MESSAGE = "\n## 최종 수익";
    private static final String FINAL_REVENUE_FOR_EACH_PLAYER_MESSAGE = "%s: %d\n";
    public void outputPlayerStatus(Player player){
        System.out.println(player.toString());
    }

    public void outputDealersDraw() {
        System.out.println(DEALERS_DRAW_MESSAGE);
    }
    public void outputPlayerScore(Player player){
        //TODO: outputPlayerScore 에서는 딜러 또한 모든 카드를 출력해야 함.
        System.out.print(player.toString());
        System.out.printf(PLAYER_SCORE_FORMAT,player.getCardHandScore());
    }

    public void outputFinalResult(List<Player> players) {
        System.out.println(FINAL_RESULT_MESSAGE);
        players.forEach(player -> System.out.println(player.getResult()));
    }

    public void outputFinalRevenue(List<Player> players) {
        System.out.println(FINAL_REVENUE_MESSAGE);
        players.forEach(player -> System.out.printf(FINAL_REVENUE_FOR_EACH_PLAYER_MESSAGE,player.getName(),player.getMoney().getMoney()));
    }
}
