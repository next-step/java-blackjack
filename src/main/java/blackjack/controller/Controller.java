package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.MatchScore;
import blackjack.domain.MatchScoreBoard;
import blackjack.domain.Person;
import blackjack.domain.Player;
import blackjack.domain.PlayersFactory;
import blackjack.dto.NameInfo;
import blackjack.dto.PeopleInfo;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
        output.printPeopleInfo(
            new PeopleInfo(
                players
                    .stream()
                    .map(p -> p.getPersonInfo())
                    .collect(Collectors.toList())
            )
        );

        for (Person player : players) {
            NameInfo name = player.getNameInfo();
            while (player.canDrawCard() && input.requestCard(name)) {
                player.drawCardFromDeck(deck);
                output.printCardInfo(player.getPersonInfo());
            }
        }

        while (dealer.canDrawCard()) {
            dealer.drawCardFromDeck(deck);
            output.printDealerDrawInformation();
        }

        output.printCardInfo(dealer.getPersonInfo());
        output.printPeopleInfo(
            new PeopleInfo(
                players
                    .stream()
                    .map(p -> p.getPersonInfo())
                    .collect(Collectors.toList())
            )
        );

        MatchScoreBoard matchScoreBoard = new MatchScoreBoard(
            players
                .stream()
                .collect(Collectors.toMap(
                    player -> player,
                    player -> player.getMatchScore(dealer)
                ))
        );

        output.printScoreGuideMsg();
        output.printDealerScoreInfo(
            dealer.getNameInfo(),
            matchScoreBoard.getDealerScoreInfo()
        );
        output.printPlayersScoreInfo(
            matchScoreBoard.getPlayersScoreInfo()
        );
    }
}
