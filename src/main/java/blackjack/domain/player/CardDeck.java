package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.state.PlayingCard;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardDeck {//카드 덱을 저장하며 카드를 딜러에 의해 하나씩 pop되는 녀석.
    static List<PlayingCard> cardDeck;
    private static int index = 0;
    private static final int LAST_INDEX = 52; // -> constans 클래스 파도 되지 않을까......

    static {
        cardDeck = Arrays
            .stream(Denomination.values())
            .flatMap(
                d -> Arrays
                    .stream(Suit.values())
                    .map(s -> new PlayingCard(d, s))
            )
            .collect(Collectors.toList());
        shuffle();
    }

    public static void shuffle() {
        Collections.shuffle(cardDeck);
    }

    public static PlayingCard getPlayingCard() {
        if(index >= LAST_INDEX) {
            throw new IllegalStateException("카드를 전부 배분했습니다.");
        }
        return cardDeck.get(index++);
    }
}
