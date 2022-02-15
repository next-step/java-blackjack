package blackjack.domain.Card;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Gamer{

    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cards;
    private final String name;

    public Player(String name) {
        this.name = name;
        cards = initSetting();
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return name;
    }
}
