package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.GamePlayers;
import blackjack.domain.GameResult;
import blackjack.domain.Players;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    private static String DELIMETER = ", ";
    private static String COLON = " : ";
    private static String INIT_DISPENSER_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    private static String DEALER_DRAW_CARD_MESSAGE = "는 16이하라 한장의 카드를 더 받았습니다.";
    private static String PLAYER_TOTAL_SCORE_MESSAGE = " - 결과 : ";
    private static String GAME_RESULT_MESSAGE = "## 최종 승패";

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

    public void playerCardsPrint(GamePlayers gamePlayers) {
        System.out.println(playersOwnCards(gamePlayers));
    }

    public String playersOwnCards(GamePlayers gamePlayers) {
        return gamePlayers.getPlayerName() + COLON +
            gamePlayers.myOwnCards().getOwnCards().stream()
                .flatMap(card -> Stream.of(card.getCardName() + card.getCardType())).collect(
                    Collectors.toList());
    }

    public void dealerDrawCardPrint(GamePlayers gamePlayers) {
        String result = gamePlayers.getPlayerName() + DEALER_DRAW_CARD_MESSAGE;

        System.out.println(result + "\n");
    }

    public void playersGetTotalScore(GamePlayers gamePlayers) {
        String result = playersOwnCards(gamePlayers) + PLAYER_TOTAL_SCORE_MESSAGE
            + gamePlayers.myOwnCards().getTotalScore();

        System.out.println(result);
    }

    public void gameResultMessagePrint() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void dealerGameResultPrint(GameResult gameResult) {
        System.out.println(dealer.getPlayerName() + COLON + gameResult.getDealerGameResult());
    }

    public void playerGameResultPrint(GameResult gameResult) {
        gameResult.getplayerGameResult().forEach(System.out::println);
    }
}
