# IRCTC Backend System

A Java-based backend engine for a train booking system. It handles user registration, authentication, train search by route, seat reservation using a 2D matrix layout, and ticket lifecycle management using local JSON storage.

---

## Features

- **User Authentication**: User signup and login backed by jBCrypt password hashing.
- **Train Search**: Filter trains based on station route order (verifies source station appears prior to destination).
- **Seat Reservation**: Real-time seat allocation using a 2D seat matrix (0 for available, 1 for booked).
- **Ticket Management**: Unique ticket generation (UUID), active booking retrieval, and booking cancellation.
- **Local Persistence**: Automatic JSON serialization and deserialization using Jackson Databind.

---

## Architecture and Workflow

```text
                        +------------------------------+
                        |       CLI Application        |
                        |    (org.ticket_booking.App)  |
                        +--------------+---------------+
                                       |
                +----------------------+----------------------+
                |                                             |
                v                                             v
  +---------------------------+                 +---------------------------+
  |     UserBooking Service   |                 |    TrainService Engine    |
  | (Auth, Tickets, Bookings) |                 | (Route Search, Seats DB)  |
  +-------------+-------------+                 +-------------+-------------+
                |                                             |
                +----------------------+----------------------+
                                       |
                                       v
                       +------------------------------+
                       |   Local JSON Storage         |
                       |   (Users.json & trains.json) |
                       +------------------------------+
```

---

## Project Structure

```text
IRCTC backend/
├── app/
│   ├── build.gradle                   # Application dependencies and main class config
│   └── src/
│       └── main/
│           └── java/
│               └── org/
│                   └── ticket_booking/
│                       ├── App.java                     # Application entry point & CLI
│                       ├── Services/
│                       │   ├── TrainService.java        # Train search and seat management
│                       │   └── UserBooking.java         # Authentication and ticket operations
│                       ├── entities/
│                       │   ├── Ticket.java              # Ticket data model
│                       │   ├── Train.java               # Train data model (includes seat matrix)
│                       │   └── User.java                # User profile model
│                       ├── localDB/
│                       │   ├── Users.json               # JSON store for user data
│                       │   └── trains.json              # JSON store for train schedules & seats
│                       └── utils/
│                           └── UserServiceUtil.java     # Password hashing helper functions
├── build.gradle                       # Root build configuration
├── gradle/                            # Gradle wrapper directory
├── gradlew / gradlew.bat              # Gradle wrapper scripts
└── settings.gradle                    # Project settings
```

---

## Tech Stack

| Component | Technology | Version | Purpose |
| :--- | :--- | :--- | :--- |
| Runtime | Java | 21 | Core programming language |
| Build Tool | Gradle | 8.x | Dependency management and build framework |
| Security | jBCrypt | 0.4 | Salted password hashing |
| JSON Parser | Jackson Databind | 2.14.1 | JSON serialization/deserialization |
| Utility | Guava | Latest | Collection helpers and core utilities |

---

## Prerequisites and Setup

### Prerequisites

- Java Development Kit (JDK 21 or higher)
- Gradle (or use the included wrapper)

### Build and Run

1. Clone the repository:
   ```bash
   git clone https://github.com/KartikJoshi007/IRCTC_Backend_Project.git
   cd IRCTC_Backend_Project
   ```

2. Build the project:
   ```bash
   # Windows
   .\gradlew build

   # Linux / macOS
   ./gradlew build
   ```

3. Run the application:
   ```bash
   # Windows
   .\gradlew run --console=plain

   # Linux / macOS
   ./gradlew run --console=plain
   ```

---

## CLI Menu Interface

When launched, the application presents the following menu options:

```text
Running Train Booking System
Choose option
1. Sign up
2. Login
3. Fetch Bookings
4. Search Trains
5. Book a Seat
6. Cancel my Booking
7. Exit the App
```

### Menu Actions

1. **Sign Up**: Registers a new user with a hashed password saved to `Users.json`.
2. **Login**: Verifies credentials against stored user records.
3. **Fetch Bookings**: Displays active tickets associated with the currently logged-in account.
4. **Search Trains**: Prompts for source and destination stations to return matching train schedules.
5. **Book a Seat**: Displays the train seat grid and reserves a selected row and column.
6. **Cancel my Booking**: Removes a booking using the unique Ticket ID.
7. **Exit**: Closes the application.

---

## Future Scope

- Refactor into a Spring Boot REST API.
- Replace local JSON storage with a relational database (PostgreSQL / MySQL).
- Implement JWT-based session management.
- Add unit tests for `UserBooking` and `TrainService`.

---

## License

This project is licensed under the MIT License.
