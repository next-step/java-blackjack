package Domain;

public class TrumpCard {
    public Shape cardShape ;
    public int cardNumber ;
    public boolean isHiddenCard ;

    // 카드 주기
    public TrumpCard(int randomNumber) {
        this.cardShape = makeRandomShape(randomNumber);
        this.cardNumber = makeRandomNumber(randomNumber);
    }

    public Shape makeRandomShape(int randomNumber){
        return Shape.values()[(int)randomNumber/13] ;
    }

    public int makeRandomNumber(int randomNumber){
        return (randomNumber%13)+1 ;
    }

    public int getCardNumber(){
        return this.cardNumber;
    }

    public int getCardScore(){
        if(this.cardNumber >= 11){
            return 10;
        }

        return this.cardNumber;
    }
}