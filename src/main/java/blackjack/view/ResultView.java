package blackjack.view;

import static blackjack.domain.Person.INIT_CARD_COUNT;

import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String INIT_SHARE_MESSAGE = "%s와 %s에게 %d장을 받았습니다.";
    private static final String DELIMITER = ", ";
    private static final String DELETER_FORMAT = "%s: %s";
    private static final String PLAYER_FORMAT = "%s카드: %s";

    public static void shareCards(String dealerName, List<NameInfo> playerNames) {
        String playersName = playerNames.stream()
            .map(NameInfo::getPersonName)
            .collect(Collectors.joining(DELIMITER));
        System.out.println(String.format(INIT_SHARE_MESSAGE, dealerName, playersName, INIT_CARD_COUNT));
    }

    public static void openCardInfo(CardInfo dealerCardInfo, List<CardInfo> playerCardsInfo) {
        System.out.println(String.format(DELETER_FORMAT, dealerCardInfo.getPersonName(), join(dealerCardInfo)));

        for (CardInfo playerCardInfo : playerCardsInfo) {
            System.out.println(String.format(PLAYER_FORMAT, playerCardInfo.getPersonName(), join(playerCardInfo)));
        }
    }

    private static String join(CardInfo cardInfo) {
        return cardInfo.getCardNames().stream()
            .collect(Collectors.joining(DELIMITER));
    }


}
