package blackJack.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameCard {

    private final List<Card> gameCard;

    private GameCard() {
        this.gameCard = new ArrayList<>();
        generateGameCard();
    }

    public static GameCard create() {
        return new GameCard();
    }

    public List<Card> getGameCard() {
        return gameCard;
    }

    public List<Card> drawCard(int count) {
        final List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(gameCard.remove(0));
        }
        return cards;
    }

    public Card drawCard() {
        return gameCard.remove(0);
    }

    private void generateGameCard() {
        Suit.getSuits().forEach(
            type -> TrumpNumber.trumpNumbers().forEach(
                number -> gameCard.add(Card.of(type, number))
            )
        );
    }

    public void shuffle() {
        Collections.shuffle(gameCard);
    }
}
