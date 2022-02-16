package blackJack.domain;

import blackJack.view.InputView;
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

    public List<Player> getPlayers() {
        return gameUser.getPlayers();
    }

    public List<Card> getGameCard() {
        return gameCard.getGameCard();
    }

    private void cardShuffle() {
        gameCard.shuffle();
    }

    public void run() {
        initCardDraw();
        dealerPhase();
        playerPhase();
    }

    private void initCardDraw() {
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

    private void dealerPhase() {
        if (gameUser.getDealer().isCardDraw()) {
            gameUser.getDealer().additionalCardDraw(gameCard.drawCard());
        }
    }

    private void playerPhase() {
        for (Player player : gameUser.getPlayers()) {
            useTurn(player);
        }
    }

    private void useTurn(Player player) {
        while (player.isCardDraw()) {
            if (InputView.readYN(player.getName())) {
                player.appendToDeck(gameCard.drawCard());
            }
        }
        player.getDeck().forEach(card -> {
            System.out.println(card.getCardNumber() + card.getCardType());
        });
        System.out.println("--------------------");
    }
}
