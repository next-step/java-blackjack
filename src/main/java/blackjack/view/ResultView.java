package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.GamePlayers;
import blackjack.domain.Players;
import java.util.stream.Collectors;

public class ResultView {

    private static String DELIMETER = ", ";
    private static String INIT_DISPENSER_MESSAGE = "에게 2장의 카드를 나누었습니다.";

    private final Dealer dealer;
    private final Players players;

    public ResultView(Dealer dealer, Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public void inputPlayersPrint() {
        String resultPlayers = dealer.getPlayerName() + DELIMETER + players.getPlayers().stream()
            .map(GamePlayers::getPlayerName).collect(Collectors.joining(DELIMETER))
            + INIT_DISPENSER_MESSAGE;

        System.out.println(resultPlayers);
    }

}
