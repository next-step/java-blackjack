package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.MatchScore;
import blackjack.domain.Person;
import blackjack.domain.Player;
import blackjack.domain.PlayersFactory;
import blackjack.dto.NameInfo;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView input;
    private final OutputView output;

    public Controller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void playGame() {
        List<Player> players = PlayersFactory.generatePlayers(
            input.requestPlayers()
        );

        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        dealer.drawCardFromDeck(deck);
        dealer.drawCardFromDeck(deck);

        for (Player player : players) {
            player.drawCardFromDeck(deck);
            player.drawCardFromDeck(deck);
        }

        output.printCardInfo(dealer.getPersonInfo());
        for (Person player : players) {
            output.printCardInfo(player.getPersonInfo());
        }

        for (Person player : players) {
            NameInfo name = player.getNameInfo();
            while (player.canDrawCard() && input.requestCard(name).equals("y")) {
                player.drawCardFromDeck(deck);
                output.printCardInfo(player.getPersonInfo());
            }
        }

        while(dealer.canDrawCard()) {
            dealer.drawCardFromDeck(deck);
            output.printDealerDrawInformation();
        }

        output.printCardInfo(dealer.getPersonInfo());
        for (Person player : players) {
            output.printCardInfo(player.getPersonInfo());
        }

        Map<String, List<Integer>> resultMap = new HashMap<>();
        List<Integer> dealerMapEntity = new ArrayList<>(
            List.of(0, 0, 0)
        );

        for (Player player : players) {
            MatchScore result = player.getMatchScore(dealer);
            List<Integer> playerMapEntity = new ArrayList<>(
                List.of(0, 0, 0)
            );

            if (result == MatchScore.WIN) {
                playerMapEntity.set(0, 1);
                dealerMapEntity.set(2, dealerMapEntity.get(2) + 1);
            } else if (result == MatchScore.DRAW) {
                playerMapEntity.set(1, 1);
                dealerMapEntity.set(1, dealerMapEntity.get(1) + 1);
            } else {
                playerMapEntity.set(2, 1);
                dealerMapEntity.set(0, dealerMapEntity.get(0) + 1);
            }
            resultMap.put(player.getNameInfo().getName(), playerMapEntity);
        }
        resultMap.put(dealer.getNameInfo().getName(), dealerMapEntity);

        // TODO : 결과 계산
        output.getFinalResult(resultMap);
    }
}
