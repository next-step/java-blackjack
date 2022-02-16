package blackjack;

public class Player extends Person {

    public Player(String userName, Cards cards) {
        super(userName,cards);
    }

    public int getTotalScore(){
        return cards.totalScore();
    }

    @Override
    public boolean canDrawCard() {
        return cards.isNearTwentyOne();
    }

    public Score compareScore(Dealer dealer) {
        return Score.judge(cards, dealer.cards);
    }
}
