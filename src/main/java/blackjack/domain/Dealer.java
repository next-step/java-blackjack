package blackjack.domain;

import java.util.ArrayList;

public class Dealer extends Gambler{

    public Dealer(String name){
        this.name = name;
        this.cards=new ArrayList<>();
    }

    @Override
    protected int calculateScore() {
        return 0;
    }

    @Override
    protected void receiveCard() {

    }

    public Card allocateCard(){
        return null;
    }

}
