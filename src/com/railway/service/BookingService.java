package com.railway.service;

import java.util.ArrayList;

import com.railway.exception.BookingException;
import com.railway.exception.InvalidPassengerException;
import com.railway.exception.SeatNotAvailableException;
import com.railway.model.Booking;
import com.railway.model.Passenger;
import com.railway.model.Train;

public class BookingService {

    private ArrayList<Booking> bookings;

    private int nextBookingId = 1001;

    public BookingService() {

        bookings = new ArrayList<>();
    }

    public Booking createBooking(
            Passenger passenger,
            Train train,
            int numberOfSeats) throws BookingException {

        if (passenger == null) {

            throw new InvalidPassengerException(
                    "Passenger cannot be null.");
        }

        if (train == null) {

            throw new BookingException(
                    "Train not found.");
        }

        if (numberOfSeats <= 0) {

            throw new BookingException(
                    "Number of seats must be greater than zero.");
        }

        if (train.getAvailableSeats() < numberOfSeats) {

            throw new SeatNotAvailableException(
                    "Not enough seats available.");
        }

        Booking booking = new Booking(
                nextBookingId++,
                passenger,
                train,
                numberOfSeats,
                "PENDING");

        booking.confirmBooking();

        bookings.add(booking);

        return booking;
    }

    public void cancelBooking(int bookingId)
            throws BookingException {

        Booking booking = findBooking(bookingId);

        if (booking == null) {

            throw new BookingException(
                    "Booking not found.");
        }

        if (booking.getBookingStatus()
                .equals("CANCELLED")) {

            throw new BookingException(
                    "Booking is already cancelled.");
        }

        trainReturnSeats(booking);

        booking.setBookingStatus("CANCELLED");

        System.out.println(
                "Booking cancelled successfully.");
    }

    private void trainReturnSeats(Booking booking) {

        booking.getTrain()
                .cancelSeats(booking.getNumberOfSeats());
    }

    public Booking findBooking(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {

                return booking;
            }
        }

        return null;
    }

    public void displayAllBookings() {

        if (bookings.isEmpty()) {

            System.out.println(
                    "No bookings available.");

            return;
        }

        System.out.println(
                "\n========== ALL BOOKINGS ==========");

        for (Booking booking : bookings) {

            booking.displayBookingDetails();
        }
    }

    public ArrayList<Booking> getBookings() {

        return bookings;
    }
}