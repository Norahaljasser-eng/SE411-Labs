package edu.psu.se411.lab07;

import java.time.LocalDate;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;

public class App {

    private static final Logger logger =
        LoggerFactory.getLogger(App.class);

    public static double computeTotalPrice(Booking booking)
            throws MissingInformationException, InvalidArgumentException {

        return booking.calculateTotalPrice();
    }

    private static void printPrice(Booking booking) {
        try {
            double total = computeTotalPrice(booking);

            System.out.printf(
                Locale.US, "%s (%s): %.2f%n",
                booking.getBookingId(),
                booking.getClass().getSimpleName(),
                total);

        } catch (MissingInformationException | InvalidArgumentException e) {
            logger.error(
                "Price calculation failed for " + booking.getBookingId(), e);

            System.out.println(
                booking.getBookingId() + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.info("Application is starting...");

        try {
            LocalDate date = LocalDate.of(2026, 10, 15);

            FlightBooking flight = new FlightBooking(
                "F001", "Norah Aljasser", date, "Dubai", 1000, 20);

            TrainBooking standardTrain = new TrainBooking(
                "T001", "Sara Ahmed", date, "Dammam", SeatClass.STANDARD);

            TrainBooking firstClassTrain = new TrainBooking(
                "T002", "Lama Ali", date, "Dammam", SeatClass.FIRST_CLASS);

            CarRentalBooking car = new CarRentalBooking(
                "C001", "Maha Khalid", date, "Riyadh", 150);

            System.out.println("=== Missing information ===");

            printPrice(flight);
            printPrice(standardTrain);
            printPrice(car);

            System.out.println("\n=== Valid bookings ===");

            flight.setLuggageWeight(25);
            standardTrain.setDistance(400);
            firstClassTrain.setDistance(400);
            car.setRentalDays(3);

            Booking[] bookings = {
                flight, standardTrain, firstClassTrain, car
            };

            for (Booking booking : bookings) {
                printPrice(booking);
            }

            System.out.println("\n=== Invalid values ===");

            try {
                flight.setLuggageWeight(45);
            } catch (InvalidArgumentException e) {
                logger.error("Invalid luggage weight", e);
                System.out.println(e.getMessage());
            }

            try {
                standardTrain.setDistance(2500);
            } catch (InvalidArgumentException e) {
                logger.error("Invalid train distance", e);
                System.out.println(e.getMessage());
            }

            try {
                car.setRentalDays(31);
            } catch (InvalidArgumentException e) {
                logger.error("Invalid rental days", e);
                System.out.println(e.getMessage());
            }

        } catch (InvalidArgumentException e) {
            logger.error("Booking setup failed", e);
            System.out.println(e.getMessage());

        } finally {
            logger.info("Application is stopping...");
        }
    }
}