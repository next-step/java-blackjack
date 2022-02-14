package rentcar;

public interface MotorVehicle {
    /**
     * 리터당 이동 거리 반환
     * @return double
     */
    double getDistancePerLiter();

    /**
     * 주입해야 할 연료량 반환
     * @return double
     */
    double getChargeQuantity();
}
