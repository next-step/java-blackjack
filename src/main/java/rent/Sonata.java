package rent;

public class Sonata extends Car {
    private final static String NAME = "Sonata";
    private final static int RATING = 10;

    public Sonata(int distance) {
        super(distance, RATING, NAME);
    }
}
