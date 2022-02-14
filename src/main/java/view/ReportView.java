package view;

import java.util.Map;

public class ReportView {

    private static final String MESASGE = "%s : %.2f 리터";

    public static void generateReport(Map<String, Double> report) {
        for (String carName : report.keySet()) {
            System.out.println(String.format(MESASGE, carName, report.get(carName)));
        }
    }
}
