package blackjack;

public enum CardSuit {
    DIAMOND("다이아몬드"),
    CLOVER("클로버"),
    HEART("하트"),
    SPADE("스페이드");

    private String suitName;

    CardSuit(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return this.suitName;
    }
}
