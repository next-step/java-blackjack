package blackjackgame.model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCard {
    private static List<Card> playingCard = new ArrayList<>();

    static {
        for (Suit suit : Suit.values()) {
            for (Denomination denomination : Denomination.values()) {
                playingCard.add(new Card(suit, denomination));
            }
        }
        Collections.shuffle(playingCard);
    }

    public List<Card> getPlayingCard() {
        return playingCard;
    }

    Card drawCard() {
        Card card = playingCard.get(0);
        playingCard.remove(0);
        return card;
    }

}
