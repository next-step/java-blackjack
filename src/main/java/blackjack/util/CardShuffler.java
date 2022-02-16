package blackjack.util;

import java.util.List;
import java.util.Random;

public class CardShuffler {

    private static final Random random = new Random();

    public static String pickSymbolIn(List<String> symbols) {
        int pickIndex = random.nextInt(symbols.size());
        return symbols.get(pickIndex);
    }

    public static int pickCardIndexIn(int bound) {
        return random.nextInt(bound);
    }
}
