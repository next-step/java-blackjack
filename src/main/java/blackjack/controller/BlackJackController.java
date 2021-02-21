package blackjack.controller;

import blackjack.domain.Money;
import blackjack.domain.awards.Awards;
import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Hit;
import blackjack.domain.state.State;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackController {
    public static final int DEALER_DRAW_BOUND = 16;
    private List<Player> players;
    private Dealer dealer;

    public void play() {
        // input player name and return it to player objects
        initGame();
        // player 카드 받기 & 게임 진행
        playBlackJack();
        dealerDraw();
        result();
    }

    private void playBlackJack() {
        for (Player player : players) {
            OnePlayer(player);
        }
    }

    private void OnePlayer(Player player) {
        State state;
        state = player.getState();
        try {
            playUntilFinish(player, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playUntilFinish(Player player, State state) {
        while (!state.isFinished()) {
            OutputView.playerDrawCard(player);
            String answer = InputView.willDraw();

            state = stateAfterAsk(player, state, answer);
        }
    }

    private State stateAfterAsk(Player player, State state, String answer) {
        if (answer.equals("y")) {
            state = state.draw(dealer.popAndGiveCard());
            OutputView.printCardStateOnePlayer(player);
            return state;
        }
        if (answer.equals("n")) {
            state = state.stay();
        }
        return state;
    }

    private void initGame() {
        // create Dealer and init cards
        dealer = new Dealer();
        dealer.initCard();

        OutputView.inputPlayerNames();

        String rawPlayerNames = InputView.inputPlayerNames();

        // dealer, players 에게 2장의 카드를 나눠줌.
        dealer.initDealerCards();
        List<String> playerNames = splitPlayerNames(rawPlayerNames);
        players = createPlayers(playerNames);

        playersBetting();

        OutputView.messageAfterInit(players);
        OutputView.cardStateAfterInit(dealer, players);
    }


    private List<String> splitPlayerNames(String rawPlayerNames) {
        List<String> playerNames = Arrays.asList(rawPlayerNames.split(","));
        playerNames = playerNames.stream().map(raw -> raw.trim()).collect(Collectors.toList());
        return playerNames;
    }

    private List<Player> createPlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            Cards cards = dealer.initCard();
            State state = new Hit(cards);
            Player player = new Player(playerName, state);
            players.add(player);
        }
        return players;
    }

    private void playersBetting() {
        // 배팅
        for (Player player : players) {
            OutputView.batting(player);
            Money bettedMoney = new Money(InputView.betting()); // Money 는 int의 래퍼 클래스
            player.bet(bettedMoney);
        }
    }

    private void dealerDraw() {
        // 딜러 카드 받을지 말지
        if (dealer.getCards().getSum() <= DEALER_DRAW_BOUND) {
            OutputView.dealerUnder16();
            dealer.drawMoreCard();
            return;
        }
        OutputView.dealerMoreThan17();
    }

    private void result() {
        OutputView.cardStateAfterEnd(dealer, players);
        AwardsResult awardsResult = Awards.produceResult(dealer, players);// 얘를 output view로 전달.

        OutputView.award(awardsResult);
    }
}
