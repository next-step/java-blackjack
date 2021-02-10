package blackjack.view;

import blackjack.model.Players;

import java.util.Scanner;

public class InputView {
    public Players inputGamerNames(){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        return new Players(scanner.nextLine());
    }
}
