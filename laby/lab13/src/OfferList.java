import java.util.ArrayList;
import java.util.function.Predicate;

public class OfferList {

    private final ArrayList<Offer> offers = new ArrayList<>();

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public ArrayList<Offer> getOffers(Predicate<Offer> condition) {
        ArrayList<Offer> result = new ArrayList<>();

        for (Offer offer : offers) {
            if (condition.test(offer)) {
                result.add(offer);
            }
        }

        return result;
    }

}
