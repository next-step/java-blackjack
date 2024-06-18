package Service;

import Domain.Dealer;
import Domain.Participant;
import Domain.Player;
import Domain.TrumpCard;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJackGame {

    public List<Player> playerList = new ArrayList<>();
    BlackJackCard blackJackCard = new BlackJackCard();
    public Dealer dealer;

    public void registerParticipant(String[] playerNames) {
        for (String playerName : playerNames) {
            Player player = new Player(playerName, blackJackCard.makeTwoCard());
            player.isBlackJack = checkBlackJack(player);
            this.playerList.add(player);
        }
    }

    public void registerDealer() {
        this.dealer = new Dealer("딜러", blackJackCard.makeTwoCard());
        this.dealer.getParticipantCardList().get(0).isHiddenCard = true;
        this.dealer.isBlackJack = checkBlackJack(this.dealer);
    }

    public boolean checkBlackJack(Participant participant) {
        return participant.getParticipantScore() == 21;
    }

    public boolean checkDealerScore() {
        return dealer.getParticipantScore() <= 16;
    }

    public void calculrateGame() {
        int dealerScore = dealer.getParticipantScore();
        for (Player player : playerList) {
            boolean isPlayerWin = player.isPlayerWin(dealerScore);
            if (isPlayerWin) {
                player.playerResult = "승";
                dealer.dealerLoseCount += 1;
            } else {
                player.playerResult = "패";
                dealer.dealerWinCount += 1;
            }
        }
//        playerList.stream()
//                .filter(a -> a.isPlayerWin(dealerScore))
//                .forEach(Player::setPlayerResult);
    }

    public void participantAddCard(Participant participant) {
        participant.addParticipantCardList(blackJackCard.makeOneCard());
    }

    public void dealerCardOpen(){
        dealer.getParticipantCardList().get(0).isHiddenCard = false;
    }

    public void calcurateBettingPrice() {
        int dealerScore = dealer.getParticipantScore();
        float bettingValue = 1 ;

        for (Player player : playerList) {
            bettingValue = player.isPlayerWin_2(dealerScore, dealer.isBlackJack, player.isBlackJack);
            player.winningPrice += (int)(player.bettingPrice * bettingValue);
            dealer.winningPrice += (int)(player.bettingPrice* bettingValue * -1);
        }
    }
}