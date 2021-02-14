package blackjack.view;

public class OutputView {
    public void printResult(final String result) {
        System.out.println(result);
    }

    public void gameScore(final String result) {
        System.out.println();
        System.out.println("## 최종 승패");
        System.out.println(result);
    }
}
