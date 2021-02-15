package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.PlayingCard;
import java.util.List;

public class Dealer extends Human {
    private static final String DEALER_NAME = "딜러";
    private Cards cards;

    public int getWinCount() {
        return winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    int winCount, lossCount; //TODO: wrapper로 해줘야 함.

    public Dealer() {
        super(DEALER_NAME);
    }

    // 카드 뭉치에서 한 장을 꺼내
    // pop : 카드 뭉치에서 한 장을 뽑아 플레이어/딜러 에게 주는 것.
    public static PlayingCard popAndGiveCard() {
        PlayingCard playingCard = CardDeck.getPlayingCard();
        // 딜러에게는 첫 번째만 flipCard를 실행.
        playingCard.flipCard();
        return playingCard;
    }

    public void winResult(List<Player> players) {
        // 얘는 humans를 받아 반복
        for (Player player : players) {
            resultOnce(player);
        }
    }

    private void resultOnce(Player player) {
        if (!player.getIsWin()) {
            winCount++;
            return;
        }
        lossCount++;
    }

    public Cards initCard() {
        Cards cards = new Cards();
        cards.add(popAndGiveCard());
        cards.add(popAndGiveCard());
        return cards;
    }

    public void initDealerCards() {
        cards = initCard();
    }
    public Cards getCards() {
        return cards;
    }

    public void drawMoreCard() {
        cards.add(popAndGiveCard());
    }
}
