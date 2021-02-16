package blackjack.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static String inputPlayerNames() {
        String rawPlayerNames = null;
        try {
            rawPlayerNames = input.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return rawPlayerNames;
    }

    public static String willDraw() {
        String selectDraw = null;
        try {
            selectDraw = input.readLine();
            validateYesOrNO(selectDraw);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return selectDraw;
    }

    private static void validateYesOrNO(String selectDraw) {
        if (!selectDraw.equals("y") && !selectDraw.equals("n")) {
            throw new IllegalArgumentException("y 혹은 n 만 입력해 주세요.");
        }
    }
}
