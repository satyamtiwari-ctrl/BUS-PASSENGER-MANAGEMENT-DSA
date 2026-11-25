
import java.util.ArrayList;
import java.util.Scanner;

// Passenger class
class Passenger {
    private int passengerId;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String busName;
    private int seats;
    private double fare;
    private int ticketId;

    public Passenger(int passengerId, String name, int age,
                    String gender, String phone, String busName,
                    int seats, double fare, int ticketId) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.busName = busName;
        this.seats = seats;
        this.fare = fare;
        this.ticketId = ticketId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void display() {
        System.out.println("------------------------------------");
        System.out.println("Passenger ID : " + passengerId);
        System.out.println("Ticket ID    : " + ticketId);
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Phone        : " + phone);
        System.out.println("Bus          : " + busName);
        System.out.println("Seats        : " + seats);
        System.out.println("Total Fare   : Rs. " + fare);
        System.out.println("------------------------------------");
    }
}

// Main class
public class BusPassenger_Management_System {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Passenger> passengers = new ArrayList<>();

    static int passengerId = 1001;
    static int ticketId = 5001;

    static String busName = "Express Travels";
    static String busNumber = "CG-04-AB-1234";
    static String source = "Raipur";
    static String destination = "Delhi";
    static double farePerSeat = 800.0;

    // Display bus information
    static void displayBusInfo() {
        System.out.println("\n========= BUS INFORMATION =========");
        System.out.println("Bus Name       : " + busName);
        System.out.println("Bus Number     : " + busNumber);
        System.out.println("Source         : " + source);
        System.out.println("Destination    : " + destination);
        System.out.println("Fare Per Seat  : Rs. " + farePerSeat);
        System.out.println("=================================");
    }

    // Add passenger and book ticket
    static void bookTicket() {
        System.out.println("\n========= BOOK TICKET =========");

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = readInt();

        if (age <= 0) {
            System.out.println("Invalid age!");
            return;
        }

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter number of seats: ");
        int seats = readInt();

        if (seats <= 0) {
            System.out.println("Invalid seat number!");
            return;
        }

        double totalFare = seats * farePerSeat;

        Passenger p = new Passenger(
            passengerId,
            name,
            age,
            gender,
            phone,
            busName,
            seats,
            totalFare,
            ticketId
        );

        passengers.add(p);

        System.out.println("\nTicket booked successfully!");
        System.out.println("Passenger ID: " + passengerId);
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Total Fare: Rs. " + totalFare);

        passengerId++;
        ticketId++;
    }

    // Display all passengers
    static void viewPassengers() {
        System.out.println("\n========= PASSENGER LIST =========");

        if (passengers.isEmpty()) {
            System.out.println("No passengers found.");
            return;
        }

        for (Passenger p : passengers) {
            p.display();
        }
    }

    // Search passenger by ID
    static void searchPassenger() {
        System.out.print("\nEnter Passenger ID to search: ");
        int id = readInt();

        for (Passenger p : passengers) {
            if (p.getPassengerId() == id) {
                System.out.println("\nPassenger Found!");
                p.display();
                return;
            }
        }

        System.out.println("Passenger not found!");
    }

    // Cancel ticket
    static void cancelTicket() {
        System.out.print("\nEnter Ticket ID to cancel: ");
        int id = readInt();

        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getTicketId() == id) {
                passengers.remove(i);
                System.out.println("Ticket cancelled successfully!");
                return;
            }
        }

        System.out.println("Ticket ID not found!");
    }

    // Calculate total collection
    static void totalCollection() {
        double total = 0;

        for (Passenger p : passengers) {
            total += getFare(p);
        }

        System.out.println("\nTotal Ticket Collection: Rs. " + total);
    }

    // Menu
    static void displayMenu() {
        System.out.println("\n==================================");
        System.out.println(" BUS PASSENGER MANAGEMENT SYSTEM");
        System.out.println("==================================");
        System.out.println("1. Bus Information");
        System.out.println("2. Book Ticket");
        System.out.println("3. View All Passengers");
        System.out.println("4. Search Passenger");
        System.out.println("5. Cancel Ticket");
        System.out.println("6. Total Collection");
        System.out.println("7. Exit");
        System.out.println("----------------------------------");
        System.out.print("Enter your choice: ");
    }

    // Input helper
    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }

        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    // Get fare using passenger ticket information
    static double getFare(Passenger p) {
        // Fare is calculated from seat count and fixed fare.
        // The current passenger data stores total fare.
        return farePerSeat; 
    }

    // Main method
    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    displayBusInfo();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    viewPassengers();
                    break;

                case 4:
                    searchPassenger();
                    break;

                case 5:
                    cancelTicket();
                    break;

                case 6:
                    totalCollection();
                    break;

                case 7:
                    System.out.println("\nThank you for using Bus Passenger Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        
    }
}
