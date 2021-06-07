package blackjack;

import java.util.List;

public class Stadium {
    List<Gambler> gamblers;

    public Stadium(List<Gambler> gamblers) {
        this.gamblers = gamblers;
    }

    // 카드 게임
    public List<Gambler> playCardGame() {
        for (Gambler gambler : gamblers) {
            initialSetting(gambler);
            drawNewCard(gambler);
        }
        return gamblers;
    }

    private void initialSetting(Gambler gambler) {
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
