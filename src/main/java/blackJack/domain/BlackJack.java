package blackJack.domain;

import blackJack.view.InputView;
import blackJack.view.OutputView;
import java.util.List;

public class BlackJack {

    private static final int INITIAL_DRAW_CARD_COUNT = 2;

    private final GameUser gameUser;
    private final GameCard gameCard;

    private BlackJack(List<String> userNames) {
        this.gameUser = GameUser.from(userNames);
        this.gameCard = GameCard.create();
        cardShuffle();
    }

    public static BlackJack from(List<String> userNames) {
        return new BlackJack(userNames);
    }

    public GameUser getGameUser() {
        return gameUser;
    }

    public List<Player> getPlayers() {
        return gameUser.getPlayers();
    }

    public List<Card> getGameCard() {
        return gameCard.getGameCard();
    }

    private void cardShuffle() {
        gameCard.shuffle();
    }

    public void initCardDraw() {
        initDealerDraw();
        initPlayerDraw();
    }

    private void initDealerDraw() {
        gameUser.getDealer().appendToDeck(gameCard.drawCard(INITIAL_DRAW_CARD_COUNT));
    }

    private void initPlayerDraw() {
        gameUser.getPlayers()
            .forEach(player -> player.appendToDeck(gameCard.drawCard(INITIAL_DRAW_CARD_COUNT)));
    }

    public void dealerPhase() {
        if (gameUser.getDealer().isCardDraw()) {
            gameUser.getDealer().additionalCardDraw(gameCard.drawCard());
            OutputView.printDealerAdditionalCardDraw();
        }
    }

    public void playerPhase() {
        for (Player player : gameUser.getPlayers()) {
            useTurn(player);
        }
    }

    private void useTurn(Player player) {
        while (player.isCardDraw()) {
            OutputView.printRequestAdditionalCardDrawFormat(player);
            if (InputView.readYN()) {
                player.appendToDeck(gameCard.drawCard());
                OutputView.printPlayerStatus(player);
                continue;
            }
            OutputView.printPlayerStatus(player);
            break;
        }
    }
}
