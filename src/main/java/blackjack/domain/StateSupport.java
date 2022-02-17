package blackjack.domain;


public abstract class StateSupport extends CardAddibleSupport{

    public StateSupport(final Cards card){
        super(card);
    }

    @Override
    public boolean isEnd(){
        return true;
    }

    @Override
    public CardAddible judge() {
        return null;
    }

}
