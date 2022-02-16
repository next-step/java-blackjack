package blackjack.controller;

import blackjack.domain.CardDeck;
import blackjack.domain.Players;
import blackjack.view.InputView;
import java.util.List;

public class BlackJackController {

    public BlackJackController() {
    }

    public void run() {
        List<String> playerNames = InputView.inputPlayerNames();
        CardDeck cardDeck = new CardDeck();
        Players players = new Players(playerNames);





    }
}
