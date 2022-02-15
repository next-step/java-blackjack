package blackJack.domain;

import static blackJack.domain.CardNumber.CARD_NUMBER_LIST;
import static blackJack.domain.CardType.CARD_TYPE_LIST;

import java.util.ArrayList;
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

    private void generateGameCard() {
        CARD_TYPE_LIST.forEach(type -> {
            CARD_NUMBER_LIST.forEach(number -> {
                gameCard.add(Card.of(type, number));
            });
        });
    }
}
