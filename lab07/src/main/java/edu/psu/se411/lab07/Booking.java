package edu.psu.se411.lab07;

import java.time.LocalDate;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;

public abstract class Booking {

    private final String bookingId;
    private final String customerFullName;
    private final LocalDate travelDate;
    private final String destinationCity;

    public Booking(String bookingId, String customerFullName,
                   LocalDate travelDate, String destinationCity) {
        this.bookingId = bookingId;
        this.customerFullName = customerFullName;
        this.travelDate = travelDate;
        this.destinationCity = destinationCity;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    protected void validateRange(double value, double minimum,
                                 double maximum, String field)
            throws InvalidArgumentException {

        if (!Double.isFinite(value) || value < minimum || value > maximum) {
            throw new InvalidArgumentException(
                field + " must be between " + minimum + " and " + maximum);
        }
    }

    public abstract double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException;
}