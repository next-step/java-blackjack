package blackJack.domain;

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

    public GameUser getGameUser() {
        return gameUser;
    }

    public GameCard getGameCard() {
        return gameCard;
    }

    public List<Player> getGamePlayers() {
        return gameUser.getPlayers();
    }

    public Dealer getGameDealer() {
        return gameUser.getDealer();
    }

    public Card drawGameCard() {
        return gameCard.drawCard();
    }
}
