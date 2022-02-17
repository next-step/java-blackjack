package blackJack.domain;

public class Player extends User {

    private static final int ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD = 21;

    private Player(String userName) {
        super(Deck.create(), UserName.from(userName));
    }

    public static Player of(String userName) {
        return new Player(userName);
    }

    public boolean isCardDraw() {
        return deck.getScore() <= ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD;
    }
}
