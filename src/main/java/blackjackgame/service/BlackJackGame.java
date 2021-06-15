package blackjackgame.service;

import blackjackgame.model.player.Players;

public class BlackJackGame {

    private Players players;

    public Players getPlayers(String playersNames) {
        players = new Players(playersNames);
        return players;
    }
}
