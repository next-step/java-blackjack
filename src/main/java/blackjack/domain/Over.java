package blackjack.domain;

public abstract class Over extends StateSupport {

    public Over(final Cards card){
        super(card);
    }

    @Override
    public boolean isEnd(){
        return false;
    }

}
