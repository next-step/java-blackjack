package blackjack.controller;

import blackjack.domain.awards.Awards;
import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Hit;
import blackjack.domain.state.State;
import blackjack.view.InputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackController {
    private List<Player> players;
    private Dealer dealer;
    public void play() {
        // input player name and return it to player objects
        initGame();

        State state;
        for(int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            state = player.getState();
            while(!state.isFinished()) {
                // player가 draw를 할지 stay 를 할지 결정하는 로직 필요
                String answer = "y";
                // = inputView.getYesOrNo();
                // ? Finished 에는 draw가 왜 있을까요,,?
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

        AwardsResult awardsResult = Awards.produceResult(dealer, players);// 얘를 output view로 전달.
    }

    private void initGame() {
        // create Dealer and init
        dealer = new Dealer();
        dealer.initCard();
        // get player names from command line and parse it into player objects
        // c.f. 이름 input 받는 것 자체는 main 에서 해 주고 여기로 전달 받는 게 맞겠지??
        String rawPlayerNames = InputView.inputPlayerNames();
        List<String> playerNames = splitPlayerNames(rawPlayerNames);
        players = createPlayers(playerNames); //c.f. 플레이어들은 state를 받은 것 까지.
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
