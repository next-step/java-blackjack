package blackjack.model;

import blackjack.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 게임 참가자 이름 입력(","구분)
        InputView inputView = new InputView();
        Ready ready = new Ready();

        String inputName = inputView.inputName();
        List<Gambler> gamblers = ready.createGamblers(inputName);

        Stadium stadium = new Stadium(gamblers);
        stadium.playCardGame();

        // 4. 게임 결과 출력
        // 5. 승패
    }
}
