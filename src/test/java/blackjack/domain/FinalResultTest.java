package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinalResultTest {
    @Test
    void getFinalResultTest() {
        // given
        FinalResult finalResult = new FinalResult();
        Deck deck = new Deck(false);

        Dealer dealer = new Dealer(deck); // K스페이드, Q스페이드
        dealer.calculateScore(); // 20

        Gamer gamer1 = new Gamer("seokkie", deck); // J스페이드, 10스페이드
        gamer1.setMoney("10000");
        gamer1.calculateScore(); // 20
        Gamer gamer2 = new Gamer("seokhyeon", deck); // 9스페이드, 8스페이드
        gamer2.setMoney("5000");
        gamer2.calculateScore(); // 17
        Gamer gamer3 = new Gamer("seok", deck); // 7스페이드, 6스페이드
        gamer3.setMoney("2500");
        gamer3.calculateScore(); // 13

        // when
        int gamer1OfMoney = finalResult.getFinalResult(dealer, gamer1); // 비김
        int gamer2OfMoney = finalResult.getFinalResult(dealer, gamer2); // dealer 승
        finalResult.getFinalResult(dealer, gamer3); // dealer 승
        int moneyOfDealer = finalResult.getMoneyOfDealer(); // -2500

        // then
        Assertions.assertThat(gamer1OfMoney).isEqualTo(0);
        Assertions.assertThat(gamer2OfMoney).isEqualTo(-5000);
        Assertions.assertThat(moneyOfDealer).isEqualTo(7500);
    }
}
