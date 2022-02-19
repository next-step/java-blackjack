package rentcar.view;

import java.util.Map;
import rentcar.domain.Report;

public class ReportView {

    private static final String MESSAGE = "%s : %.2f 리터";

    public static void generateReport(Report report) {
        Map<String, Double> reportMap = report.getReport();
        for (String carName : reportMap.keySet()) {
            System.out.printf((MESSAGE) + "%n", carName, reportMap.get(carName));
        }
    }
}
