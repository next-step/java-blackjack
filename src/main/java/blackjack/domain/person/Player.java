package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Person {

    private static final int PLAYER_MAXIMUM_SUM = 21;
    private final String name;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards.addAll(cards);
        this.sum = getSumOfCards(); //TODO
    }

    public static List<Player> createPlayers(List<String> playerNames, Dealer dealer) {
        return playerNames.stream()
            .map(name -> new Player(name, dealer.getInitialPickedCards()))
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public boolean canHit() {
        return sum <= PLAYER_MAXIMUM_SUM;
    }

    public int getSumOfCards() {
        return cards.stream().mapToInt(card -> card.getDenomination().getValue()).sum();
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
        if (card.getDenomination().equals(Denomination.ACE) && sum < 10) {
            sum += 11;
            return;
        }
        sum += card.getDenomination().getValue();
    }
}
