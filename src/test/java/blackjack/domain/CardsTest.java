package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CardsTest {

    private List<Card> cards;

    @Test
    void 새로운_카드를_추가할_수_있다() {
        Cards cards = new Cards(new ArrayList<>());

        cards.add(new Card(CardNumber.EIGHT, Suit.DIAMOND));
        int size = cards.size();

        assertThat(size).isEqualTo(1);
    }

    @Test
    void 뽑은_카드의_점수_합계를_구할_수_있다() {
        Cards cards = new Cards(new ArrayList<>(Arrays.asList(
            new Card(CardNumber.EIGHT, Suit.CLUB),
            new Card(CardNumber.SEVEN, Suit.CLUB),
            new Card(CardNumber.TWO, Suit.CLUB)
        )));

        int totalScore = cards.totalScore();

        assertThat(totalScore).isEqualTo(17);
    }

    @Test
    void 파산_여부를_알_수_있다() {
        Cards cards = new Cards(new ArrayList<>(Arrays.asList(
            new Card(CardNumber.EIGHT, Suit.CLUB),
            new Card(CardNumber.SEVEN, Suit.CLUB),
            new Card(CardNumber.SEVEN, Suit.CLUB)
        )));

        boolean result = cards.isBust();

        assertThat(result).isTrue();
    }

    @Test
    void 블랙잭_여부를_알_수_있다() {
        Cards cards = new Cards(new ArrayList<>(Arrays.asList(
            new Card(CardNumber.EIGHT, Suit.CLUB),
            new Card(CardNumber.SEVEN, Suit.CLUB),
            new Card(CardNumber.SIX, Suit.CLUB)
        )));

        boolean result = cards.blackjack();

        assertThat(result).isTrue();
    }

    @Test
    void 카드가_한_장도_없을_때_오픈하면_예외가_발생한다() {
        Cards cards = new Cards(new ArrayList<>());

        assertThatThrownBy(() -> cards.openCardOne())
            .isInstanceOf(RuntimeException.class)
            .hasMessage("카드가 존재하지 않습니다.");
    }

    @Test
    void 카드를_한_장_오픈할_수_있다() {
        Cards cards = new Cards(new ArrayList<>(Arrays.asList(
            new Card(CardNumber.EIGHT, Suit.CLUB
            ))));

        List<String> result = cards.openCardOne();

        assertThat(result).containsExactly("8클로버");

    }

    @Test
    void 모든_카드를_오픈할_수_있다() {
        Cards cards = new Cards(new ArrayList<>(Arrays.asList(
            new Card(CardNumber.EIGHT, Suit.CLUB),
            new Card(CardNumber.SEVEN, Suit.CLUB),
            new Card(CardNumber.TWO, Suit.CLUB)
        )));

        List<String> result = cards.openCardAll();

        assertThat(result).containsExactly("8클로버", "7클로버", "2클로버");
    }

}
