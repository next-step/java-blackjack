package blackjack.model;

import java.util.Scanner;

public class Input {
    public String inputName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner name = new Scanner(System.in);
        return name.nextLine();
    }
}
