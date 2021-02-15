package blackjack.view;

import blackjack.dto.PersonMatchProfitInfo;
import blackjack.dto.PersonCardsInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INIT_GAME_FMT = "\n%s와 %s에게 %d장씩 나누었습니다.\n";
    private static final String NAME_DELIMITER = ", ";

    private static final String CARD_INFO_FMT = "%s 카드: %s\n";
    private static final String CARD_DELIMITER = ", ";
    private static final String SCORE_INFO_FMT = "%s 카드: %s - 결과: %s\n";

    private static final String DEALER_DRAW_INFO_FMT = "%s는 %s이하라 한장의 카드를 더 받았습니다\n";

    private static final String MATCH_PROFIT_GUIDE_MSG = "## 최종 승패";
    private static final String MATCH_PROFIT_INFO_FMT = "%s: %d\n";

    public void printInitializeGameMsg(NameInfo dealerNameInfo, List<NameInfo> playersNameInfo, Integer cardCnt) {
        System.out.format(INIT_GAME_FMT, dealerNameInfo.getName(), formatPlayersNameInfo(playersNameInfo), cardCnt);
    }

    private String formatPlayersNameInfo(List<NameInfo> playersNameInfo) {
        return playersNameInfo
            .stream()
            .map(NameInfo::getName)
            .collect(Collectors.joining(NAME_DELIMITER));
    }

    public void printPersonCardsInfo(PersonCardsInfo personCardsInfo) {
        System.out.format(
            CARD_INFO_FMT,
            personCardsInfo.getName(),
            formatCards(personCardsInfo.getCardsName())
        );
    }

    public void printPeopleCardsInfo(List<PersonCardsInfo> peopleCardsInfo) {
        peopleCardsInfo.forEach(
            this::printPersonCardsInfo
        );
        System.out.println();
    }

    private String formatCards(List<String> cards) {
        return String.join(CARD_DELIMITER, cards);
    }

    public void printDealerInfoMargin() {
        System.out.println();
    }

    public void printDealerDrawInformation(NameInfo dealerNameInfo, Integer limit) {
        System.out.format(DEALER_DRAW_INFO_FMT, dealerNameInfo.getName(), limit);
    }

    public void printScoreInfo(ScoreInfo scoreInfo) {
        System.out.format(
            SCORE_INFO_FMT,
            scoreInfo.getName(),
            formatCards(scoreInfo.getCardsName()),
            scoreInfo.getScore()
        );
    }

    public void printScoresInfo(List<ScoreInfo> scoresInfo) {
        scoresInfo.forEach(
            this::printScoreInfo
        );
        System.out.println();
    }

    public void printMatchProfitGuideMsg() {
        System.out.println(MATCH_PROFIT_GUIDE_MSG);
    }

    public void printPeopleMatchProfitInfo(List<PersonMatchProfitInfo> matchProfitsInfo) {
        matchProfitsInfo.forEach(this::printPersonMatchProfitInfo);
    }

    private void printPersonMatchProfitInfo(PersonMatchProfitInfo personMatchProfitInfo) {
        System.out.format(
            MATCH_PROFIT_INFO_FMT,
            personMatchProfitInfo.getName(),
            personMatchProfitInfo.getProfit()
        );
    }
}
