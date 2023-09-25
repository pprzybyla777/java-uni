import java.time.LocalDate;

sealed public abstract class Offer permits House, Apartment {

    private String street;
    private String buildingNumber;
    private String locality;
    private String postcode;
    private float livingSpace;
    private float price;
    private LocalDate endDate;

    public Offer(String street, String buildingNumber, String locality, String postcode, float livingSpace, float price, LocalDate endDate) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.locality = locality;
        this.postcode = postcode;
        this.livingSpace = livingSpace;
        this.price = price;
        this.endDate = endDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public float getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(float livingSpace) {
        this.livingSpace = livingSpace;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return """
                street: %s,
                buildingNumber: %s,
                locality: %s,
                postcode: %s,
                livingSpace: %.4f,
                price: %.2f
                end time: %tD,
               """.formatted(getStreet(), getBuildingNumber(), getLocality(), getPostcode(), getLivingSpace(), getPrice(), getEndDate());
    }

}