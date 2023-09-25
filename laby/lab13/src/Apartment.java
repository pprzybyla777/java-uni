import java.time.LocalDate;

final public class Apartment extends Offer {

    private int floorNumber;
    private int apartmentNumber;

    public Apartment(String street, String buildingNumber, String locality, String postcode, float livingSpace, float price, LocalDate endDate, int floorNumber, int apartmentNumber) {
        super(street, buildingNumber, locality, postcode, livingSpace, price, endDate);
        this.floorNumber = floorNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return """
                street: %s,
                buildingNumber: %s,
                floorNumber: %d,
                apartmentNumber: %d,
                locality: %s,
                postcode: %s,
                livingSpace: %.4f,
                price: %.2f
                end time: %tD,
               """.formatted(getStreet(), getBuildingNumber(), getFloorNumber(), getApartmentNumber(), getLocality(), getPostcode(), getLivingSpace(), getPrice(), getEndDate());
    }

}

