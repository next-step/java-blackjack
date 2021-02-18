package blackjack.utils;

public class StringUtils {
    public static final String COLON = " : ";
    public static final String SPACE = " ";
    public static final String WIN = "승";
    public static final String LOSE = "패";
    public static final String YES = "y";
    public static final String YES_OR_NO_REGEX = "y|n";
    public static final String GET_USERS_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    public static final String GET_DECISION_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";
    public static final String DEALERS_DRAW_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    public static final String PLAYER_SCORE_FORMAT = " - 결과 : %d\n";
    public static final String FINAL_RESULT_MESSAGE = "\n## 최종승패";
    public static final String USER_RESULT_STRING_FORMAT = "%s: %s";
    public static final String DEALER_RESULT_STRING_FORMAT = "%s: %d%s %d%s";

    private StringUtils() {}
}
