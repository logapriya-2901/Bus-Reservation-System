package Bus_res;    

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
    private String passengerName;
    private int busNo;
    private Date date; 
    private String departureCity;
    private String arrivalCity;
    private String startTime;
     //Stores the date of travel

    // Constructor for Booking
    Booking(Scanner sc) {
        System.out.println("Enter the name of passenger: ");
        passengerName = sc.nextLine(); 

        System.out.println("Enter the Bus No: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid Bus No:");
            sc.next(); 
        }
        busNo = sc.nextInt();
        sc.nextLine(); // ✅ Consume newline

        //  Date Validation
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Prevents invalid dates

        while (true) {
            System.out.println("Enter the date (dd-MM-yyyy): ");
            String dateInput = sc.next();
            try {
                date = dateFormat.parse(dateInput);

                // Get today's date (without time)
                Date today = dateFormat.parse(dateFormat.format(new Date()));
                if (date.before(today)) {
                    System.out.println("❌ The date entered is in the past. Please enter a future date.");
                } else {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("❌ Invalid date format. Please enter in dd-MM-yyyy format.");
            }
        }
    }
    
    public String getPassengerName() {
        return passengerName;
    }

    public int getBusNo() {
        return busNo;
    }

    public Date getDate() {
        return date;
    }
    
    public String getArrivalCity() {
        return arrivalCity;
    }
    public String getDepartureCity() {
        return departureCity;
    }
    public String getStartTime() {
        return startTime;
    }
    
    
    
    

    //  Check if seats are available
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;

        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
                break;
            }
        }

        int alreadyBooked = 0;
        for (Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) {
                alreadyBooked++;
            }
        }

        return alreadyBooked < capacity;
    }
    
    

    //  Cancel Booking
    public static void cancelBooking(Scanner sc, ArrayList<Booking> bookings) {
        if (bookings.isEmpty()) {
            System.out.println("❌ No bookings available to cancel.");
            return;
        }

        System.out.println("Enter the name of the passenger: ");
        String name = sc.nextLine().trim();

        System.out.println("Enter the Bus No: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid Bus No:");
            sc.next();
        }
        int busNumber = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter the date of travel (dd-MM-yyyy): ");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date cancelDate;
        
        try {
            cancelDate = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("❌ Invalid date format. Cancellation failed.");
            return;
        }

        //Find and remove the booking
        Iterator<Booking> iterator = bookings.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.passengerName.equalsIgnoreCase(name) && 
                booking.busNo == busNumber && 
                booking.date.equals(cancelDate)) {
                
                iterator.remove(); // ✅ Remove the booking
                System.out.println("✅ Booking for " + name + " on Bus No " + busNumber + " for " + dateInput + " has been cancelled.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ No matching booking found. Please check the details.");
        }
    }
}
