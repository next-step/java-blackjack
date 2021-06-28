package blackjack.view;

public class OutputView {
    public void outputPlayerCards() {
//        System.out.print("pobi카드: ");
//        System.out.println(String.join(", ", cards));
    }

    public void outputDealerCards() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void outputResult() {
//        for(Participant participant : participants) {
//            participant.getName() + " 카드: " + String.join(", ", participant.getCards()) + " - 결과: " + participant.getScore();
//        }
    }

    public void outputWinOrLose() {
//        System.out.println("최종 승패");
//        for(Participant participant : participants) {
//            participant.getName() + ": " + participant.getWinOrLose();
//        }
    }
}
