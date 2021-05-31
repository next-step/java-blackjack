package study;


public class Car {
    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            return new Car(name, position + 1);
        }
        return this;//불변이기 때문에 가능 //new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
