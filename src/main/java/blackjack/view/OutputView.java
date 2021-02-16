package blackjack.view;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;
import blackjack.dto.ScoreBoardInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INIT_PROMPT = "딜러와 %s에게 2장씩 나누었습니다.%n";

    private static final String DEALER_CARDINFO_PROMPT = "딜러: %s%n";
    private static final String PERSON_CARDINFO_PROMPT = "%s카드: %s%n";

    private static final String DEALER_DRAW_INFO_PROMPT = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n";

    private static final String DEALER_SCORE_PROMPT = "딜러 카드: %s - 결과: %d%n";
    private static final String PLAYER_SCORE_PROMPT = "%s - 결과: %d%n";

    private static final String PLAYER_CARD_PROMPT = "%s카드: %s";

    public void printInitialCardDrawInfo(List<NameInfo> players) {
        System.out.printf(OutputView.INIT_PROMPT, formatName(players));
    }

    public void printDealerCardInfo(CardInfo dealerCard) {
        System.out.printf(DEALER_CARDINFO_PROMPT, dealerCard.getFullCardInfo());
    }

    public void printPlayersCardInfo(List<PersonInfo> personInfo) {
        personInfo.forEach(person -> System.out.println(
                getPlayersCardInfoString(
                        person.getNameInfo().getName(),
                        person.getCardBunchInfo()
                )
        ));
    }

    public void printCardInfo(PersonInfo player) {
        System.out.printf(PERSON_CARDINFO_PROMPT,
                player.getNameInfo().getName(),
                getCardInfo(player.getCardBunchInfo()));
    }


    public void printDealerCardScore(PersonInfo dealer, Integer score) {
        System.out.printf(DEALER_SCORE_PROMPT, getCardInfo(dealer.getCardBunchInfo()), score);
    }

    public void printDealerDrawInformation() {
        System.out.println(DEALER_DRAW_INFO_PROMPT);
    }

    public void printPlayersCardScore(List<PersonInfo> personInfos) {
        personInfos.forEach(person -> System.out.printf(
                PLAYER_SCORE_PROMPT,
                getPlayersCardInfoString(
                        person.getNameInfo().getName(),
                        person.getCardBunchInfo()
                ),
                person.getScore()
        ));
    }

    public void printFinalResult(Map<String, String> playerResult, ScoreBoardInfo scoreBoardInfo) {
        System.out.println("## 최종 승패");
        printDealerResult(scoreBoardInfo);
        printPlayerResult(playerResult);
    }

    private void printDealerResult(ScoreBoardInfo scoreBoardInfo) {
        System.out.printf("딜러: %d승 %d무 %d패%n",
                scoreBoardInfo.getWinCount(),
                scoreBoardInfo.getDrawCount(),
                scoreBoardInfo.getLoseCount());
    }

    private void printPlayerResult(Map<String, String> playerResult) {
        playerResult.forEach((name, result) -> System.out.printf("%s: %s%n", name, result));
    }

    private String formatName(List<NameInfo> players) {
        return players.stream().map(NameInfo::getName).collect(Collectors.joining(", "));
    }

    private String getCardInfo(CardBunchInfo cardBunchInfo) {
        return cardBunchInfo.getCardsInfo().stream().map(CardInfo::getFullCardInfo).collect(Collectors.joining(" "));
    }

    private String getPlayersCardInfoString(String name, CardBunchInfo cardBunchInfo) {
        return String.format(PLAYER_CARD_PROMPT, name, getCardInfo(cardBunchInfo));
    }
}