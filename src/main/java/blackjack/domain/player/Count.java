package blackjack.domain.player;

public class Count {
    private Integer count;

    public Count(final Integer count){
        this.count = count;
    }

    public Integer getCount(){
        return count;
    }

    public void increase(){
        count++;
    }
}
