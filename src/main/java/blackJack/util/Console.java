package blackJack.util;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

public class Console {

    private static Scanner scanner = getScanner();

    private Console() {
    }

    public static String readLine() {
        makeNewScannerIfScannerIsClosed();
        return scanner.nextLine().replace("\\n", "\n");
    }

    private static void makeNewScannerIfScannerIsClosed() {
        if (Objects.isNull(scanner) || scannerIsClosed()) {
            scanner = getScanner();
        }
    }

    private static boolean scannerIsClosed() {
        try {
            Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
            sourceClosedField.setAccessible(true);
            return sourceClosedField.getBoolean(scanner);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("리플렉션 중 에러 발생");
        }
        return true;
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
