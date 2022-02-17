package rentcar.domain;

public abstract class Car implements Reportable {

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

    @Override
    public String generateReport() {
        return getName() + " : " + (int) getChargeQuantity() + "리터";
    }
}
