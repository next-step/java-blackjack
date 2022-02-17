package blackjack;

import blackjack.domain.card.Deck;
import blackjack.domain.card.Hands;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.util.Parser;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackJackApplication {

    public static void main(String[] args) {
        final Deck deck = new Deck();

        final List<String> playerNames = Parser.parse(InputView.inputPlayers());
        final Participant dealer = new Dealer(new Hands(deck.dealInitCards()));
        final List<Participant> players = playerNames.stream()
            .map(name -> new Player(name, new Hands(deck.dealInitCards())))
            .collect(Collectors.toList());

        OutputView.printInitProgress(combine(dealer, players));

        drawCardsIfWant(deck, players);
        drawCardIfCan(deck, dealer);

    }

    private static void drawCardsIfWant(final Deck deck, final List<Participant> players) {
        players.forEach(player -> additionalDraw(deck, player));
    }

    private static void additionalDraw(final Deck deck, final Participant player) {
        while (player.canDraw() && isAgree(player)) {
            player.addCard(deck.draw());
            OutputView.printParticipantsStatus(Collections.singletonList(player));
        }
    }

    private static boolean isAgree(final Participant player) {
        return InputView.inputDrawFlag(player.getName()).equalsIgnoreCase("y");
    }

    private static void drawCardIfCan(final Deck deck, final Participant dealer) {
        if (dealer.canDraw()) {
            dealer.addCard(deck.draw());
            OutputView.printDealerDraw();
        }
    }

    private static List<Participant> combine(final Participant dealer, final List<Participant> participants) {
        return Collections.unmodifiableList(
            Stream.concat(Stream.of(dealer), participants.stream())
                .collect(Collectors.toList()));
    }
}
