package blackjack;

public enum CardNumber {
    ACE(1),
    N2(2),
    N3(3),
    N4(4),
    N5(5),
    N6(6),
    N7(7),
    N8(8),
    N9(9),
    N10(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private Integer number;

    CardNumber(Integer number){
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }
}
