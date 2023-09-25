import java.time.LocalDate;

final public class House extends Offer {

    private float landArea;

    public House(String street, String buildingNumber, String locality, String postcode, float livingSpace, float price, LocalDate endDate, float landArea) {
        super(street, buildingNumber, locality, postcode, livingSpace, price, endDate);
        this.landArea = landArea;
    }


    public float getLandArea() {
        return landArea;
    }

    public void setLandArea(float landArea) {
        this.landArea = landArea;
    }

    @Override
    public String toString() {
        return """
                street: %s,
                buildingNumber: %s,
                locality: %s,
                postcode: %s,
                livingSpace: %.4f,
                landArea: %.4f,
                price: %.2f
                end time: %tD,
               """.formatted(getStreet(), getBuildingNumber(), getLocality(), getPostcode(), getLivingSpace(), getLandArea(), getPrice(), getEndDate());
    }
}