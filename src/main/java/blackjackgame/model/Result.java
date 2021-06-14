package blackjackgame.model;

public enum Result {
    win("승"),
    lose("패"),
    draw("무승부");

    public String markResult;

    Result(String markResult) {
        this.markResult = markResult;
    }

}
