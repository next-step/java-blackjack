package blackjack.domain.player;

public class Count {
    public static final int ZERO = 0;
    private Integer count;

    public Count(final Integer count){
        if(count < ZERO){
            throw new IllegalArgumentException("0 혹은 양의 정수만 입력 가능합니다.");
        }
        this.count = count;
    }

    public Integer getCount(){
        return count;
    }

    public void increase(){
        count++;
    }
}
