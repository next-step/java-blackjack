package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Participant;
import blackjack.domain.Participants;
import blackjack.domain.Players;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Participant start() {
        // 사용자 입력
        List<String> name = new ArrayList<>();
        name.add("pobi");
        name.add("jason");

        // Players 생성
        Players players = Players.from(name);

        // 딜러 추가
        Dealer dealer = new Dealer("dealer");

        // 사용자 추가
        Participants participants = Participants.from(players, dealer);

        // 딜러 , 사용자 에게 카드 2장씩 분배
        participants.drawCardMultiple(2);

        // 사용자 1장씩 뽑기
        participants.drawCardMultiple(1);

        // 사용자별 카드 최종 상태 출력

        participants.judgeScore();
        // 최종 승패 출력

        return null;
    }
}
