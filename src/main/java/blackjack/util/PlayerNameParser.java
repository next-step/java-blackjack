package blackjack.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class PlayerNameParser {

    private static final String NAME_SPLIT_REGEX = ",";
    private static final String EMPTY_NAME_EXCEPTION_MESSAGE = "[ERROR] 플레이어의 이름을 빈 값으로 지정할 수 없습니다.";

    public static List<String> parse(final String input) {
        checkNameIsEmpty(() -> input.endsWith(NAME_SPLIT_REGEX));

        return Arrays.stream(input.split(NAME_SPLIT_REGEX))
            .map(name -> {
                final String trimName = name.trim();
                checkNameIsEmpty(trimName::isEmpty);
                return trimName;
            })
            .collect(Collectors.toList());
    }

    private static void checkNameIsEmpty(final BooleanSupplier condition) {
        if (condition.getAsBoolean()) {
            throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION_MESSAGE);
        }
    }
}
