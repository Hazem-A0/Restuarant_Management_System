package Users;
import Services.Tables;
import Services.Removable;
import Services.Reservation;

import java.time.LocalDateTime;
import java.util.*;


public class Receptionist extends Users implements Removable{
	private static ArrayList<Tables> tables;
    private ArrayList<Reservation> reservations;
    
	public Receptionist(String name, String userName, String password, String role, int contactNumber) {
		super(name, userName, password, role, contactNumber);
		this.tables = tables;
        this.reservations = new ArrayList<>();
	}

	public static void set_tables (ArrayList<Tables> tables)
	{
		Receptionist.tables=tables;
	}
	 public void createReservation(Customer customer_name, LocalDateTime dateTime, int numSeats) {
	        if (tablesAvailable(numSeats)) {
	            Reservation reservation = new Reservation(customer_name, dateTime, numSeats);
	            reservations.add(reservation);
	            System.out.println("Reservation created successfully for " + customer_name.getName() + " at " + dateTime);
	        } else {
	            System.out.println("Sorry, not enough tables available for the requested number of seats.");
	        }
	    }
	 private boolean tablesAvailable(int numSeats) {
	        for (Tables table : tables) {
	            if (!table.isIsbooked() && table.getNum_of_Seats() >= numSeats) {
	                return true;
	            }
	        }
	        return false;
	    }
	 public ArrayList<Tables> getAvailableTables() {
	        ArrayList<Tables> availableTables = new ArrayList<>();
	        for (Tables table : tables) {
	            if (!table.isIsbooked()) {
	                availableTables.add(table);
	            }
	        }
	        return availableTables;
	    }
    
	 /*public void cancelReservation(Customer customer) {
	        if (reservations.contains(reservation)) {
	            reservations.remove(reservation);
	            System.out.println("Reservation cancelled successfully.");
	        } else {
	            System.out.println("Reservation not found.");
	        }
	    }*/
	 public void remove_object (Object customer) {
	 boolean reservationCanceled = false;
	    Iterator<Reservation> iterator = reservations.iterator();
	    while (iterator.hasNext()) {
	        Reservation reservation = iterator.next();
	        if (reservation.getCustomer().equals((Customer)customer)) {
	            iterator.remove();
	            reservationCanceled = true;
	            System.out.println("Reservation canceled successfully for " + ((Customer) customer).getName());
	        }
	    }
	    if (!reservationCanceled) {
	        System.out.println("No reservations found for " + ((Customer)customer).getName() + ". Unable to cancel.");
	    }
	 }
	 
	 public List<Reservation> getReservations() {
	        return reservations;
	    }

	@Override
	public void displayInfo() {
		
		super.displayInfo();
	}

}
