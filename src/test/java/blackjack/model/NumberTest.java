package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {


    @DisplayName("getter 확인 테스트")
    @Test
    void initTest() {
        Number number = Number.ACE;
        assertThat(number.getName()).isEqualTo("A");
        assertThat(number.getNumber()).isEqualTo(1);

    }
}