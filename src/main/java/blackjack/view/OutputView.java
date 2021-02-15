package blackjack.view;

import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.PlayingCard;

import java.util.ArrayList;
import java.util.List;

import static blackjack.view.ViewConstantStrings.*;

public class OutputView {

    public static void inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAMES.toString());
    }

    public static void messageAfterInit(List<Player> players) {
        StringBuilder message = new StringBuilder();
        message.append(DEALER_AND.toString());
        appendPlayerNames(players, message);
        message.append(GIVE_TWO_CARDS.toString());
        System.out.println(message.toString());
    }

    private static void appendPlayerNames(List<Player> players, StringBuilder message) {
        for (Player player : players) {
            message.append(player.getName() + SEPERATOR.toString());
        }
    }

    public static void cardStateAfterInit(Dealer dealer, List<Player> players) {
        // 딜러의 1장의 카드 출력.(다른 한 장은 뒤집어 진 상태)
        StringBuilder message = new StringBuilder();
        dealerCardStateAfterInit(dealer, message);
        // 플레이어의 2장의 카드 출력.
        playersCardStateAfterinit(players, message);
        System.out.println(message.toString());
    }

    private static void dealerCardStateAfterInit(Dealer dealer, StringBuilder message) {
        message.append(DEALER.toString());

        Card dealerCard = dealer.getCards().getCards().get(0);
        message.append(dealerCard.getDenomination().getScore().toString() + dealerCard.getSuit() + NEW_LINE.toString());
    }

    private static void playersCardStateAfterinit(List<Player> players, StringBuilder message) {
        for (Player player : players) {
            message.append(cardStateOnePlayer(player) + NEW_LINE.toString());
        }
    }

    public static void playerDrawCard(Player player) {
        System.out.printf(player.getName() + PLAYER_DRAW.toString() + NEW_LINE.toString());
    }

    public static void printCardStateOnePlayer(Player player) {
        StringBuilder message = cardStateOnePlayer(player);
        System.out.println(message.toString());
    }

    public static void cardStateAfterEnd(Dealer dealer, List<Player> players) {
        StringBuilder message = new StringBuilder();
        dealerStateAfterEnd(dealer, message);
        playersStateAfterEnd(players, message);
        System.out.println(message);
    }

    private static void dealerStateAfterEnd(Dealer dealer, StringBuilder message) {
        message.append(DEALER_CARD.toString());
        String joinedMessage = accumulatePlayingCardList(dealer.getCards().getCards());
        message.append(joinedMessage + RESULT.toString() + dealer.getCards().getSum().toString() + NEW_LINE.toString());
    }

    private static String accumulatePlayingCardList(List<PlayingCard> playingCards) {
        List<String> tempMessageList = new ArrayList<>();
        for (PlayingCard card : playingCards) {
            String tempMessage = card.getSuit() + card.getDenomination().getScore().toString() + WHITE_SPACE.toString();
            tempMessageList.add(tempMessage);
        }
        return String.join(",", tempMessageList);
    }

    private static void playersStateAfterEnd(List<Player> players, StringBuilder message) {
        for (Player player : players) {
            message.append(cardStateOnePlayer(player));
            message.append(cardSumOnePlayer(player));
        }
    }

    private static StringBuilder cardStateOnePlayer(Player player) {
        StringBuilder message = new StringBuilder();
        List<PlayingCard> playingCards = player.getState().cards().getCards();
        message.append(player.getName() + CARD.toString());
        String joinedMessage = accumulatePlayingCardList(playingCards);
        return message.append(joinedMessage);
    }

    private static StringBuilder cardSumOnePlayer(Player player) {
        StringBuilder message = new StringBuilder();
        message.append(RESULT.toString() + player.getState().cards().getSum().toString() + NEW_LINE.toString());
        return message;
    }

    public static void award(AwardsResult awardsResult) {
        StringBuilder message = new StringBuilder(AWARD.toString() + NEW_LINE);
        message.append(DEALER_RESULT.toString() +
                awardsResult.getDealer().getWinCount().toString() + WIN.toString() + WHITE_SPACE.toString() +
                awardsResult.getDealer().getLossCount().toString() + LOSS.toString() + NEW_LINE.toString());
        accumultatePlayersWinLoss(awardsResult, message);
        System.out.println(message);
    }

    private static void accumultatePlayersWinLoss(AwardsResult awardsResult, StringBuilder message) {
        for (Player player : awardsResult.getPlayers()) {
            message.append(player.getName() + COLON.toString());
            appendPlayerWinOrLoss(message, player);
        }
    }

    private static void appendPlayerWinOrLoss(StringBuilder message, Player player) {
        if (player.getIsWin()) {
            message.append(WIN.toString() + NEW_LINE.toString());
            return;
        }
        message.append(LOSS.toString() + NEW_LINE.toString());
    }

    public static void dealerUnder16() {
        System.out.println(DEALER_UNDER_16.toString() + NEW_LINE.toString());
    }

    public static void dealerMoreThan17() {
        System.out.println(DEALER_MORE_THAN_17.toString() + NEW_LINE.toString());
    }
}
