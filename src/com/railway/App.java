package com.railway;

import java.util.Scanner;

import com.railway.exception.BookingException;
import com.railway.model.Booking;
import com.railway.model.Passenger;
import com.railway.model.Payment;
import com.railway.model.Ticket;
import com.railway.model.Train;
import com.railway.payment.CardPayment;
import com.railway.payment.CashPayment;
import com.railway.payment.Payable;
import com.railway.payment.UpiPayment;
import com.railway.service.BookingService;
import com.railway.service.PaymentService;
import com.railway.service.TrainService;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    private static TrainService trainService =
            new TrainService();

    private static BookingService bookingService =
            new BookingService();

    private static PaymentService paymentService =
            new PaymentService();

    public static void main(String[] args) {

        loadSampleTrains();

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    trainService.displayAllTrains();
                    break;

                case 2:
                    searchTrain();
                    break;

                case 3:
                    createBooking();
                    break;

                case 4:
                    bookingService.displayAllBookings();
                    break;

                case 5:
                    cancelBooking();
                    break;

                case 6:
                    makePayment();
                    break;

                case 7:
                    generateTicket();
                    break;

                case 8:
                    running = false;
                    System.out.println(
                            "Thank you for using Railway Reservation System.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n================================");
        System.out.println("   RAILWAY RESERVATION SYSTEM");
        System.out.println("================================");

        System.out.println("1. Display All Trains");
        System.out.println("2. Search Train");
        System.out.println("3. Book Ticket");
        System.out.println("4. Display All Bookings");
        System.out.println("5. Cancel Booking");
        System.out.println("6. Make Payment");
        System.out.println("7. Generate Ticket");
        System.out.println("8. Exit");

        System.out.print("Enter your choice: ");
    }

    private static void loadSampleTrains() {

        trainService.addTrain(
                new Train(
                        1234,
                        "Vande Bharat",
                        "Pune",
                        "Mumbai",
                        50));

        trainService.addTrain(
                new Train(
                        1235,
                        "Deccan Express",
                        "Pune",
                        "Mumbai",
                        100));

        trainService.addTrain(
                new Train(
                        1236,
                        "Rajdhani Express",
                        "Mumbai",
                        "Delhi",
                        80));
    }

    private static void searchTrain() {

        System.out.print("Enter source: ");
        String source = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        trainService.searchTrain(
                source,
                destination);
    }

    private static void createBooking() {

        try {

            System.out.print("Enter train number: ");
            int trainNumber = scanner.nextInt();
            scanner.nextLine();

            Train train =
                    trainService.findTrain(trainNumber);

            if (train == null) {

                System.out.println(
                        "Train not found.");

                return;
            }

            System.out.print("Enter passenger name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter number of seats: ");
            int seats = scanner.nextInt();
            scanner.nextLine();

            Passenger passenger =
                    new Passenger(
                            101,
                            name,
                            email,
                            phone,
                            201,
                            age,
                            gender);

            Booking booking =
                    bookingService.createBooking(
                            passenger,
                            train,
                            seats);

            System.out.println(
                    "\nBooking successful!");

            booking.displayBookingDetails();

        } catch (BookingException e) {

            System.out.println(
                    "Booking failed: "
                            + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                    "Invalid input.");
            scanner.nextLine();
        }
    }

    private static void cancelBooking() {

        try {

            System.out.print(
                    "Enter booking ID: ");

            int bookingId =
                    scanner.nextInt();

            scanner.nextLine();

            bookingService.cancelBooking(
                    bookingId);

        } catch (BookingException e) {

            System.out.println(
                    "Cancellation failed: "
                            + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                    "Invalid input.");
            scanner.nextLine();
        }
    }

    private static void makePayment() {

        try {

            System.out.print(
                    "Enter booking ID: ");

            int bookingId =
                    scanner.nextInt();

            scanner.nextLine();

            Booking booking =
                    bookingService.findBooking(
                            bookingId);

            if (booking == null) {

                System.out.println(
                        "Booking not found.");

                return;
            }

            if (!booking.getBookingStatus()
                    .equals("CONFIRMED")) {

                System.out.println(
                        "Payment cannot be processed for this booking.");

                return;
            }

            double amount =
                    booking.getNumberOfSeats()
                            * 500;

            Payment payment =
                    new Payment(
                            5001,
                            amount);

            System.out.println(
                    "\nSelect Payment Method:");

            System.out.println("1. UPI");
            System.out.println("2. Card");
            System.out.println("3. Cash");

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            Payable paymentMethod;

            switch (choice) {

                case 1:
                    paymentMethod =
                            new UpiPayment();
                    break;

                case 2:
                    paymentMethod =
                            new CardPayment();
                    break;

                case 3:
                    paymentMethod =
                            new CashPayment();
                    break;

                default:
                    System.out.println(
                            "Invalid payment method.");
                    return;
            }

            paymentService.processPayment(
                    payment,
                    paymentMethod);

        } catch (Exception e) {

            System.out.println(
                    "Payment failed: "
                            + e.getMessage());

            scanner.nextLine();
        }
    }

    private static void generateTicket() {

        try {

            System.out.print(
                    "Enter booking ID: ");

            int bookingId =
                    scanner.nextInt();

            scanner.nextLine();

            Booking booking =
                    bookingService.findBooking(
                            bookingId);

            if (booking == null) {

                System.out.println(
                        "Booking not found.");

                return;
            }

            Ticket ticket =
                    new Ticket(
                            5001,
                            booking);

            ticket.displayTicket();

        } catch (Exception e) {

            System.out.println(
                    "Unable to generate ticket.");
        }
    }
}