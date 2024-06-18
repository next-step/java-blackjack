package blackjack.view;

import blackjack.Dealer;
import blackjack.Player;
import blackjack.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    public boolean isProvide(Dealer dealer) {
        if( dealer.getSum() > 16){
            return false;
        }

        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        return true;
    }

    public void printTotalScore(Dealer dealer, List<Player> players) {
        System.out.println("딜러:" + dealer.toStringList() + " - 결과: " + dealer.getSum());
        players.forEach(player -> {
            System.out.println(player.getName() + "카드: " + player.toStringList() + " - 결과: " + player.getSum());
        });
    }

    public void printResult(Table table){
        System.out.println("## 최종 승패");
        final var result = table.result();
        Integer dealerWinCount = (int) result.values().stream().filter(isWin -> !isWin).count();
        System.out.println("딜러: " + dealerWinCount + "승 " + (result.size() - dealerWinCount) + "패");
        result.forEach((name, isWin) -> {
            printIsWin(name, isWin);
//            String text = "승";
//            System.out.println(name + ": " + );
        });
    }

    private void printIsWin(String name, boolean isWin) {
        if (isWin) {
            System.out.println(name + ": " + "승");
            return;
        }
        System.out.println(name + ": " + "패");
    }


}
