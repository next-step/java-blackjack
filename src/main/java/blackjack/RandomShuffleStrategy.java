package blackjack;

import java.util.Collections;
import java.util.Stack;

public class RandomShuffleStrategy implements ShuffleStrategy{
    @Override
    public void shuffle(Stack<Card> cards){
        Collections.shuffle(cards);
    }
}
