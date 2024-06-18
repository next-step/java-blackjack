package Domain;

import java.util.List;

public class Player extends Participant{

    public String playerResult = "";
    public int bettingPrice = 0 ;
    public Player(String name, List<TrumpCard> ParticipantCardList) {
        super(name, ParticipantCardList);
    }

    public boolean isPlayerWin(int dealerScore){
        int myScore = getParticipantScore();
        if(myScore > 21){
            return false;
        }

        if(dealerScore > 21){
            return true;
        }

        return dealerScore < myScore;
    }

    public float isPlayerWin_2(int dealerScore, boolean isDealerBlackJack, boolean isPlayerBlackJack){
        int myScore = getParticipantScore();
        if(myScore > 21){
            return -1;
        }

        if(dealerScore > 21){
            return 1;
        }

        if(isDealerBlackJack && isPlayerBlackJack){
            return 1 ;
        }

        if(isPlayerBlackJack){
            return 1.5f ;
        }

        if(dealerScore < myScore){
            return 1 ;
        }

        if(dealerScore == myScore){ // 동점인 경우, 수익 0
            return 0 ;
        }

        return -1;
    }

    public String firstOpenCard(){
        String cardInfos = "";
        for(TrumpCard trumpCard : ParticipantCardList){
            cardInfos += getOneCardName(trumpCard);
            cardInfos += ", ";
        }
        return cardInfos ;
    }

    public int getBettingPrice() {
        return bettingPrice;
    }
    public void setPlayerResult(){
        playerResult = "승";
    }
}