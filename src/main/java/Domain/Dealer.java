package Domain;

import java.util.List;

public class Dealer extends Participant{

    public int dealerWinCount = 0 ;
    public int dealerLoseCount = 0 ;
    public Dealer(String name, List<TrumpCard> ParticipantCardList) {
        super(name, ParticipantCardList);
    }
    boolean firstOpen = true ;

    public String firstOpenCard(){
        return getOneCardName(ParticipantCardList.get(0));
    }
}
