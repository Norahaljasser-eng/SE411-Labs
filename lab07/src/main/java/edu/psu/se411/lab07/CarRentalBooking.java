package edu.psu.se411.lab07;

import java.time.LocalDate;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;

public class CarRentalBooking extends Booking {

    private final double dailyRate;
    private Integer rentalDays;

    public CarRentalBooking(String bookingId, String customerFullName,
                            LocalDate travelDate, String destinationCity,
                            double dailyRate)
            throws InvalidArgumentException {

        super(bookingId, customerFullName, travelDate, destinationCity);

        if (!Double.isFinite(dailyRate) || dailyRate < 0) {
            throw new InvalidArgumentException(
                "Daily rental rate must be finite and non-negative.");
        }

        this.dailyRate = dailyRate;
    }

    public void setRentalDays(int rentalDays)
            throws InvalidArgumentException {

        validateRange(rentalDays,
                      GlobalConfig.MIN_RENTAL_DAYS,
                      GlobalConfig.MAX_RENTAL_DAYS,
                      "Rental days");

        this.rentalDays = rentalDays;
    }

    @Override
    public double calculateTotalPrice() throws MissingInformationException {

        if (rentalDays == null) {
            throw new MissingInformationException(
                "Number of rental days has not been provided.");
        }

        return dailyRate * rentalDays;
    }
}