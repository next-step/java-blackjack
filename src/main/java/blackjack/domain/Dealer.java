package blackjack.domain;

public class Dealer extends Participant {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void drawCardMultiple(Deck deck, int number) {
        cards.addCards(deck.drawMultiple(number));
    }

    @Override
    public void drawCardContinue(Deck deck) {
        if (cards.sumCardScore() > 17) {
            return;
        }
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        cards.addCards(deck.drawMultiple(1));
    }

    @Override
    public String scoreResult() {
        return name + " : " + winScore + "승" + loseScore + "패";
    }
}
