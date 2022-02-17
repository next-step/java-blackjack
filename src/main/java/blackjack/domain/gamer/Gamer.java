package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.card.Denomination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Gamer {
    private static final String ERROR_NOT_ENOUGH_CARD = "덱에 남아있는 카드가 없습니다.";
    private static final int TEN = 10;
    private static final int THRESHOLD = 21;
    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cardsBundle = Cards.getCardList();
    private List<Card> cards = new ArrayList<>();
    private String name;

    public Gamer(String name) {
        this.name = name;
        this.cards = initSetting();
    }

    public Gamer(String name, List<Card> cards) {
        this.name = name;
        for(Card card : cards) {
            this.cards.add(card);
        }
        for(Card card : cards) {
            cardsBundle.remove(card);
        }
    }

    private List<Card> initSetting() {
        Collections.shuffle(cardsBundle);
        this.cards = cardsBundle.stream()
            .limit(INIT_CARD_COUNT)
            .collect(Collectors.toList());
        removeCard();
        removeCard();
        return this.cards;
    }

    public int calcScore(Gamer player) {
        int score = player.cards.stream()
            .map(Card::getDenomination)
            .mapToInt(Denomination::getValue)
            .sum();

        long aceCount = player.cards.stream().filter(card -> card.getDenomination().isAce())
            .count();
        for (int i = 0; i < aceCount; i++) {
            score = adjustScore(score);
        }
        return score;
    }

    private int adjustScore(int score) {
        if (score + TEN <= THRESHOLD) {
            score += TEN;
        }
        return score;
    }

    public List<Card> addCard(List<Card> cards) {
        cards.add(cardsBundle.get(0));
        removeCard();
        return cards;
    }

    private void removeCard() {
        try {
            cardsBundle.remove(0);
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(ERROR_NOT_ENOUGH_CARD);
        }
    }

    public boolean isBlackJack(Gamer player) {
        return calcScore(player) == THRESHOLD;
    }

    public boolean isBust(Gamer player) {
        return calcScore(player) > THRESHOLD;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
}
