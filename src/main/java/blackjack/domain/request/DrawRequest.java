package blackjack.domain.request;

public class DrawRequest {

    private final boolean request;

    private DrawRequest(boolean request) {
        this.request = request;
    }

    public static DrawRequest valueOf(String command) {
        validateCommand(command);
        return new DrawRequest(findByCommand(command));
    }

    public boolean isDrawable() {
        return request;
    }

    private static boolean findByCommand(String command) {
        return "y".equals(command);
    }

    private static void validateCommand(String command) {
        if (command == null || command.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR] 아무 요청이 입력되지 않았습니다.");
        }
        if (!"y".equals(command) && !"n".equals(command)) {
            throw new IllegalArgumentException(String.format("[ERROR] %s는 올바른 요청이 아닙니다", command));
        }
    }
}
