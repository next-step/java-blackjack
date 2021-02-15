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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BlackJackController {
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
                    // 딜러를 틍해서 카드를 받되, 카드의 Bust, Blackjack 상태는 state 를 통해서 알수 있음
                   // 아래 코드는 플레이어가 가잔 상태에서 카드들을 관리해주는 것
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
        // create Dealer and init
        dealer = new Dealer();
        dealer.initCard();


        // OutputView
        System.out.println("플레이어 이름 입력");

        String rawPlayerNames = InputView.inputPlayerNames();

        List<String> playerNames = splitPlayerNames(rawPlayerNames);
        players = createPlayers(playerNames); //c.f. 플레이어들은 state를 받은 것 까지.

        // 2장의 카드를 나눠줌.

        // OutputView
        System.out.printf("딜러와 ");
        for(Player player : players){
            System.out.printf("%s, ",player.getName());
        }
        System.out.println("에게 2장의 카드를 나눴습니다.");
        // 2장의 카드를 나눠 줬을 때의 상태 출력.
        // 딜러의 1장의 카드 출력.(다른 한 장은 뒤집어 진 상태)
        System.out.printf("딜러 : ");


        dealer.initDealerCards();
        Card dealerCard = dealer.getCards().getCards().get(0);

        // OutputView
        System.out.printf("%s_%d\n",dealerCard.getSuit(),dealerCard.getDenomination().getScore());
        // 플레이어의 2장의 카드 출력.
        for(Player player : players) {
            System.out.printf("%s 카드 : ",player.getName());
            List<PlayingCard> playingCards = player.getState().cards().getCards();
            for(PlayingCard card : playingCards){
                System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
            }
            System.out.println();
        }

    }

    private void result() {
        AwardsResult awardsResult = Awards.produceResult(dealer, players);// 얘를 output view로 전달.


        // OutputView
        System.out.printf("딜러 카드 : ");
        for(PlayingCard card : dealer.getCards().getCards()){
            System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
        }
        System.out.printf("합계 : %d\n",dealer.getCards().getSum());

        // OutputView
        for(Player player : players) {
            List<PlayingCard> playingCards = player.getState().cards().getCards();
            System.out.printf("%s 카드 : ",player.getName());
            for(PlayingCard card : playingCards){
                System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
            }
            System.out.printf(" - 결과 : %d\n",player.getState().cards().getSum());
        }

        // OutputView
        System.out.printf("딜러의 결과 : %d 승 %d 패\n", awardsResult.getDealer().getWinCount(),awardsResult.getDealer().getLossCount());
        for(Player player : awardsResult.getPlayers()){
            System.out.printf("%s : ",player.getName());
            if(player.getIsWin()){
                System.out.println(" 승");
            }
            else{
                System.out.println(" 패");
            }
        }
    }

    private void dealerDraw() {
        // 딜러 카드 받을지 말지
        if(dealer.getCards().getSum() <= 16){

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
