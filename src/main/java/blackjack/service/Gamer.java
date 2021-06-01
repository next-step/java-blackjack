package blackjack.service;

import java.util.ArrayList;
import java.util.List;

public class Gamer extends Player {



    Gamer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void addDraw() {

    }
}
