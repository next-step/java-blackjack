package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Ready {

    public List<Gambler> createGamblers(String inputName) {
        return createGamblers(splitName(inputName));
    }

    public List<Gambler> createGamblers(String[] playerList) {
        List<Gambler> gamblers = new ArrayList<>();
        for (String player : playerList) {
            gamblers.add(new Gambler(player));
        }
        return gamblers;
    }

    public String[] splitName(String name) {
        return name.split(",");
    }
}
