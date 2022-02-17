package blackjack.view;

import blackjack.domain.gamer.Gamer;
import java.util.Scanner;

public class InputView {
    private InputView() {}

    public static final String[] readPlayerName() {
        Scanner scanner = new Scanner(System.in);
        OutputView.requestPlayersName();

        try {
            String playerNames = scanner.nextLine();
            return playerNames.split(",");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return readPlayerName();
    }

    public static final boolean readAddCardOrNot(Gamer player) {
        Scanner scanner = new Scanner(System.in);
        OutputView.requestAddCardOrNot(player);

        try {
            if("y".equals(scanner.nextLine())) return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return false;
    }
}
