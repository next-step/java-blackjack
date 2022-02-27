package blackjack.view;

import blackjack.dto.NameInfo;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER;
    private static final String SPLITTER = ",";
    private static final String MESSAGE_GET_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String MESSAGE_UNEXPECTABLE_INPUT = "의도치 않은 입력이 들어왔습니다.";
    private static final String MESSAGE_CHOICE_DECISION = "%s는 한장의 카드를 더 받겠습니까?(예는 %s, 아니오는 %s)\n";
    private static final String ANSWER_YES = "y";
    private static final String ANSWER_NO = "n";

    static {
        SCANNER = new Scanner(System.in);
    }

    enum Answer {
        YES(ANSWER_YES, true),
        NO(ANSWER_NO, false);

        private final String choice;

        private final boolean decision;

        Answer(final String choice, final boolean decision) {
            this.choice = choice;
            this.decision = decision;
        }

        public static Answer of(final String choice) {
            return Arrays.stream(values())
                .filter(answer -> answer.choice.equals(choice))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(MESSAGE_UNEXPECTABLE_INPUT));
        }

        public boolean getDecision() {
            return decision;
        }

    }

    private InputView() {
    }

    public static boolean drawChoice(final NameInfo activePlayerNameInfo) {
        System.out.format(MESSAGE_CHOICE_DECISION, activePlayerNameInfo.getPersonName(),
            Answer.YES.choice, Answer.NO.choice);
        return Answer.of(SCANNER.nextLine()).getDecision();
    }

    public static List<String> getNames() {
        System.out.println(MESSAGE_GET_NAMES);

        return Arrays.stream(SCANNER.nextLine().split(SPLITTER))
            .map(String::trim)
            .collect(Collectors.toList());
    }

}
