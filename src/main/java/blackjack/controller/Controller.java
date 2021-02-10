package blackjack.controller;

import blackjack.domain.Deck;
import blackjack.domain.Person;
import blackjack.domain.PlayersFactory;
import blackjack.domain.Result;
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
        List<Person> players = PlayersFactory.generatePlayers(
            input.requestPlayers()
        );

        Person dealer = Person.createDealer();
        Deck deck = new Deck();

        dealer.drawCard(deck);
        dealer.drawCard(deck);

        for (Person player : players) {
            player.drawCard(deck);
            player.drawCard(deck);
        }

        output.printCardInfo(dealer.getPersonInfo());
        for (Person player : players) {
            output.printCardInfo(player.getPersonInfo());
        }

        for (Person player : players) {
            NameInfo name = player.getNameInfo();
            while (player.canDrawCard() && input.requestCard(name).equals("y")) {
                player.drawCard(deck);
                output.printCardInfo(player.getPersonInfo());
            }
        }

        while(dealer.canDrawCard()) {
            dealer.drawCard(deck);
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

        for (Person player : players) {
            Result result = player.getResult(dealer);
            List<Integer> playerMapEntity = new ArrayList<>(
                List.of(0, 0, 0)
            );

            if (result == Result.WIN) {
                playerMapEntity.set(0, 1);
                dealerMapEntity.set(2, dealerMapEntity.get(2) + 1);
            } else if (result == Result.DRAW) {
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
