package blackjack.view;

import blackjack.dto.PersonCardsInfo;
import blackjack.dto.DealerMatchScoreInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PlayerMatchScoreInfo;
import blackjack.dto.ScoreInfo;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INIT_GAME_FMT = "\n%s와 %s에게 %d장씩 나누었습니다.";

    private static final String NAME_DELIMITER = ", ";
    private static final String CARD_DELIMITER = ", ";

    private static final String MATCH_SCORE_GUIDE_MSG = "\n## 최종 승패";
    private static final String DEALER_MATCH_SCORE_DELIMITER = " ";

    public void printInitGameMsg(NameInfo dealerNameInfo, List<NameInfo> playersNameInfo, Integer initCardNum) {
        System.out.println(
            String.format(
                INIT_GAME_FMT,
                dealerNameInfo.getName(),
                playersNameInfo
                    .stream()
                    .map(NameInfo::getName)
                    .collect(Collectors.joining(NAME_DELIMITER)),
                initCardNum
            )
        );
    }

    public void printPersonCardsInfo(PersonCardsInfo personCardsInfo) {
        System.out.format(
            "%s 카드: %s\n",
            personCardsInfo.getName(),
            formatCards(personCardsInfo.getCardsName())
        );
    }

    public void printPeopleCardsInfo(List<PersonCardsInfo> peopleCardsInfo) {
        peopleCardsInfo.forEach(
            personCardsInfo -> printPersonCardsInfo(personCardsInfo)
        );
    }

    public void printScoreInfo(ScoreInfo scoreInfo) {
        System.out.println(
            String.format(
                "%s 카드: %s - 결과: %s",
                scoreInfo.getName(),
                formatCards(scoreInfo.getCardsName()),
                scoreInfo.getScore()
            )
        );
    }

    public void printScoresInfo(List<ScoreInfo> scoresInfo) {
        scoresInfo.forEach(
            scoreInfo -> printScoreInfo(scoreInfo)
        );
    }

    private String formatCards(List<String> cards) {
        return String.join(CARD_DELIMITER, cards);
    }

    public void printDealerDrawInformation() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printMatchScoreGuideMsg() {
        System.out.println(MATCH_SCORE_GUIDE_MSG);
    }

    public void printDealerMatchScoreInfo(DealerMatchScoreInfo dealerMatchScoreInfo) {
        System.out.println(
            formatMatchScore(
                "딜러",
                String.join(
                    DEALER_MATCH_SCORE_DELIMITER,
                    dealerMatchScoreInfo.getMatchScores()
                )
            )
        );
    }

    public void printPlayerMatchScoreInfo(PlayerMatchScoreInfo playerMatchScoreInfo) {
        System.out.println(
            formatMatchScore(
                playerMatchScoreInfo.getName(),
                playerMatchScoreInfo.getMatchScore()
            )
        );
    }

    public void printPlayersMatchScoreInfo(List<PlayerMatchScoreInfo> playersMatchScoreInfo) {
        playersMatchScoreInfo.forEach(
            playerMatchScoreInfo -> printPlayerMatchScoreInfo(playerMatchScoreInfo)
        );
    }

    private String formatMatchScore(String name, String matchScore) {
        return String.format("%s: %s", name, matchScore);
    }
}
