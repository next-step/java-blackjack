package blackjack.view;

public enum ViewConstantStrings {
    INPUT_PLAYER_NAMES("플레이어 이름 입력"),
    DEALER_AND("딜러와 "),
    GIVE_TWO_CARDS("에게 2장의 카드를 나눴습니다."),
    DEALER("딜러 : "),
    CARD("카드 : "),
    DEALER_CARD("딜러 카드 : "),
    PLAYER_DRAW("는 한 장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)"),
    SUM("합계 : "),
    NEW_LINE("\n"),
    RESULT(" - 결과 :"),
    DEALER_RESULT("딜러의 결과 :"),
    COLON(" : "),
    SEPERATOR(", "),
    WHITE_SPACE(" "),
    WIN("승"),
    LOSS("패"),
    DEALER_UNDER_16("딜러는 16 이하라 한 장의 카드를 더 받았습니다."),
    DEALER_MORE_THAN_17("딜러는 16 이하라 한 장의 카드를 더 받았습니다.");

    private String constantString;
    ViewConstantStrings(String constantString){
        this.constantString = constantString;
    }

    @Override
    public String toString(){
        return constantString;
    }
}
