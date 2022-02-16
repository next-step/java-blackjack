package blackJack.view;

import blackJack.domain.Dealer;
import blackJack.domain.GameUser;
import blackJack.domain.Player;
import java.util.List;

public class OutputView {

    private static final String PRINT_REQUEST_PLAYER_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String PRINT_INIT_CARD_DRAW_FORMAT = "%n딜러와 %s에게 2장의 나누었습니다.%n";
    private static final String PRINT_REQUEST_ADDITIONAL_CARD_DRAW_FORMAT = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)%n";
    private static final String PRINT_DEALER_ADDITIONAL_CARD_DRAW = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n";

    public static void printRequestPlayerNames() {
        System.out.println(PRINT_REQUEST_PLAYER_NAMES);
    }

    public static void printInitCardDrawFormat(List<String> playerNames) {
        System.out.printf(PRINT_INIT_CARD_DRAW_FORMAT, String.join(", ", playerNames));
    }

    public static void printUserStatus(GameUser gameUser) {
        printDealerStatus(gameUser.getDealer());
        printPlayersStatus(gameUser.getPlayers());
        System.out.println();
    }

    public static void printDealerStatus(Dealer dealer) {
        System.out.println(dealer.convertStatus());
    }

    public static void printPlayersStatus(List<Player> players) {
        players.forEach(OutputView::printPlayerStatus);
    }

    public static void printPlayerStatus(Player player) {
        System.out.println(player.convertStatus());
    }

    public static void printRequestAdditionalCardDrawFormat(Player player) {
        System.out.printf(PRINT_REQUEST_ADDITIONAL_CARD_DRAW_FORMAT, player.getName());
    }

    public static void printDealerAdditionalCardDraw() {
        System.out.println(PRINT_DEALER_ADDITIONAL_CARD_DRAW);
    }
}
