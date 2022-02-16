package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER;
    private static final String SPLITTER = ",";
    private static final String MESSAGE_GET_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";

    static {
        SCANNER = new Scanner(System.in);
    }

    private InputView() {
    }

    public static List<String> getNames() {
        System.out.println(MESSAGE_GET_NAMES);

        return Arrays.stream(SCANNER.nextLine().split(SPLITTER))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
