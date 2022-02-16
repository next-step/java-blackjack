package blackjack;

import blackjack.domain.card.Hands;
import blackjack.domain.game.Game;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.util.Parser;
import blackjack.view.InputView;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackApplication {

    public static void main(String[] args) {
        Game game = new Game();

        List<String> players = Parser.parse(InputView.inputPlayers());
        List<Participant> participants = players.stream()
            .map(name -> new Player(name, new Hands(game.dealCards())))
            .collect(Collectors.toList());

        participants.add(new Dealer(new Hands(game.dealCards())));
    }
}
