package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PARTICIPANTS_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String YES_OR_NO_MESSAGE = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputParticipants() {
        String participants = getInputValueWithMessage(PARTICIPANTS_MESSAGE);
        return Arrays.stream(participants.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public Boolean inputYesOrNo(String name) {
        String yesOrNo = getInputValueWithMessage(name + YES_OR_NO_MESSAGE);
        return Objects.equals(yesOrNo, "y");
    }

    public String getInputValueWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine().trim();
    }
}
