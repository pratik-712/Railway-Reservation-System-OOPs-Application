package com.railway.model;

public class Booking {

    private int bookingId;
    private Passenger passenger;
    private Train train;
    private int numberOfSeats;
    private String bookingStatus;

    public Booking(
            int bookingId,
            Passenger passenger,
            Train train,
            int numberOfSeats,
            String bookingStatus) {

        this.bookingId = bookingId;
        this.passenger = passenger;
        this.train = train;
        this.numberOfSeats = numberOfSeats;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public boolean confirmBooking() {

        if (train.bookSeats(numberOfSeats)) {

            bookingStatus = "CONFIRMED";
            return true;
        }

        bookingStatus = "FAILED";
        return false;
    }

    public void displayBookingDetails() {

        System.out.println("\n================================");
        System.out.println("       BOOKING DETAILS");
        System.out.println("================================");

        System.out.println("Booking ID     : " + bookingId);
        System.out.println("Passenger      : " + passenger.getName());
        System.out.println("Train          : " + train.getTrainName());
        System.out.println("From           : " + train.getSource());
        System.out.println("To             : " + train.getDestination());
        System.out.println("Seats          : " + numberOfSeats);
        System.out.println("Status         : " + bookingStatus);

        System.out.println("================================");
    }
}