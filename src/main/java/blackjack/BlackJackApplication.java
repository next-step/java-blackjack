package blackjack;

import blackjack.domain.card.Deck;
import blackjack.domain.card.Hands;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.util.Parser;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackApplication {

    public static void main(String[] args) {
        final Deck deck = new Deck();

        final List<String> playerNames = Parser.parse(InputView.inputPlayers());
        final Participant dealer = new Dealer(new Hands(deck.dealInitCards()));
        final List<Participant> players = playerNames.stream()
            .map(name -> new Player(name, new Hands(deck.dealInitCards())))
            .collect(Collectors.toList());

        participants.add(new Dealer(new Hands(game.dealCards())));

        OutputView.printInitProgress(participants);
    }
}
