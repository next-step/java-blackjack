package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCardTest {

    @DisplayName("GameCard 에는 52장의 서로 다른 카드가 존재한다.")
    @Test
    void givenNumberWithString_WhenGetCardNumber_ThenEqualToGivenNumber() {
        GameCard gameCard = GameCard.create();

        Set<Card> removedDuplicateGameCard = new HashSet<>(gameCard.getGameCard());

        assertThat(removedDuplicateGameCard.size())
            .isEqualTo(52);
    }
}