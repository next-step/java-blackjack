package blackjack.controller;

import blackjack.domain.Deck;
import blackjack.domain.Person;
import blackjack.domain.Players;
import blackjack.domain.PlayersFactory;
import blackjack.dto.NameInfo;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

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
            output.printCardInfo(dealer.getPersonInfo());
        }

        output.printCardInfo(dealer.getPersonInfo());
        for (Person player : players) {
            output.printCardInfo(player.getPersonInfo());
        }

        // TODO : 결과 계산
    }
}
