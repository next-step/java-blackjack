package rentcar.view;

public class OutputView {
    private static final String INFO_REPORT_HEADER = "## 연료 확인 보고서";

    public static void printReport(String report) {
        System.out.println(INFO_REPORT_HEADER);
        System.out.println(report);
    }
}
