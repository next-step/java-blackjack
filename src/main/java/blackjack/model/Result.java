package blackjack.model;

public enum Result {
    BLACKJACK("승"), WIN("승"), BUST("패"), LOSE("패"), PUSH("무"), DEFAULT("_");

    private String status;

    Result(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}