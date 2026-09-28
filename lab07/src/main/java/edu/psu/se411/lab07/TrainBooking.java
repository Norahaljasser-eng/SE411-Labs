package edu.psu.se411.lab07;

import java.time.LocalDate;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;

public class TrainBooking extends Booking {

    private final SeatClass seatClass;
    private Double distance;

    public TrainBooking(String bookingId, String customerFullName,
                        LocalDate travelDate, String destinationCity,
                        SeatClass seatClass)
            throws InvalidArgumentException {

        super(bookingId, customerFullName, travelDate, destinationCity);

        if (seatClass == null) {
            throw new InvalidArgumentException("Seat class is required.");
        }

        this.seatClass = seatClass;
    }

    public void setDistance(double distance)
            throws InvalidArgumentException {

        validateRange(distance,
                      GlobalConfig.MIN_TRAIN_DISTANCE,
                      GlobalConfig.MAX_TRAIN_DISTANCE,
                      "Train distance");

        this.distance = distance;
    }

    @Override
    public double calculateTotalPrice() throws MissingInformationException {

        if (distance == null) {
            throw new MissingInformationException(
                "Train distance has not been provided.");
        }

        double rate = seatClass == SeatClass.STANDARD
            ? GlobalConfig.TRAIN_STANDARD_RATE
            : GlobalConfig.TRAIN_FIRST_CLASS_RATE;

        return distance * rate;
    }
}