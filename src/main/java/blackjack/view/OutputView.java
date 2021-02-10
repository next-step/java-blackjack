package blackjack.view;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import blackjack.dto.DealerScoreInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.NamesInfo;
import blackjack.dto.PersonInfo;
import blackjack.dto.PlayersScoreInfo;

import javax.naming.Name;
import java.util.List;
import java.util.Map;


public class OutputView {
    private static final String NAME_AND_INFO_FMT = "%s%s%s\n";
    private static final String BETWEEN_NAME_AND_INFO_DELIMITER = ": ";

    private static final String INIT_GAME_FMT = "%s와 %s에게 %d장씩 나누었습니다.\n";
    private static final String PLAYER_NAME_DELIMITER = ", ";

    private static final String SCORE_GUIDE_MSG = "## 최종 승패";
    private static final String DEALER_SCORE_INFO_DELIMITER = " ";

    public void printInitGameMsg(NameInfo dealerNameInfo, NamesInfo playersNameInfo, Integer initCardNum) {
        System.out.format(
            INIT_GAME_FMT,
            dealerNameInfo.getName(),
            String.join(PLAYER_NAME_DELIMITER, playersNameInfo.getNames()),
            initCardNum
        );
    }

    public void printCardInfo(PersonInfo personInfo) {
        System.out.printf("%s: %s\n",
            personInfo.getNameInfo().getName(),
            getCardInfo(personInfo.getCardBunchInfo())
        );

    }

    private String getCardInfo(CardBunchInfo cardBunchInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CardInfo card : cardBunchInfo.getCardsInfo()) {
            stringBuilder.append(card.getDenomination().getName())
                .append(card.getSuit().getName())
                .append(" ");
        }
        return stringBuilder.toString();
    }

    public void printDealerDrawInformation() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printScoreGuideMsg() {
        System.out.println(SCORE_GUIDE_MSG);
    }

    public void printDealerScoreInfo(NameInfo dealerNameInfo, DealerScoreInfo dealerScoreInfo) {
        printNameAndInfo(
            dealerNameInfo.getName(),
            String.join(
                DEALER_SCORE_INFO_DELIMITER,
                dealerScoreInfo.getScores()
            )
        );
    }

    public void printPlayersScoreInfo(PlayersScoreInfo playersScoreInfo) {
        playersScoreInfo.getPlayersScoreInfo().forEach(
            playerScoreInfo -> printNameAndInfo(
                playerScoreInfo.getNameInfo().getName(),
                playerScoreInfo.getScore()
            )
        );
    }

    private void printNameAndInfo(String name, String info) {
        System.out.format(NAME_AND_INFO_FMT, name, BETWEEN_NAME_AND_INFO_DELIMITER, info);
    }
}
