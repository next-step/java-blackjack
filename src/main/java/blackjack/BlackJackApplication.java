package blackjack;

import blackjack.domain.judge.Judge;
import blackjack.domain.card.Deck;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.util.PlayerNameParser;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackJackApplication {

    public static void main(String[] args) {
        final Deck deck = new Deck();

        final List<String> playerNames = PlayerNameParser.parse(InputView.inputPlayerNames());
        final Participant dealer = new Dealer(deck.dealCards());
        final List<Participant> players = playerNames.stream()
            .map(name -> new Player(name, deck.dealCards()))
            .collect(Collectors.toList());

        OutputView.printStartStatus(combine(dealer, players));

        drawCardsIfWant(deck, players);
        drawCardIfCan(deck, dealer);

        final Judge judge = new Judge();
        OutputView.printGameResult(combine(dealer, players), judge.getWinOrLose(dealer, players));
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
            OutputView.printDealerDrawMessage();
        }
    }

    private static List<Participant> combine(final Participant dealer, final List<Participant> participants) {
        return Collections.unmodifiableList(
            Stream.concat(Stream.of(dealer), participants.stream())
                .collect(Collectors.toList()));
    }
}
