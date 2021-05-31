package RentCompany;

public abstract class RentCompany {
    public static final RentCompany create() {
        RentCompany rentCompany = new RentCompany() {
            @Override
            void addCar(Car car) {
                super.addCar(car);
            }
        };
        return rentCompany;
    }

    void addCar(Car car) {

    }

    public String generateReport() {
        return null;
    }
}
