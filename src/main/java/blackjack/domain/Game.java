package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void start() {
        // 사용자 입력
        List<String> name = new ArrayList<>();
        name.add("pobi");
        name.add("jason");

        // 딜러 추가
        Participant dealer = new Dealer("dealer");

        // 사용자 추가
        List<Participant> players = new ArrayList<>();
        players.add(new Player(name.get(0)));
        players.add(new Player(name.get(1)));

        // 딜러 , 사용자 에게 카드 2장씩 분배
        dealer.drawCard(2);
        for (Participant player : players) {
            player.drawCard(2);
        }

        // 받은 카드 상태 출력

        // 사용자 1장씩 뽑기
        for (Participant player : players) {
            player.drawCard(1);
        }

        // 딜러 1장 뽑기
        dealer.drawCard(1);

        // 사용자별 카드 최종 상태 출력

        // 최종 승패
    }
}
