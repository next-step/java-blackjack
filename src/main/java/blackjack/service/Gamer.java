package blackjack.service;

public class Gamer extends Player {

    String name;

    Gamer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
