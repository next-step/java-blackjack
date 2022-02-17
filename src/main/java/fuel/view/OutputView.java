package fuel.view;

public class OutputView {

    private OutputView() {

    }

    public static void printReport(String report) {
        System.out.println(report);
    }

    public static void printSonataDistance() {
        System.out.println("소나타의 대략적인 이동거리를 입력해주세요.");
    }

    public static void printAvanteDistance() {
        System.out.println("아반테의 대략젹인 이동거리를 입력해주세요.");
    }

    public static void printK5Distance() {
        System.out.println("K5의 대략적인 이동거리를 입력해주세요.");
    }
}
