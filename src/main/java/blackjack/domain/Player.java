package blackjack.domain;

import blackjack.view.InputView;

public class Player extends Participant {

    public Player(String name) {
        super(name);
    }

    @Override
    public void drawCardMultiple(Deck deck, int number) {
        cards.addCards(deck.drawMultiple(number));
    }

    @Override
    public void drawCardContinue(Deck deck) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        if (InputView.isContinue()) {
            cards.addCards(deck.drawMultiple(1));
            System.out.println(holdingInfo());
            drawCardContinue(deck);
        }
    }

    @Override
    public String scoreResult() {
        if (winScore > 0) {
            return name + " : " + "승";
        }
        return name + " : " + "패";
    }
}
