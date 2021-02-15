package blackjack.controller;

import blackjack.domain.awards.Awards;
import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Hit;
import blackjack.domain.state.PlayingCard;
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

        State state;
        // player 카드 받기 & 게임 진행
        for(int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            state = player.getState();
            System.out.println(player.getName());
            while(!state.isFinished()) {
                // OutputView
                System.out.printf("%s 는 한 장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)", player.getName());

                String answer = InputView.willDraw();

                List<PlayingCard> playingCards = player.getState().cards().getCards();


                // OutputView
                for(PlayingCard card : playingCards){
                    System.out.printf("%s_%d ",card.getSuit(),card.getDenomination().getScore());
                }
                System.out.println();

                if("y".equals(answer)) {
                    state = state.draw(dealer.popAndGiveCard());
                }
                if("n".equals(answer)) {
                    state = state.stay();
                }
            }
        }
        dealerDraw();
        result();
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

        OutputView.messageAfterInit(players);
        OutputView.cardStateAfterInit(dealer, players);
    }

    private void result() {
        OutputView.cardStateAfterEnd(dealer, players);
        AwardsResult awardsResult = Awards.produceResult(dealer, players);// 얘를 output view로 전달.
        OutputView.award(awardsResult);
    }

    private void dealerDraw() {
        // 딜러 카드 받을지 말지
        if(dealer.getCards().getSum() <= DEALER_DRAW_BOUND){

            // OutputView
            System.out.println("딜러는 16 이하라 한 장의 카드를 더 받았습니다.");

            dealer.drawMoreCard();
            return;
        }
        // OutputView
        System.out.println("딜러는 17 이상이 한 장의 카드를 더 받지 않습니다.");

    }

    private List<String> splitPlayerNames(String rawPlayerNames) {
        List<String> playerNames = Arrays.asList(rawPlayerNames.split(","));
        playerNames = playerNames.stream().map(raw -> raw.trim()).collect(Collectors.toList());
        return playerNames;
    }

    private List<Player> createPlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for(String playerName : playerNames) {
            Cards cards = dealer.initCard();
            State state = new Hit(cards); // new Cards를 딜러가 카드 주는 것으로 해야 함.
            Player player = new Player(playerName, state);
            players.add(player);
        }
        return players;
    }
}
