package blackjack.domain.user;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int BLACK_JACK_SCORE = 21;

    protected final List<Card> cards;
    private final String name;

    public Player(String name) {
        validateName(name);
        this.cards = new ArrayList<>();
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 이름의 입력 값입니다.");
        }
    }

    public void drawCard(Card card) {
        this.cards.add(card);
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
        return cards.stream()
            .mapToInt(Card::value)
            .sum();
    }

    public boolean isDrawable() {
        return !isBurst();
    }

    public boolean isBurst() {
        return score() > BLACK_JACK_SCORE;
    }

    public boolean isBlackJack() {
        return score() == BLACK_JACK_SCORE;
    }
}
