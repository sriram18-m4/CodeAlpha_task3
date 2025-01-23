import java.util.Scanner;

public class HotelReservationSystem {
    // Types of Rooms and their availability
    private static String[]roomtypes = { "Single", "Double", "Suite" };
    private static boolean[] isRoomAvailable = { true, true, true };
    private static String[] customer = new String[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the Hotel Sir/Madam.");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println(
                            "Thank you for choosing the Hotel Reservation System");
                    break;
                default:
                    System.out.println("Incorrect option,Please try again.");
            }
        } while (option != 4);
        scanner.close();
    }

    // Method for availability of Rooms
    private static void searchAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (int i = 0; i <roomtypes.length; i++) {
            if (isRoomAvailable[i]) {
                System.out.println(roomtypes[i] + " Room Available");
            } else {
                System.out.println(roomtypes[i] + " Rooms unavailable");
            }
        }
    }

    // Method for reservation
    private static void makeReservation(Scanner scanner) {
        System.out.println("\n--- Make a Reservation ---");
        System.out.print("Enter the room number you want to book (1 for Single, 2 for Double, 3 for Suite): ");
        int roomvalue = scanner.nextInt();

        if (roomvalue < 1 || roomvalue >roomtypes.length) {
            System.out.println("No room number found, Please try again.");
            return;
        }

        if (!isRoomAvailable[roomvalue - 1]) {
            System.out.println("Sorry, this room is already booked.");
            return;
        }

        System.out.print("Enter your name to book the room: ");
        scanner.nextLine(); // Consume the newline
        String name = scanner.nextLine();

        isRoomAvailable[roomvalue - 1] = false;
        customer[roomvalue - 1] = name;

        System.out.println("Room " +roomtypes[roomvalue - 1] + " successfully booked by " + name + ".");
    }

    // Method for displaying Booking Details
    private static void viewBookingDetails() {
        System.out.println("\n--- Booking Details ---");
        for (int i = 0; i <roomtypes.length; i++) {
            if (!isRoomAvailable[i]) {
                System.out.println(roomtypes[i] + " Room  Booked by " + customer[i]);
            } else {
                System.out.println(roomtypes[i] + " Room  Available");
            }
        }
    }
}