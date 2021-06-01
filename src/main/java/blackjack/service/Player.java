package blackjack.service;

public class Player extends Gamer{

    String name;

    Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
