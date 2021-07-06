package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Dealer;
import blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printInitialCardSetting(Dealer dealer, List<Player> players) {
        List<String> names = new ArrayList<>();
        for(Player player : players) {
            names.add(player.getName());
        }
        System.out.println();
        System.out.println("딜러와 " + String.join(",", names) + "에게 2장의 카드를 나누었습니다.");
        printInitialDealerCards(dealer);
        for(Player player : players) {
            printInitialPlayerCards(player);
        }
    }

    private void printInitialDealerCards(Dealer dealer) {
        System.out.print("딜러: ");
        List<String> cards  = new ArrayList<>();
        for(Card dealerCard : dealer.getCards()) {
            cards.add(dealerCard.getDenomination() + dealerCard.getSuit());
        }
        System.out.println(String.join(", ", cards));
    }

    private void printInitialPlayerCards(Player player)  {
        System.out.print(player.getName() + "카드: ");
        List<String> cards  = new ArrayList<>();
        for(Card playerCard : player.getCards()) {
            cards.add(playerCard.getDenomination() + playerCard.getSuit());
        }
        System.out.println(String.join(", ", cards));
    }

    public void printPlayerCards() {
//        System.out.print("pobi카드: ");
//        System.out.println(String.join(", ", cards));
    }

    public void printDealerCards() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printResult() {
//        for(Participant participant : participants) {
//            participant.getName() + " 카드: " + String.join(", ", participant.getCards()) + " - 결과: " + participant.getScore();
//        }
    }

    public void printWinOrLose() {
//        System.out.println("최종 승패");
//        for(Participant participant : participants) {
//            participant.getName() + ": " + participant.getWinOrLose();
//        }
    }
}
