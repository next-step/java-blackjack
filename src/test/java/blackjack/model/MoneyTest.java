package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("Money 오브젝트 생성")
    @Test
    void init() {

        int expectedMoneyAmount = 15000;
        Money money = Money.of(expectedMoneyAmount);
        assertThat(money.getMoney()).isEqualTo(expectedMoneyAmount);
    }
    @DisplayName("Money 오브젝트 생성")
    @Test
    void IllegalArgumentGiven() {

        int wrongMoneyAmount = -1;

        assertThrows(IllegalArgumentException.class, () -> {
            Money money = Money.of(wrongMoneyAmount);
        });
    }
    @DisplayName("Money 오브젝트 생성")
    @Test
    void loseMoney() {
        int initMoney = 5000;
        int betMoney = 2000;
        int expectedMoney = (int) (initMoney - 0.5 * betMoney);
        Money money = Money.of(initMoney);
        money.subtractAsRevenue(betMoney);
        assertThat(money.getMoney()).isEqualTo(expectedMoney);
    }

    @DisplayName("Money 오브젝트 생성")
    @Test
    void addRevenue() {
        int betMoney = 2000;
        int expectedMoney = (int) (1.5 * betMoney);
        Money money = Money.of(betMoney);
        money.setRevenueToMoney();
        assertThat(money.getMoney()).isEqualTo(expectedMoney);
    }


}