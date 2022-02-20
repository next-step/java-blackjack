package blackjack.ui;

import blackjack.domain.Participant;
import blackjack.domain.Players;
import java.util.Arrays;
import java.util.Scanner;

public class BlackjackInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static boolean inputPlayerDraw(Participant participant){
        System.out.println(participant.getName() + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
        String input = SCANNER.next();
        return input.equals("y");
    }

    public static Players inputPlayerName(){
        System.out.println("게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)");
        String input = SCANNER.next();
        return Players.from(Arrays.asList(input.split(",")));
    }
}
