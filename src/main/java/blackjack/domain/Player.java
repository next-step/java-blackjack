package blackjack.domain;

import blackjack.dto.CardInfo;

public class Player extends Person {

    public Player(String userName, Cards cards) {
        super(userName,cards);
    }

    public int getTotalScore(){
        return cards.totalScore();
    }

    @Override
    public boolean canDrawCard() {
        return !cards.blackjack() && !cards.isBust();
    }

    @Override
    public CardInfo openCards() {
        return new CardInfo(userName,cards.openCardAll());
    }

    public Score compareScore(Dealer dealer) {
        return Score.judge(cards, dealer.cards);
    }
}
