package domain;

abstract class Factory {

    public final RentCompany create() {
        RentCompany company = createRentCompany();
        return company;
    }

    protected abstract RentCompany createRentCompany();
}
