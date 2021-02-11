package blackjack.view;

import blackjack.controller.AnswerRunnable;
import blackjack.model.Players;

import java.util.Scanner;

public class InputView {
    public Players inputGamerNames(){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        return new Players(scanner.nextLine());
    }

    public boolean isPopCard(final String name){
        final Scanner scanner = new Scanner(System.in);
        final String answerText = String.format("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", name);
        System.out.println(answerText);

        return scanner.nextBoolean();
    }
}