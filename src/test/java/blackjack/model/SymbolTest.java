package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolTest {


    @DisplayName("getter 확인 테스트")
    @Test
    void initTest() {
        Symbol symbol = Symbol.ACE;
        assertThat(symbol.getName()).isEqualTo("A");
        assertThat(symbol.getScore()).isEqualTo(1);

    }
}