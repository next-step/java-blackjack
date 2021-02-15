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
        gamer1.calculateScore(); // 20
        Gamer gamer2 = new Gamer("seokhyeon", deck); // 9스페이드, 8스페이드
        gamer2.calculateScore(); // 17
        Gamer gamer3 = new Gamer("seok", deck); // 7스페이드, 6스페이드
        gamer3.calculateScore(); // 13

        // when
        String win = finalResult.getFinalResult(dealer, gamer1); // gamer 승
        String lose = finalResult.getFinalResult(dealer, gamer2); // dealer 승
        finalResult.getFinalResult(dealer, gamer3); // dealer 승
        int winCount = finalResult.getWinCount(); // 2번 이김
        int loseCount = finalResult.getLoseCount(); // 1번 짐

        // then
        Assertions.assertThat(win).isEqualTo("승");
        Assertions.assertThat(lose).isEqualTo("패");
        Assertions.assertThat(winCount).isEqualTo(2);
        Assertions.assertThat(loseCount).isEqualTo(1);
    }
}
