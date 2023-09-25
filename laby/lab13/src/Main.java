import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("1 - Add House offer");
        System.out.println("2 - Add Apartment offer");
        System.out.println("3 - Show current house offers");
        System.out.println("4 - Show current apartment offers");
        System.out.println("5 - Show current house offers at given locality and living area not less than given");
        System.out.println("6 - Show current apartment offers at given locality no expensive than given value and from the given floors upwards");
        System.out.println("7 - exit");
    }

    private static void addHouseOffer(OfferList offerList, Scanner scanner) {
        House house = createHouseOffer(scanner);
        offerList.addOffer(house);
        System.out.println("New house offer has been added!");
    }

    private static void addApartmentOffer(OfferList offerList, Scanner scanner) {
        Apartment apartment = createApartmentOffer(scanner);
        offerList.addOffer(apartment);
        System.out.println("New apartment offer has been added!");
    }

    private static House createHouseOffer(Scanner scanner) {
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("Building number: ");
        String buildingNumber = scanner.nextLine();
        System.out.print("Locality: ");
        String locality = scanner.nextLine();
        System.out.print("Postcode: ");
        String postcode = scanner.nextLine();
        System.out.print("Living space: ");
        float livingSpace = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Land area: ");
        float landArea = scanner.nextFloat();
        scanner.nextLine();
        LocalDate endDate = null;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.print("Offer ending date (YYYY-MM-DD): ");
                endDate = LocalDate.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use YYYY-MM-DD format.");
            }
        }
        return new House(street, buildingNumber, locality, postcode, livingSpace, price, endDate, landArea);
    }

    private static Apartment createApartmentOffer(Scanner scanner) {
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("Building number: ");
        String buildingNumber = scanner.nextLine();
        System.out.print("Locality: ");
        String locality = scanner.nextLine();
        System.out.print("Postcode: ");
        String postcode = scanner.nextLine();
        System.out.print("Living space: ");
        float livingSpace = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Floor number: ");
        int floorNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Apartment number: ");
        int apartmentNumber = scanner.nextInt();
        scanner.nextLine();
        LocalDate endDate = null;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.print("Offer ending date (YYYY-MM-DD): ");
                endDate = LocalDate.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use YYYY-MM-DD format.");
            }
        }
        return new Apartment(street, buildingNumber, locality, postcode, livingSpace, price, endDate, floorNumber, apartmentNumber);
    }

    private static void displayOffers(ArrayList<Offer> offers) {
        for (Offer offer : offers) {
            System.out.println("---");
            System.out.println(offer);
        }
    }

    private static void showCurrentHouseOffers(OfferList offerList) {
        ArrayList<Offer> currentOffers = offerList.getOffers(offer -> offer instanceof House && !offer.getEndDate().isBefore(LocalDate.now()));
        displayOffers(currentOffers);
    }

    private static void showCurrentApartmentOffers(OfferList offerList) {
        ArrayList<Offer> currentOffers = offerList.getOffers(offer -> offer instanceof Apartment && !offer.getEndDate().isBefore(LocalDate.now()));
        displayOffers(currentOffers);
    }

    private static void showCurrentHouseOffersAtGivenLocalityAndLivingAreaNotLessThanGiven(OfferList offerList, Scanner scanner) {
        System.out.print("Locality: ");
        String locality = scanner.nextLine();
        System.out.print("Living space not less than: ");
        float livingSpace = scanner.nextFloat();
        scanner.nextLine();
        ArrayList<Offer> filteredOffers = offerList.getOffers(offer -> offer instanceof House && !offer.getEndDate().isBefore(LocalDate.now()) && offer.getLocality().equals(locality) && offer.getLivingSpace() >= livingSpace );
        displayOffers(filteredOffers);
    }

    private static void showCurrentApartmentOffersAtGivenLocalityNoExpensiveThanGivenValueAndFromTheGivenFloorsUpwards(OfferList offerList, Scanner scanner) {
        System.out.print("Locality: ");
        String locality = scanner.nextLine();

        System.out.print("Price not more than: ");
        float price = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Floor number from and upwards: ");
        int floorNumber = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Offer> filteredOffers = offerList.getOffers(offer -> offer instanceof Apartment && !offer.getEndDate().isBefore(LocalDate.now()) && offer.getLocality().equals(locality) && offer.getPrice() <= price && ((Apartment) offer).getFloorNumber() >= floorNumber);
        displayOffers(filteredOffers);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OfferList offerList = new OfferList();
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            System.out.print("Choose option (1 - 8): ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (option) {
                case 1 -> addHouseOffer(offerList, scanner);
                case 2 -> addApartmentOffer(offerList, scanner);
                case 3 -> showCurrentHouseOffers(offerList);
                case 4 -> showCurrentApartmentOffers(offerList);
                case 5 -> showCurrentHouseOffersAtGivenLocalityAndLivingAreaNotLessThanGiven(offerList, scanner);
                case 6 -> showCurrentApartmentOffersAtGivenLocalityNoExpensiveThanGivenValueAndFromTheGivenFloorsUpwards(offerList, scanner);
                case 7 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}