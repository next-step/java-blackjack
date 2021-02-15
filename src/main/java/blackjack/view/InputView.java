package blackjack.view;

import blackjack.dto.NameInfo;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    enum Answer {
        YES("y", true),
        NO("n", false);

        private final String input;
        private final boolean status;

        Answer(String input, boolean status) {
            this.input = input;
            this.status = status;
        }

        private static Answer of(final String input) {
            return Arrays
                .stream(Answer.values())
                .filter(answer -> answer.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unexpected input"));
        }

        public String getInput() {
            return input;
        }

        public boolean getStatus() {
            return status;
        }
    }

    private static final String NAMES_PROMPT = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String BET_MONEY_PROPMPT = "\n%s의 배팅 금액은?\n";
    private static final String NAME_DELIMITER = ",";
    private static final String CARD_PROMPT_FMT = "%s는 한장의 카드를 더 받겠습니까?(예는 %s, 아니오는 %s)\n";

    private final Scanner scanner = new Scanner(System.in);

    public Map<String, Integer> inputPlayersItem() {
        System.out.println(NAMES_PROMPT);
        return Arrays
            .stream(scanner.nextLine().split(NAME_DELIMITER))
            .collect(Collectors.toMap(name -> name, this::inputPlayerBetMoney));
    }

    private Integer inputPlayerBetMoney(String name) {
        System.out.format(BET_MONEY_PROPMPT, name);
        Integer betMoney = scanner.nextInt();
        scanner.nextLine();

        return betMoney;
    }

    public Boolean inputResponse(NameInfo nameInfo) {
        System.out.format(
            CARD_PROMPT_FMT,
            nameInfo.getName(),
            Answer.YES.getInput(),
            Answer.NO.getInput()
        );
        return Answer.of(scanner.nextLine()).getStatus();
    }
}
