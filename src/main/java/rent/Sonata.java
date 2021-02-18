package rent;

public class Sonata extends Car {

    private final static Integer RATING = 10;
    private final static String NAME = "Sonata";

    public Sonata(int distance) {
        super(distance, RATING, NAME);
    }
}
