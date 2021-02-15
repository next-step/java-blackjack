package blackjack.view;

public enum ViewConstantStrings {
    INPUT_PLAYER_NAMES("플레이어 이름 입력"),
    DEALER_AND("딜러와 "),
    GIVE_TWO_CARDS("에게 2장의 카드를 나눴습니다."),
    DEALER("딜러 : "),
    CARD("카드 : "),
    DEALER_CARD("딜러 카드 : "),
    SUM("합계 : "),
    NEW_LINE("\n"),
    RESULT(" - 결과 :"),
    DEALER_RESULT("딜러의 결과 :"),
    COLON(" : "),
    WIN("승"),
    LOSS("패");



    private String constantString;
    ViewConstantStrings(String constantString){
        this.constantString = constantString;
    }

    @Override
    public String toString(){
        return constantString;
    }
}
