package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    protected List<Card> cardList;
    private Score score;

    public Cards() {
        cardList = new ArrayList<>();
        score = new Score(0);
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public Score getScore() {
        calculateScore(0, new Score(0));
        return score;
    }

    private void calculateScore(int index, Score nowScore) {
        if (index == cardList.size()){
            if (nowScore.isBigger(score) && nowScore.isSmaller(new Score(22))) {
                score = nowScore;
            }
            return;
        }
        Card nowCard = cardList.get(index);
        if (nowCard.getDenomination().isAce()) {
            calculateScore(index+1, nowScore.add(1));
            calculateScore(index+1, nowScore.add(11));
        }
        else {
            calculateScore(index+1, nowScore.add(nowCard.getDenomination().getScore()));
        }
    }


}
