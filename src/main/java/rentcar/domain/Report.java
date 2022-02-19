package rentcar.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Report {

    private final Map<String, Double> report;

    public Report() {
        this.report = new ConcurrentHashMap<>();
    }

    public void putDetails(final Car car) {
        String carName = car.getCarName();
        double chargeQuantity = car.getChargeQuantity();
        report.put(carName, chargeQuantity);
    }

    public Map<String, Double> getReport() {
        return this.report;
    }
}
