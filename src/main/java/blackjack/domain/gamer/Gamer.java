package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.card.Denomination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Gamer {

    private static final int TEN = 10;
    private static final int THRESHOLD = 21;
    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cardsAll = new ArrayList<>();
    private List<Card> cards;
    private final String name;

    public Gamer(String name) {
        this.name = name;
        this.cards = initSetting();
    }

    private List<Card> initSetting() {
        cardsAll = Cards.getCardList();
        Collections.shuffle(cardsAll);
        this.cards = cardsAll.stream()
            .limit(INIT_CARD_COUNT)
            .collect(Collectors.toList());
        cardsAll.remove(0);
        cardsAll.remove(0);
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
        cards.add(cardsAll.get(0));
        cardsAll.remove(0);
        return cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
}
