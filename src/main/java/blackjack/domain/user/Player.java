package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardBundle;
import java.util.List;

public class Player {

    private static final int BLACK_JACK_SCORE = 21;

    protected final CardBundle cardBundle;
    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
        this.cardBundle = CardBundle.emptyBundle();
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 이름의 입력 값입니다.");
        }
    }

    public void drawCard(Card card) {
        this.cardBundle.addCard(card);
    }

    public String name() {
        return name;
    }

    public boolean isPlayer() {
        return true;
    }

    public boolean isDealer() {
        return false;
    }

    public int score() {
        return cardBundle.calculateScore();
    }

    public boolean isDrawable() {
        return !isBurst() && !isBlackJack();
    }

    public boolean isBurst() {
        return score() > BLACK_JACK_SCORE;
    }

    public boolean isBlackJack() {
        return score() == BLACK_JACK_SCORE;
    }

    public List<Card> getCardBundle() {
        return cardBundle.getCards();
    }
}
