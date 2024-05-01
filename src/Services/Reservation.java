package Services;
import java.time.LocalDateTime;

import Users.Customer;
public class Reservation  {
	
	private Customer customer;
    private LocalDateTime reservationDateTime;
    private int numberOfPeople;

    public Reservation(Customer customer, LocalDateTime reservationDateTime, int numberOfPeople) {
        this.customer = customer;
        this.reservationDateTime = reservationDateTime;
        this.numberOfPeople = numberOfPeople;
    }

   
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", reservationDateTime=" + reservationDateTime +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }



}
