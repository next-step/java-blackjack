package blackjack.domain.Card;

import java.util.List;

public class Player extends Gamer {

    private List<Card> cards;
    private final String name;

    public Player(String name) {
        this.name = name;
        cards = initSetting();
    }

    public int getPlayerCardSum(Player player) {
        int cardSum = player.getCards().stream()
            .map(Card::getDenomination)
            .mapToInt(Denomination::getValue)
            .sum();

        if (player.getCards().contains(new Card(Denomination.ACE, Suit.CLUBS)) ||
            player.getCards().contains(new Card(Denomination.ACE, Suit.HEARTS)) ||
            player.getCards().contains(new Card(Denomination.ACE, Suit.DIAMONDS)) ||
            player.getCards().contains(new Card(Denomination.ACE, Suit.SPADES))) {
            if (cardSum <= 11) {
                return cardSum + 10;
            }
        }
        return cardSum;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return name;
    }
}
