# 🚆 Railway Reservation System

A **console-based Railway Reservation System** built using Core Java and Object-Oriented Programming (OOP) principles. The project simulates essential railway reservation operations, including passenger management, train and seat management, booking, ticket generation, and payment processing.

## 📌 Features

- **Passenger Management** — Store and manage passenger details.
- **Train Management** — Manage train information and seat availability.
- **Booking Management** — Handle ticket bookings, cancellations, and booking status.
- **Ticket Generation** — Generate ticket details for bookings.
- **Payment Processing** — Support UPI, card, and cash payment implementations.
- **Input Validation** — Validate booking and passenger information.
- **Custom Exception Handling** — Handle application-specific errors.
- **Menu-Driven Interface** — Interact with the application through a console menu.

## 🛠️ Technologies Used

- **Language:** Java
- **Core Concepts:** OOP, Encapsulation, Inheritance, Abstraction, Polymorphism
- **Interfaces:** Payment interface and multiple payment implementations
- **Exception Handling:** Custom exceptions
- **Version Control:** Git and GitHub

## 📂 Project Structure

```text
src/
└── com/
    └── railway/
        ├── App.java
        ├── exception/
        │   ├── BookingException.java
        │   ├── InvalidPassengerException.java
        │   └── SeatNotAvailableException.java
        ├── model/
        │   ├── Booking.java
        │   ├── Passenger.java
        │   ├── Payment.java
        │   ├── Ticket.java
        │   ├── Train.java
        │   └── User.java
        ├── payment/
        │   ├── CardPayment.java
        │   ├── CashPayment.java
        │   ├── Payable.java
        │   └── UpiPayment.java
        └── service/
            ├── BookingService.java
            ├── PaymentService.java
            └── TrainService.java
```

## 🧠 OOP Concepts Applied

- **Encapsulation:** Protecting object data using fields and methods.
- **Inheritance:** Reusing common user properties in related classes.
- **Abstraction:** Defining payment behavior through an interface.
- **Polymorphism:** Supporting different payment implementations through a common payment contract.
- **Composition and Object Relationships:** Connecting passengers, trains, bookings, tickets, and payments.

## ▶️ How to Run

### Prerequisites

- Java Development Kit (JDK) installed.
- Visual Studio Code or another Java-compatible IDE.

### Run the Application

1. Clone this repository:

   ```bash
   git clone https://github.com/pratik-712/Railway-Reservation-System-OOPs-Application.git
   ```

2. Open the project folder in your IDE.

3. Compile the Java source files from the project root:

   ```bash
   javac -d out src/com/railway/*.java src/com/railway/model/*.java src/com/railway/service/*.java src/com/railway/payment/*.java src/com/railway/exception/*.java
   ```

4. Run the application:

   ```bash
   java -cp out com.railway.App
   ```

## 🎯 Project Objective

The objective of this project is to apply Core Java and OOP concepts to a practical application while developing skills in class design, business logic, validation, exception handling, and code organization.

## 🔮 Future Enhancements

- Persistent storage using a database or file handling.
- A graphical user interface or web interface.
- User authentication and role-based access.
- Improved search and train scheduling features.

## 👨‍💻 Author

**Pratik Labade**

GitHub: [@pratik-712](https://github.com/pratik-712)

---

*Developed as a Core Java and Object-Oriented Programming project.*
