package blackjackgame.controller;

import blackjackgame.model.player.Players;
import blackjackgame.service.BlackJackGame;
import blackjackgame.view.InputView;

public class BlackJackMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        BlackJackGame blackJackGame = new BlackJackGame();

        String playersNames = inputView.inputPlayersNames();
        Players players = blackJackGame.getPlayers(playersNames);
        players.getPlayers().stream().map(player -> player.getName()).forEach(System.out::println);
        players.getPlayers().stream().map(player -> player.getName()).forEach(System.out::println);
    }
}
