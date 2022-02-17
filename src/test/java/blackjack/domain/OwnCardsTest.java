package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwnCardsTest {

    @Test
    void 사용자_카드_추가_테스트() {
        OwnCards ownCards = new OwnCards();

        ownCards.addCard(new Card(CardNumber.ACE, CardType.DIAMOND));
        ownCards.addCard(new Card(CardNumber.FIVE, CardType.DIAMOND));

        assertThat(ownCards.getTotalScore()).isEqualTo(15);
    }

    @Test
    void 사용자_카드_점수_초과() {
        OwnCards ownCards = new OwnCards();

        ownCards.addCard(new Card(CardNumber.KING, CardType.DIAMOND));
        ownCards.addCard(new Card(CardNumber.QUEEN, CardType.DIAMOND));
        ownCards.addCard(new Card(CardNumber.EIGHT, CardType.CLOBER));

        assertTrue(ownCards.isScoreLimit());
    }

    @Test
    void 사용자_카드_블랙잭() {
        OwnCards ownCards = new OwnCards();

        ownCards.addCard(new Card(CardNumber.KING, CardType.DIAMOND));
        ownCards.addCard(new Card(CardNumber.QUEEN, CardType.DIAMOND));
        ownCards.addCard(new Card(CardNumber.ACE, CardType.CLOBER));

        assertTrue(ownCards.isBlackJack());
    }
}
