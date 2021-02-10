package blackjack.domain;

public class Player extends Person {
    public Player(String name) {
        super(name);
    }

    public Player(String name, CardBunch cardBunch) {
        super(name, cardBunch);
    }

    @Override
    public boolean canDrawCard() {
        return !cardBunch.isBlackJack() && !cardBunch.isBust();
    }

    public Result getResult(Dealer dealer) {
        return Result.calcResult(
            this.cardBunch,
            dealer.cardBunch
        );
    }
}
