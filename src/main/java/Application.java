import Domain.Player;
import Service.BlackJackGame;
import view.inputView;
import view.outputView;

import java.io.OutputStream;

public class Application {
    public static void main(String[] args) {
        outputView.outputPlayerNames();
        String[] playerNames = inputView.inputPlayerNames();

        outputView.outputPlayerInfo(playerNames);
        BlackJackGame game = new BlackJackGame();
        game.registerParticipant(playerNames);
        game.registerDealer();
        // <-- 등록

        for(Player player : game.playerList){
            outputView.outputBettingPrice(player.getName());
            player.bettingPrice = inputView.inputPlayerBettingPrice();
        }

        // 카드 OPEN -->
        outputView.outputParticipantCardInfo(game.dealer);
        game.playerList.forEach(outputView::outputParticipantCardInfo);
        // <-- 카드 OPEN

        // 플레이어 MORE 카드 -->
        for(Player player : game.playerList){
            while(!player.isBurst()){
                outputView.outputMoreCard(player.getName());

                if(inputView.inputIsMoreCard()){
                    game.participantAddCard(player);
                    outputView.outputParticipantCardInfo(player);
                    continue;
                }
                break;
            }
        }
        // <-- 플레이어 MORE 카드

        while (game.checkDealerScore()){
            game.participantAddCard(game.dealer);
            outputView.outputDealerCard();
        }

        // 딜러 hidden card 오픈
        game.dealerCardOpen();

        outputView.outputParticipantResult(game.dealer);
        game.playerList.forEach(outputView::outputParticipantResult);

//        game.calculrateGame();
        game.calcurateBettingPrice();
        outputView.outputBettingResult(game.dealer, game.playerList);
    }
}
