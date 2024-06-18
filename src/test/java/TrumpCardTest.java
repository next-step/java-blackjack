import Domain.Shape;
import Domain.TrumpCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TrumpCardTest {

    @DisplayName("카드 한 장을 생성한다 - 모양 확인")
    @Test
    void checkShape(){
        TrumpCard testCard = new TrumpCard(0);
        assertThat(testCard.cardShape).isEqualTo(Shape.스페이드);
    }

    @DisplayName("카드 한 장을 생성한다 - 숫자 확인")
    @Test
    void checkNumber(){
        TrumpCard testCard = new TrumpCard(0);
        assertThat(testCard.cardNumber).isEqualTo(1);
    }

}