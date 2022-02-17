package blackjack.domain.request;

public class DrawRequest {

    private DrawRequest(boolean request) {
    }

    public static DrawRequest valueOf(String command) {
        return null;
    }

    public boolean isDrawable() {
        return true;
    }
}
