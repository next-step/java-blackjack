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

    }

    public void initCardDraw() {
        gameUser.getPlayers()
            .forEach(player -> player.appendToDeck(gameCard.drawCard(INITIAL_DRAW_CARD_COUNT)));
        // Dealer의 score가 16이하일떄 한 장 더 받기
    }


}
