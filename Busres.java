package Bus_res;

import java.text.SimpleDateFormat;
import java.util.*;

public class Busres {
    public static void main(String[] args) {
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        Scanner sc = new Scanner(System.in); 

        // Added correct bus details
        buses.add(new Bus(1, true, 45,  "Aaditya", "Chennai",    "Palani", "8h 30m","09:00 PM",  1000.00));
        buses.add(new Bus(2, true, 50,  "Arjun",   "Coimbatore", "Trichy", "4h 35m","02:30 PM", 550.0));
        buses.add(new Bus(3, true, 40,  "Deepak",  "Palani",     "Chennai","9h 00m","04:30 AM", 1000.00));
        buses.add(new Bus(4, true, 45,  "Jishnu",  "Madurai",    "Erode",  "4h 15m","07:00 AM", 500.00));
        buses.add(new Bus(5, true, 55,  "Kishore", "Palani",     "Salem",  "3h 15m","06:30 PM", 380.00));
        
        


        // Display bus information
        System.out.println("\n🚍✨ Welcome to LP Travels! ✨🚍");
        System.out.println("🌍 Your journey, our priority! 🛣️💼");
        System.out.println("🚌 Safe, Comfortable & Hassle-Free Rides! 😊💺");
        System.out.println("🎟️ Book now & experience the best! 🚏💨");
        System.out.println("-------------------------------------------------");
        System.out.println("\n🚍 Available Buses:");
        
        for (Bus b : buses) {
            b.displayBusInfo();
        }

        int userOption = 0;

        while (true) {
            System.out.println("\n🔹 Choose an option:");
            System.out.println("1️ Book a Ticket");
            System.out.println("2️ Cancel a Ticket");
            System.out.println("3️ Exit");

            if (sc.hasNextInt()) {
                userOption = sc.nextInt();
                sc.nextLine(); //  Consume newline character

                if (userOption == 1) {
                    System.out.println("\n📌 Booking a Ticket...");
                    Booking booking = new Booking(sc);
                    if (booking.isAvailable(bookings, buses)) {
                        bookings.add(booking);
                        
                        // Fetch passenger details from booking
                        System.out.println("\n🎉 Your booking is confirmed!");
                        System.out.println("👤 Passenger Name: " + booking.getPassengerName()); // Correctly retrieving passenger name
                        System.out.println("🚌 Bus No: " + booking.getBusNo()); // Correctly retrieving bus number
                        System.out.println("📅 Date: " + new SimpleDateFormat("dd-MM-yyyy").format(booking.getDate())); // Correctly retrieving date
                        System.out.println("🚍 Have a safe and happy journey! 😊");
                        
                    } else {
                        System.out.println("❌ Sorry, there are no available seats.");
                        System.out.println("🔄 Try another bus or date.");
                    }
                } 
                else if (userOption == 2) {
                    Booking.cancelBooking(sc, bookings);
                } 
                else if (userOption == 3) {
                    System.out.println("\n✨ Thank you for using our Bus Reservation System! ✨");
                    break; 
                } 
                else {
                    System.out.println("⚠️ Invalid choice! Please enter 1, 2, or 3.");
                }
            } 
            else {
                System.out.println("⚠️ Invalid input. Please enter a numeric value.");
                sc.next(); // Consume invalid input
            }
        }

        sc.close();
    }
}
