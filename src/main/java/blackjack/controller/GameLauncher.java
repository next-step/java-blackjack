package blackjack.controller;


import blackjack.domain.Card.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameLauncher {

    public void start() {
        OutputView.requestPlayersName();
        String[] playerNames = InputView.readPlayerName();
        OutputView.printGamePlayer(playerNames);
        Players players = new Players(playerNames);
        players.getPlayers().forEach(player -> player.getCards().forEach(card -> System.out.println(card.getDenomination().getName() + card.getSuit().getValue())));
    }
}

