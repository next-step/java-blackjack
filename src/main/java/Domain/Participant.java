package Domain;

import java.util.ArrayList;
import java.util.List;

public class Participant {

    private String name;
    List<TrumpCard> ParticipantCardList = new ArrayList<>();
    public int winningPrice = 0 ;
    public boolean isBlackJack = false ;
    public Participant(String name, List<TrumpCard> ParticipantCardList) {
        this.name = name;
        this.ParticipantCardList = ParticipantCardList;
    }

    public void addParticipantCardList(TrumpCard trumpCard) {
        this.ParticipantCardList.add(trumpCard);
    }

    public int getParticipantScore() {
        int score = ParticipantCardList.stream().map(TrumpCard::getCardScore).mapToInt(i->i).sum();
        if (aceCount()){
            return checkAce(score);
        }
        return score;
    }

    public boolean aceCount(){
        return ParticipantCardList.stream().anyMatch(a -> a.getCardNumber() == 1);
    }

    public int checkAce(int score){
        // if ParticipantCardList.cardNumber == 0 이 있다면
        if (score <= 11){
            return score - 1 + 11 ;
        }
        return score ;
    }

    public String getCardName(){
        String cardInfos = "";
        for(TrumpCard trumpCard : ParticipantCardList){
            if (!trumpCard.isHiddenCard) {
                cardInfos += getOneCardName(trumpCard);
                cardInfos += ", ";
            }
        }
        return cardInfos ;
    }

    public String getOneCardName(TrumpCard trumpCard){
        String[] cardInfo = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        return cardInfo[trumpCard.cardNumber] + trumpCard.cardShape;
    }

    public String getName() {
        return this.name;
    }

    public boolean isBurst(){
        if(getParticipantScore() >= 21){
            return true;
        }
        return false;
    }

    public List<TrumpCard> getParticipantCardList() {
        return ParticipantCardList;
    }
}

