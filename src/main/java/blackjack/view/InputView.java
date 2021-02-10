package blackjack.view;

import blackjack.dto.NameInfo;

import java.util.Scanner;

public class InputView {
    private static final String NAMES_PROMPT = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String NAME_DELIMITER = ",";

    private static final String CARD_PROMPT_FMT = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";

    private final Scanner scanner = new Scanner(System.in);

    public String[] requestPlayers() {
        System.out.println(NAMES_PROMPT);
        return scanner.nextLine().split(NAME_DELIMITER);
    }

    public String requestCard(NameInfo nameInfo){
        System.out.format(CARD_PROMPT_FMT, nameInfo.getName());
        return scanner.nextLine();
    }
}
