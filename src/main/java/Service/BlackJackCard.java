package Service;

import Domain.Participant;
import Domain.TrumpCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJackCard {

    public List<TrumpCard> makeTwoCard(){
        List<TrumpCard> trumpCards = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            trumpCards.add(makeCardList(generateRandomNumber()));
        }
        return trumpCards;
    }

    public TrumpCard makeCardList(int randomNumber){
        List<TrumpCard> cardList = new ArrayList<>();
        return new TrumpCard(randomNumber);
    }

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(52);
    }

    public TrumpCard makeOneCard(){
        return new TrumpCard(generateRandomNumber());
    }

}
