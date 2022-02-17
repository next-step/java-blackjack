package blackjack.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String NOT_SPACE = "";

    public static List<String> parseInput(String input) {
        String[] splitInput = input.replace(SPACE, NOT_SPACE).split(DELIMITER);

        return Arrays.stream(splitInput).collect(Collectors.toList());
    }
}
