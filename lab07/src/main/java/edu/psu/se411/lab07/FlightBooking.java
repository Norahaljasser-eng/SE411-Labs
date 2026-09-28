package edu.psu.se411.lab07;

import java.time.LocalDate;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;

public class FlightBooking extends Booking {

    private final double basePrice;
    private final double includedLuggageWeight;
    private Double luggageWeight;

    public FlightBooking(String bookingId, String customerFullName,
                         LocalDate travelDate, String destinationCity,
                         double basePrice, double includedLuggageWeight)
            throws InvalidArgumentException {

        super(bookingId, customerFullName, travelDate, destinationCity);

        if (!Double.isFinite(basePrice) || basePrice < 0) {
            throw new InvalidArgumentException(
                "Base ticket price must be finite and non-negative.");
        }

        validateRange(includedLuggageWeight,
                      GlobalConfig.MIN_LUGGAGE_WEIGHT,
                      GlobalConfig.MAX_LUGGAGE_WEIGHT,
                      "Included luggage weight");

        this.basePrice = basePrice;
        this.includedLuggageWeight = includedLuggageWeight;
    }

    public void setLuggageWeight(double luggageWeight)
            throws InvalidArgumentException {

        validateRange(luggageWeight,
                      GlobalConfig.MIN_LUGGAGE_WEIGHT,
                      GlobalConfig.MAX_LUGGAGE_WEIGHT,
                      "Luggage weight");

        this.luggageWeight = luggageWeight;
    }

    @Override
    public double calculateTotalPrice() throws MissingInformationException {

        if (luggageWeight == null) {
            throw new MissingInformationException(
                "Luggage weight has not been provided.");
        }

        double extraWeight =
            Math.max(0, luggageWeight - includedLuggageWeight);

        double luggageCharge =
            extraWeight * GlobalConfig.EXTRA_LUGGAGE_RATE;

        return (basePrice + luggageCharge) * (1 + GlobalConfig.TAX_RATE);
    }
}