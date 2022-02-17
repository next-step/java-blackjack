package blackjack.domain.gameplayer;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.List;

public abstract class GamePlayer {

    private static final int BLACK_JACK = 21;

    private final String name;
    private Cards cards;

    public GamePlayer(String name) {
        this.name = name;
        this.cards = new Cards();
    }

    public void receiveCard(final Card card) {
        cards.receiveCard(card);
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return cards.calculateCards();
    }

    public List<Card> getCards() {
        return cards.toList();
    }

    public boolean isContinue() {
        return getScore() <= BLACK_JACK;
    }

    public abstract boolean isLowerThanBound();

    public abstract String getGameResult(final List<GamePlayer> gamePlayers);
}
