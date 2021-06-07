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

            drawNewCard(gambler);
            System.out.println(gambler.getName()+" 결과 : " + gambler.getCard());
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
