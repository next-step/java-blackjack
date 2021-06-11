package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Output.showPlayerName();
        List<String> names = Arrays.asList(Input.insertPlayerName().split(","));
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        Dealer dealer = new Dealer();
        PlayGame playGame = new PlayGame(players, dealer);
        playGame.gameStart(2);
        Output.showGameStart(dealer, players, names);
        for (Player player : players) {
            Output.isQuestion(player, playGame);
        }
        Output.giveDealerCard(dealer, playGame);
        Output.showCardStatus2(dealer.getHoldingCards(), dealer.sumCards());
        Output.isDrawPlayer(players);
        new WinnerResult(players, dealer);
        Output.showWinOrLose(dealer, players);
    }
}
