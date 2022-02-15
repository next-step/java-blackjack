package blackjack.utils;

import java.util.Arrays;
import java.util.List;

public class Spliter {

    private static final String DELIMITER = ",";

    private Spliter() {
    }

    public static List<String> commaSplit(String playerNames) {
        return Arrays.asList(playerNames.replace(" ","").split(DELIMITER));
    }
 }
