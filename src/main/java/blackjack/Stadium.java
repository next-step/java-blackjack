package blackjack;

import java.util.List;

public class Stadium {
    List<Gambler> gamblers;

    public Stadium(List<Gambler> gamblers) {
        this.gamblers = gamblers;
    }

    // 카드 게임
    public void playCardGame() {
        for (Gambler gambler : gamblers) {
            initialSetting(gambler);
            System.out.print(gambler.getName()+" 첫번째 결과 : ");
            for(Card card : gambler.getCards()) {
                System.out.print(card.getDenomination() + " " + card.getSuit() + " ");
            }
            System.out.println();

            drawNewCard(gambler);
            System.out.print(gambler.getName()+" 두번째 결과 : ");
            for(Card card : gambler.getCards()) {
                System.out.print(card.getDenomination() + " " + card.getSuit() + " ");
            }
            System.out.println();
        }
    }

    private void initialSetting(Gambler gambler){
        for (int i = 0; i < 2; i++) {
            gambler.drawCard();
        }
    }

    private void drawNewCard(Gambler gambler) {
        if (gambler.selectChoice(gambler.getName())) {
            gambler.drawCard();
        }
    }
}
