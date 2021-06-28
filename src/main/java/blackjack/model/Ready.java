package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Ready {

    public List<Participant> createGamblers(String inputName) {
        return createGamblers(splitName(inputName));
    }

    public List<Participant> createGamblers(String[] playerList) {
        List<Participant> participants = new ArrayList<>();
        for (String player : playerList) {
            participants.add(new Participant(player));
        }
        return participants;
    }

    public String[] splitName(String name) {
        return name.split(",");
    }
}
