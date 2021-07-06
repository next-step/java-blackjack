package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Dealer;
import blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printInitialCardSetting(Dealer dealer, List<Player> players) {
        List<String> names = new ArrayList<>();
        for (Player player : players) {
            names.add(player.getName());
        }
        System.out.println();
        System.out.println("딜러와 " + String.join(",", names) + "에게 2장의 카드를 나누었습니다.");

        printInitialDealerCards(dealer);
        for (Player player : players) {
            printInitialPlayerCards(player);
        }
        System.out.println();
    }

    private void printInitialDealerCards(Dealer dealer) {
        System.out.print("딜러: ");
        List<String> cards = new ArrayList<>();
        for (Card dealerCard : dealer.getCards()) {
            cards.add(dealerCard.getDenominationName() + dealerCard.getSuitName());
        }
        System.out.println(String.join(", ", cards));
    }

    private void printInitialPlayerCards(Player player) {
        System.out.print(player.getName() + "카드: ");
        List<String> cards = new ArrayList<>();
        for (Card playerCard : player.getCards()) {
            cards.add(playerCard.getDenominationName() + playerCard.getSuitName());
        }
        System.out.println(String.join(", ", cards));
    }

    public void printAdditionalPlayerCards(Player player) {
        System.out.print(player.getName() + "카드: ");
        List<String> cards = new ArrayList<>();
        for (Card playerCard : player.getCards()) {
            cards.add(playerCard.getDenominationName() + playerCard.getSuitName());
        }
        System.out.println(String.join(", ", cards));
    }

    public void printAdditionalDealerCards() {
        System.out.println();
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printResult(Dealer dealer, List<Player> players) {
        System.out.println();
        printResultDealerCards(dealer);
        for (Player player : players) {
            printResultPlayerCards(player);
        }
        System.out.println();
    }

    private void printResultDealerCards(Dealer dealer) {
        System.out.print("딜러 카드: ");
        List<String> cards = new ArrayList<>();
        for (Card dealerCard : dealer.getCards()) {
            cards.add(dealerCard.getDenominationName() + dealerCard.getSuitName());
        }
        System.out.print(String.join(", ", cards));
        System.out.println(" - 결과: " + dealer.score());
    }

    private void printResultPlayerCards(Player player) {
        System.out.print(player.getName() + "카드: ");
        List<String> cards = new ArrayList<>();
        for (Card playerCard : player.getCards()) {
            cards.add(playerCard.getDenominationName() + playerCard.getSuitName());
        }
        System.out.print(String.join(", ", cards));
        System.out.println(" - 결과: " + player.score());
    }

    public void printWinOrLose() {
//        System.out.println("최종 승패");
//        for(Participant participant : participants) {
//            participant.getName() + ": " + participant.getWinOrLose();
//        }
    }
}
