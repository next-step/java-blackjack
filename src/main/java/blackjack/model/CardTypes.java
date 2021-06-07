package blackjack.model;

public enum CardTypes {
    CLOVER_A("A클로버", 1), HEART_A("A하트", 1), DIAMOND_A("A다이아몬드", 1), SPADE_A("A스페이드", 1),
    CLOVER_2("2클로버", 2), HEART_2("2하트", 2), DIAMOND_2("2다이아몬드", 2), SPADE_2("2스페이드", 2),
    CLOVER_3("3클로버", 3), HEART_3("3하트", 3), DIAMOND_3("3다이아몬드", 3), SPADE_3("3스페이드", 3),
    CLOVER_4("4클로버", 4), HEART_4("4하트", 4), DIAMOND_4("4다이아몬드", 4), SPADE_4("4스페이드", 4),
    CLOVER_5("5클로버", 5), HEART_5("5하트", 5), DIAMOND_5("5다이아몬드", 5), SPADE_5("5스페이드", 5),
    CLOVER_6("6클로버", 6), HEART_6("6하트", 6), DIAMOND_6("6다이아몬드", 6), SPADE_6("6스페이드", 6),
    CLOVER_7("7클로버", 7), HEART_7("7하트", 7), DIAMOND_7("7다이아몬드", 7), SPADE_7("7스페이드", 7),
    CLOVER_8("8클로버", 8), HEART_8("8하트", 8), DIAMOND_8("8다이아몬드", 8), SPADE_8("8스페이드", 8),
    CLOVER_9("9클로버", 9), HEART_9("9하트", 9), DIAMOND_9("9다이아몬드", 9), SPADE_9("9스페이드", 9),
    CLOVER_10("10클로버", 10), HEART_10("10하트", 10), DIAMOND_10("10다이아몬드", 10), SPADE_10("10스페이드", 10),
    CLOVER_J("J클로버", 10), HEART_J("J하트", 10), DIAMOND_J("J다이아몬드", 10), SPADE_J("J스페이드", 10),
    CLOVER_Q("Q클로버", 10), HEART_Q("Q하트", 10), DIAMOND_Q("Q다이아몬드", 10), SPADE_Q("Q스페이드", 10),
    CLOVER_K("K클로버", 10), HEART_K("K하트", 10), DIAMOND_K("K다이아몬드", 10), SPADE_K("K스페이드", 10);

    private final String name;
    private final int value;

    CardTypes(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
