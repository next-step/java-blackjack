package blackjack.view;

import static blackjack.domain.Person.INIT_CARD_COUNT;

import blackjack.dto.CardInfo;
import blackjack.dto.MatchInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String INIT_SHARE_MESSAGE = "%s와 %s에게 %d장을 받았습니다.";
    private static final String DELIMITER = ", ";
    private static final String DEALER_FORMAT = "%s: %s";
    private static final String PLAYER_FORMAT = "%s카드: %s";
    private static final String SCOREBOARD_FORMAT = "%s 카드: %s - 결과: %s\n";
    private static final String MATCH_RESULT_MESSAGE = "## 최종 승패";
    private static final String DEALER_DRAW_FORMAT = "%s는 %s이하라 한장의 카드를 더 받았습니다.\n";
    private static final String MATCH_RESULT_FORMAT = "%s: %s\n";

    public static void shareCards(final String dealerName, final List<NameInfo> playerNames) {
        String playersName = playerNames.stream()
            .map(NameInfo::getPersonName)
            .collect(Collectors.joining(DELIMITER));
        System.out.println(
            String.format(INIT_SHARE_MESSAGE, dealerName, playersName, INIT_CARD_COUNT));
    }

    public static void openCardInfo(final CardInfo dealerCardInfo, final List<CardInfo> playerCardsInfo) {
        System.out.println(
            String.format(DEALER_FORMAT, dealerCardInfo.getPersonName(), join(dealerCardInfo)));

        for (CardInfo playerCardInfo : playerCardsInfo) {
            System.out.println(
                String.format(PLAYER_FORMAT, playerCardInfo.getPersonName(), join(playerCardInfo)));
        }
    }

    private static String join(final CardInfo cardInfo) {
        return cardInfo.getCardNames().stream()
            .collect(Collectors.joining(DELIMITER));
    }

    public static void playerCardsInfo(final CardInfo activePlayerCardsInfo) {
        System.out.println(String.format(PLAYER_FORMAT, activePlayerCardsInfo.getPersonName(),
            join(activePlayerCardsInfo)));
    }

    public static void dealerDrawDecision(final NameInfo dealerNameInfo, final int limit) {
        System.out.format(DEALER_DRAW_FORMAT, dealerNameInfo.getPersonName(), limit);
    }

    public static void margin() {
        System.out.println();
    }

    public static void scoreboard(final List<ScoreInfo> scoreInfo) {
        scoreInfo.forEach(ResultView::scoreboard);
        margin();
    }

    public static void scoreboard(final ScoreInfo scoreInfo) {
        System.out.format(SCOREBOARD_FORMAT, scoreInfo.getName(),
            scoreInfo.getCardNames().stream().collect(
                Collectors.joining(DELIMITER)), scoreInfo.getScore());
    }

    public static void matchResult(final MatchInfo dealerMatchInfo, final List<MatchInfo> playersMatchInfo) {
        System.out.println(MATCH_RESULT_MESSAGE);
        printMatchResult(dealerMatchInfo);
        printMatchResult(playersMatchInfo);
    }

    private static void printMatchResult(final List<MatchInfo> playersMatchInfo) {
        playersMatchInfo.forEach(ResultView::printMatchResult);
    }

    private static void printMatchResult(final MatchInfo matchInfo) {
        System.out.format(MATCH_RESULT_FORMAT, matchInfo.getName(), matchInfo.getMatches());
    }
}
