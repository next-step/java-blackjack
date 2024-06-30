package blackjack;

import java.util.Comparator;
import java.util.List;

public class Player {
    private String name;
    private Cards cards;

    public boolean result;

    public Player(String name){
        this.name = name;
        this.cards = new Cards();
    }

    public String getName() {
        return this.name;
    }

    public Integer getSum() {
        Integer result = 0;
        cards.getCards()
                .sort((c1, c2) -> c2.toInt().compareTo(c1.toInt()));
        for(Card card : cards.getCards()) {
            if (CardNumber.ACE.equals(card.getNumber())) {
                if(result + 11 <= 21) {
                    result += 10;
                }
            }
            result += card.toInt();
        }
        return result;
    }


    public Integer getCount() {
        return this.cards.getSize();
    }

    public void add(Card card) {
       cards.push(new Card(card));
    }

    public boolean isGreaterThan(int number) {
        return getSum() >= number;
    }

    public String toStringList(int idx) {
        List<String> collect = cards.getCards().stream().map(Card::toString).toList();
        return String.join(", ", collect.subList(idx, collect.size()));
    }

    public String toStringList() {
        return toStringList(0);
    }
}
