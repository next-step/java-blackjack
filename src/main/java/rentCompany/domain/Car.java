package rentCompany.domain;

public abstract class Car {

    protected String name;
    protected double tripDistance;

    protected Car(String name, int distance) {
        this.name = name;
        this.tripDistance = distance;
    }

    /**
     * 리터당 이동 거리. 즉, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 여행하려는 거리
     */
    abstract double getTripDistance();

    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}