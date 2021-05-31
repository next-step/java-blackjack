package RentCompany;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private String carName;
    private double liter;
    private String report = "";

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(AbstractCar car) {
        this.carName = car.getName();
        this.liter = car.getChargeQuantity();
        report += carName + " : " + (int) liter + "리터" + NEWLINE;
    }

    public String generateReport() {
        return report;
    }
}
