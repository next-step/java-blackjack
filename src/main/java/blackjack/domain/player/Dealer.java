package blackjack.domain.player;

import blackjack.domain.card.Cards;
import blackjack.domain.card.PlayingCard;
import blackjack.domain.state.Hit;
import blackjack.domain.state.State;
import java.util.List;

public class Dealer extends Human {

    private static final String DEALER_NAME = "딜러";
    private int winCount;
    private int loseCount; //TODO: wrapper로 해줘야 함.

    private Cards cards;

    public Dealer() {
        super(DEALER_NAME);
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public Cards getCards() {
        return cards;
    }

    // 카드 뭉치에서 한 장을 꺼내기
    public static PlayingCard popAndGiveCard() {
        PlayingCard playingCard = CardDeck.getPlayingCard();
        return playingCard;
    }

    public void winResult(List<Player> players) {
        players.forEach(player -> resultOnce(player));
    }

    private void resultOnce(Player player) {
        if (player.getIsWin()) {
            loseCount++;
            return;
        }
        winCount++;
    }

    public void addDealerCard() {
        cards.add(popAndGiveCard());
    }

    public void initDealerCard() {
        cards = new Cards();
        cards.add(popAndGiveCard());
        PlayingCard flippedCard = popAndGiveCard();
        flippedCard.flip();
        cards.add(flippedCard);
    }

    public Cards initCard() {
        Cards cards = new Cards();
        cards.add(popAndGiveCard());
        cards.add(popAndGiveCard());
        return cards;
    }
}
