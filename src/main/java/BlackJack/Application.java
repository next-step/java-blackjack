package BlackJack;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;
import BlackJack.actor.Players;
import BlackJack.game.PlayGame;
import BlackJack.game.Result;
import BlackJack.game.WinnerResultDealer;
import BlackJack.game.WinnerResultPlayer;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Output.showPlayerName();
        List<String> names = Arrays.asList(Input.insertPlayerName().split(","));
        Players players = new Players();
        for (String name : names) {
            players.add(new Player(name));
        }
        Dealer dealer = new Dealer();
        PlayGame playGame = new PlayGame(players, dealer);
        playGame.gameStart(2);
        Output.showGameStart(dealer, players, names);
        players.getPlayers().forEach(player -> {
            decideQuestion(player,playGame);
            Output.space();
        });

        while (dealer.isDrawCard(dealer.sumCards())) {
            Output.giveDealerCard(dealer);
            playGame.drawCardDealer();
        }
        Output.showCardStatus2(dealer.getHoldingCards(), dealer.sumCards());
        Output.isDrawPlayer(players);
        WinnerResultDealer winnerResultDealer = new WinnerResultDealer();
        Result result = new Result();
        players.getPlayers().forEach(player -> {
            WinnerResultPlayer winnerResult = new WinnerResultPlayer();
            winnerResult.resultCount(player, dealer);
            result.injectResult(player.getPlayerName(),winnerResult.getWinCount(),winnerResult.getLoseCount());
            boolean playerResult = winnerResult.playerResult(player, dealer);
            winnerResultDealer.resultCount(playerResult);
        });
        result.injectResult(dealer.getDEALER_NAME(),winnerResultDealer.getWinCount(),winnerResultDealer.getLoseCount());
        Output.showDealerWinOrLose(result,dealer);
        players.getPlayers().forEach(player -> {
            Output.showPlayerWinOrLose(result,player);
        });
    }

    private static void decideQuestion(Player player, PlayGame playGame) {
        boolean agree = true;
        while (player.isDrawCard(player.sumCards()) && agree) {
            Output.isQuestion(player, playGame);
            agree = Input.isDraw(Input.agreement(), player, playGame);
            if (agree) {
                playGame.drawCardPlayer(player);
                System.out.print(player.getPlayerName() + " : ");
                Output.showCardStatus(player.getHoldingCards());
            }
        }
    }
}
