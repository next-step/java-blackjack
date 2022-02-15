package blackjack.domain.Card;

import java.util.List;

public class Player extends Gamer{

    private static final int INIT_CARD_COUNT = 2;

    private List<Card> cards;
    private final String name;

    public Player(String name) {
        this.name = name;
        cards = initSetting();
    }

    public int getPlayerCardSum(Player player) {
       return player.getCards().stream().map(Card::getDenomination)
            .mapToInt(Denomination::getValue).sum();
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return name;
    }
}
