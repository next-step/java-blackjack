package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {

    private Players players;
    private CardDeck cardDeck = new CardDeck();

    public Players getPlayer(String gamerName) {
        players =new Players(gamerName);
        return players;
    }

    public void startDraw() {
        players.startDraw(cardDeck);
    }

    public void addDraw() {
        players.addDraw(cardDeck);
    }

    public void setZero() {
        players.setZero();

    }

    public void aceCheck() {
        players.aceCheck();
    }

    public void resultGamer() {
        players.resultGamer();
    }

    public void outputResult() {
        players.outputResult();
    }
}
