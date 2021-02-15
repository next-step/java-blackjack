package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardBunch {
    private static final int BLACK_JACK_SCORE = 21;
    private static final int BLACK_JACK_CARD_CNT = 2;

    private static final int CONVERTIBLE_ACE_LIMIT_SCORE = 11;
    private static final int CONVERTED_ACE_ADDITION_SCORE = 10;
    private static final String NOT_FIRST_CARD_EXIST_ERR_MSG = "첫번째 카드가 존재하지 않습니다.";

    private final List<Card> cardBunch;

    public CardBunch() {
        this.cardBunch = new ArrayList<>();
    }

    public CardBunch(List<Integer> score, Suit suit) {
        cardBunch = score
            .stream()
            .map(n -> new Card(Denomination.of(n), suit))
            .collect(Collectors.toList());
    }

    public void addCard(Card card) {
        cardBunch.add(card);
    }

    public boolean isBlackJack() {
        return cardBunch.size() == BLACK_JACK_CARD_CNT && isBlackJackScore();
    }

    public boolean isBlackJackScore() {
        return calcScore() == BLACK_JACK_SCORE;
    }

    public boolean isBust() {
        return calcScore() > BLACK_JACK_SCORE;
    }

    public int calcScore() {
        int score = cardBunch
            .stream()
            .mapToInt(Card::getScore)
            .sum();

        if (hasAce() && score <= CONVERTIBLE_ACE_LIMIT_SCORE) {
            return score + CONVERTED_ACE_ADDITION_SCORE;
        }
        return score;
    }

    private boolean hasAce() {
        return cardBunch.stream().anyMatch(Card::isAce);
    }

    public List<String> getFirstCardName() {
        if (cardBunch.size() < 1) {
            throw new RuntimeException(NOT_FIRST_CARD_EXIST_ERR_MSG);
        }

        return List.of(
            cardBunch.get(0).getCardName()
        );
    }

    public List<String> getCardsName() {
        return cardBunch
            .stream()
            .map(Card::getCardName)
            .collect(Collectors.toList());
    }
}
