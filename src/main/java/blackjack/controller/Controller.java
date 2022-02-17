package blackjack.controller;

import blackjack.domain.Card;
import blackjack.domain.CardAddible;
import blackjack.domain.CardDeck;
import blackjack.domain.Game;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;


public class Controller {


    public void receive(Player player){
        CardAddible cardAddible = player.getCards();
        do{
            String yesOrNo = InputView.inputYesOrNo(player.getName());
            if(yesOrNo.equals("y")) {
                cardAddible.addCard(CardDeck.pop());
                OutputView.printCurrentCardsState(player.getName(), player.getCards());
                cardAddible = cardAddible.judge();
            }
        }while(cardAddible.isEnd());
    }
    public void run() {

        Game game = new Game(InputView.inputPlayers());
        initGame(game);
        game.getPlayers().forEach(this::receive);

//        int dealerTotalScore = dealer.getCards().cards().stream()
//            .filter(card -> !card.getCardNumber().name().equals("A"))
//            .mapToInt(card -> card.getCardNumber().getScore()).sum();
//
//        List<Card> ACEList = dealer.getCards().cards().stream()
//            .filter(card -> card.getCardNumber().name().equals("A"))
//            .collect(Collectors.toList());
//
//        for (Card card : ACEList) {
//            if (dealerTotalScore + 11 > 21) {
//                dealerTotalScore += 1;
//            } else {
//                dealerTotalScore += card.getCardNumber().getScore();
//            }
//        }
        int dealerTotalScore = game.getDealer().getCards().cards().sumScore();
        if(dealerTotalScore <= 16){
            CardAddible cardAddible = game.getDealer().getCards();
            cardAddible.addCard(CardDeck.pop());
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }

//
//        dealerTotalScore = dealer.getCards().cards().stream()
//            .filter(card -> !card.getCardNumber().name().equals("A"))
//            .mapToInt(card -> card.getCardNumber().getScore()).sum();
//
//        ACEList = dealer.getCards().cards().stream()
//            .filter(card -> card.getCardNumber().name().equals("A"))
//            .collect(Collectors.toList());
//
//        for (Card card : ACEList) {
//            if (dealerTotalScore + 11 > 21) {
//                dealerTotalScore += 1;
//            } else {
//                dealerTotalScore += card.getCardNumber().getScore();
//            }
//        }
        OutputView.printResult("딜러", game.getDealer().getCards().cards().getCards(), dealerTotalScore);

//
//        List<Integer> playerResults = new ArrayList<>();
//        for (Player player : players) {
//            int playerTotalScore = player.getCards().cards().stream()
//                .filter(card -> !card.getCardNumber().name().equals("A"))
//                .mapToInt(card -> card.getCardNumber().getScore()).sum();
//
//            List<Card> PlayerACE = player.getCards().cards().stream()
//                .filter(card -> card.getCardNumber().name().equals("A"))
//                .collect(Collectors.toList());
//
//            for (Card card : PlayerACE) {
//                if (playerTotalScore + 11 > 21) {
//                    playerTotalScore += 1;
//                } else {
//                    playerTotalScore += card.getCardNumber().getScore();
//                }
//            }
//            playerResults.add(playerTotalScore);
//            OutputView.printResult(player.getName(), player.getCards().cards(), playerTotalScore);
//        }
//
//        int finalDealerTotalScore = dealerTotalScore;
//        Long dealerWin = playerResults.stream().filter(
//            playerResult -> (finalDealerTotalScore > playerResult)
//        ).count();
//        Long dealerLose = playerResults.stream().filter(
//            playerResult -> (finalDealerTotalScore < playerResult)
//        ).count();
//        System.out.printf("딜러 : %d승 %d패%n", dealerWin, dealerLose);
//
//        for (int i = 0; i < players.size(); i++) {
//            String name = players.get(i).getName();
//            int totalScore = playerResults.get(i);
//
//            Long win = playerResults.stream().filter(
//                playerResult -> (totalScore > playerResult)
//            ).count();
//
//            Long lose = playerResults.stream().filter(
//                playerResult -> (totalScore < playerResult)
//            ).count();
//            System.out.printf("%s : %d승 %d패%n", name, win, lose);
//        }
    }


    private static void initGame(Game game) {
        OutputView.printStartMessage(game);
        OutputView.printDealerCard(game.getDealer());
        OutputView.printPlayerCard(game.getPlayers());
    }
}
