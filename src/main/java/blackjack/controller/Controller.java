package blackjack.controller;

import blackjack.domain.Card;
import blackjack.domain.CardDeck;
import blackjack.domain.Cards;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public static void run() {


        List<Player> players = InputView.inputPlayers().stream()
            .map(name -> new Player(name, new Cards(CardDeck.pop(2))))
            .collect(Collectors.toList());

        Dealer dealer = new Dealer(new Cards(CardDeck.pop(2)));

        OutputView.printStartMessage(players);
        System.out.println("딜러 : " + dealer.getCards().cards().get(0)); // 하나만 뽑혀야 함

        players.forEach(player -> OutputView.printCurrentCardsState(player.getName(),
            player.getCards().cards()));

        for (Player player : players) {
            String yesOrNo = "";
            do {
                yesOrNo = InputView.inputYesOrNo(player.getName());
                if (yesOrNo.equals("y")) {
                    player.getCards().addCard(CardDeck.pop());
                    OutputView.printCurrentCardsState(player.getName(), player.getCards().cards());
                    int totalScore = player.getCards().cards().stream()
                        .filter(card -> !card.getCardNumber().name().equals("A"))
                        .mapToInt(card -> card.getCardNumber().getScore()).sum();

                    List<Card> ACEList = player.getCards().cards().stream()
                        .filter(card -> card.getCardNumber().name().equals("A"))
                        .collect(Collectors.toList());

                    for (Card card : ACEList) {
                        if (totalScore + 11 > 21) {
                            totalScore += 1;
                        } else {
                            totalScore += card.getCardNumber().getScore();
                        }
                    }
                }
            } while (!yesOrNo.equals("n"));
        }

        int dealerTotalScore = dealer.getCards().cards().stream()
            .filter(card -> !card.getCardNumber().name().equals("A"))
            .mapToInt(card -> card.getCardNumber().getScore()).sum();

        List<Card> ACEList = dealer.getCards().cards().stream()
            .filter(card -> card.getCardNumber().name().equals("A"))
            .collect(Collectors.toList());

        for (Card card : ACEList) {
            if (dealerTotalScore + 11 > 21) {
                dealerTotalScore += 1;
            } else {
                dealerTotalScore += card.getCardNumber().getScore();
            }
        }

        if (dealerTotalScore <= 16) {
            dealer.getCards().addCard(CardDeck.pop());
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }

        dealerTotalScore = dealer.getCards().cards().stream()
            .filter(card -> !card.getCardNumber().name().equals("A"))
            .mapToInt(card -> card.getCardNumber().getScore()).sum();

        ACEList = dealer.getCards().cards().stream()
            .filter(card -> card.getCardNumber().name().equals("A"))
            .collect(Collectors.toList());

        for (Card card : ACEList) {
            if (dealerTotalScore + 11 > 21) {
                dealerTotalScore += 1;
            } else {
                dealerTotalScore += card.getCardNumber().getScore();
            }
        }
        OutputView.printResult("딜러", dealer.getCards().cards(), dealerTotalScore);

        List<Integer> playerResults = new ArrayList<>();
        for (Player player : players) {
            int playerTotalScore = player.getCards().cards().stream()
                .filter(card -> !card.getCardNumber().name().equals("A"))
                .mapToInt(card -> card.getCardNumber().getScore()).sum();

            List<Card> PlayerACE = player.getCards().cards().stream()
                .filter(card -> card.getCardNumber().name().equals("A"))
                .collect(Collectors.toList());

            for (Card card : PlayerACE) {
                if (playerTotalScore + 11 > 21) {
                    playerTotalScore += 1;
                } else {
                    playerTotalScore += card.getCardNumber().getScore();
                }
            }
            playerResults.add(playerTotalScore);
            OutputView.printResult(player.getName(), player.getCards().cards(), playerTotalScore);
        }

        int finalDealerTotalScore = dealerTotalScore;
        Long dealerWin = playerResults.stream().filter(
            playerResult -> (finalDealerTotalScore > playerResult)
        ).count();
        Long dealerLose = playerResults.stream().filter(
            playerResult -> (finalDealerTotalScore < playerResult)
        ).count();
        System.out.printf("딜러 : %d승 %d패%n", dealerWin, dealerLose);

        for (int i = 0; i < players.size(); i++) {
            String name = players.get(i).getName();
            int totalScore = playerResults.get(i);

            Long win = playerResults.stream().filter(
                playerResult -> (totalScore > playerResult)
            ).count();

            Long lose = playerResults.stream().filter(
                playerResult -> (totalScore < playerResult)
            ).count();
            System.out.printf("%s : %d승 %d패%n", name, win, lose);
        }
    }
}
