package blackjack.model;

import java.util.List;

public class Stadium {
    List<Participant> participants;

    public Stadium(List<Participant> participants) {
        this.participants = participants;
    }

    // 카드 게임
    public void playCardGame() {
        for (Participant participant : participants) {
            //initialSetting(participant);
            System.out.print(participant.getName() + " 첫번째 결과 : ");
            for (Card card : participant.getCards()) {
                System.out.print(card.getDenomination() + " " + card.getSuit() + " ");
            }
            System.out.println();

            drawNewCard(participant);
            System.out.print(participant.getName() + " 두번째 결과 : ");
            for (Card card : participant.getCards()) {
                System.out.print(card.getDenomination() + " " + card.getSuit() + " ");
            }
            System.out.println();
        }
    }

    private void drawNewCard(Participant participant) {
        if (participant.selectChoice(participant.getName())) {
            participant.drawCard();
        }
    }
}
