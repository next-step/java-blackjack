package blackjack.util;

import java.util.Random;

public class CardShuffler {

    private static final Random random = new Random();

    public static int pickIndexIn(int bound) {
        return random.nextInt(bound);
    }
}
