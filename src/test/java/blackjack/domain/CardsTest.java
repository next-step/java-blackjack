package blackjack.domain;

import car.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    void addCard() {
    }

    @Test
    void getScore() {
        //give
        Cards cards = new Cards();
        cards.addCard(new Card(Suit.CLUBS, Denomination.ACE));
        cards.addCard(new Card(Suit.DIAMONDS, Denomination.JACK));

        //when
        Score score = cards.getScore();
        Score targetScore = new Score(21);

        //then
        System.out.println(score.getScore());
        System.out.println(targetScore.getScore());
        Assertions.assertThat(score).isEqualToComparingFieldByField(targetScore);
    }
}