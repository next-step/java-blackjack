package rentcar.view;

import java.util.Map;

public class ReportView {

    private static final String MESSAGE = "%s : %.2f 리터";

    public static void generateReport(Map<String, Double> report) {
        for (String carName : report.keySet()) {
            System.out.printf((MESSAGE) + "%n", carName, report.get(carName));
        }
    }
}
