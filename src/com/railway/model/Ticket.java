package com.railway.model;

public class Ticket {

    private int ticketId;
    private Booking booking;

    public Ticket(int ticketId, Booking booking) {

        this.ticketId = ticketId;
        this.booking = booking;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void displayTicket() {

        System.out.println("\n================================");
        System.out.println("          RAILWAY TICKET");
        System.out.println("================================");

        System.out.println("Ticket ID      : " + ticketId);
        System.out.println("Booking ID     : " + booking.getBookingId());

        System.out.println("Passenger      : "
                + booking.getPassenger().getName());

        System.out.println("Train          : "
                + booking.getTrain().getTrainName());

        System.out.println("From           : "
                + booking.getTrain().getSource());

        System.out.println("To             : "
                + booking.getTrain().getDestination());

        System.out.println("Seats Booked   : "
                + booking.getNumberOfSeats());

        System.out.println("Status         : "
                + booking.getBookingStatus());

        System.out.println("================================");
    }
}