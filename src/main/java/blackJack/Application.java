package blackJack;

import blackJack.domain.BlackJack;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> userNames = Arrays.asList("박찬우", "제이슨");
        BlackJack blackJack = BlackJack.from(userNames);
        blackJack.run();
    }
}
