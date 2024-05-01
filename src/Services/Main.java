package Services;

import Users.manager;
import Users.Customer;
import Users.Receptionist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	//Create tables
    	Tables table1 = new Tables (3);
    	Tables table2 = new Tables (4);
    	Tables table3 = new Tables (5);
    	Tables table4 = new Tables (2);
    	ArrayList <Tables> tables = new ArrayList <Tables>(); 
    	tables.add(table1);
    	tables.add(table2);
    	tables.add(table3);
    	tables.add(table4);
    	
        // Create menu items
        Menu_items item1 = new Menu_items("Main Course", "Spaghetti", 10);
        Menu_items item2 = new Menu_items( "Main dishes", "Pizza", 12);
        Menu_items item3 = new Menu_items( "Salads", "Salad", 6);

        // Create a menu
        Menu menu = new Menu();
        manager managerInstance = new manager("John Doe", "manager", "password", "manager",1205495697);
        menu.addItem(item1);
        menu.addItem(item2);
        menu.addItem(item3);
       
        // Display menu
        Collections.sort(menu.getItems());
        System.out.println("Menu:");
        
        for (Menu_items item : menu.getItems()) {
        	System.out.println(item.getDishName() + " - $" + item.getPrice());
        }
       
        
        // Create a customer
        Customer customer1 = new Customer("John Doe", "johndoe1", "password", "customer", 123456789);
        Customer customer2= new Customer("Hazem", "hazem", "hazem2", "customer", 123456689);
        Customer customer3 = new Customer("Michael", "michael", "michael3", "customer", 123445789);

        
        // Create a reservation
        LocalDateTime reservationDateTime = LocalDateTime.now().plusDays(1);
        Reservation reservation = new Reservation(customer1, reservationDateTime, 4);

        // Receptionist creates a reservation
        Receptionist receptionist = new Receptionist("Receptionist", "receptionist", "password", "receptionist", 987654321);
        Receptionist.set_tables(tables);
        receptionist.createReservation(customer1, reservationDateTime, 4);

        // Display reservations
        System.out.println("\nReservations:");
        for (Reservation res : receptionist.getReservations()) {
            System.out.println(res.getCustomer().getName() + " - " + res.getReservationDateTime() + " - " + res.getNumberOfPeople() + " people");
       }
        
        
        // Customer checks in
        customer1.checkIn();
        
        customer1.addToOrder(item3, 2);
        customer1.addToOrder(item2, 1);
        customer1.placeOrder("Cash");
        customer1.getBill().pay();

  /*      // Customer places an order
        OrderItem orderItem1 = new OrderItem(item1, 2);
        OrderItem orderItem2 = new OrderItem(item2, 1);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        Order order = new Order(1, "John Doe");
        order.setItems(orderItems);*/

        // Display order details
        /*System.out.println("\nOrder Details:");
        for (OrderItem orderItem : order.getItems()) {
            System.out.println(orderItem.getMenuItem().getDishName() + " - Quantity: " + orderItem.getQuantity());
        }*/

        // Customer checks out
        customer1.checkOut();

       

        
     
        receptionist.remove_object(customer1);
    }
}
