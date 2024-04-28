package Services;

import Users.manager;
import Users.Customer;
import Users.Receptionist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create menu items
        Menu_items item1 = new Menu_items(1, "Spaghetti", "Pasta with tomato sauce", 10);
        Menu_items item2 = new Menu_items(2, "Pizza", "Italian pizza with toppings", 12);
        Menu_items item3 = new Menu_items(3, "Salad", "Fresh garden salad", 6);

        // Create a menu
        Menu menu = new Menu();
        manager managerInstance = new manager("John Doe", "manager", "password", "manager", 123456789);
        menu.addItem(item1, managerInstance);
        menu.addItem(item2, managerInstance);
        menu.addItem(item3, managerInstance);

        // Display menu
        System.out.println("Menu:");
        for (Menu_items menuItem : menu.getItems()) {
            System.out.println(menuItem.getTitle() + " - $" + menuItem.getPrice());
        }

        // Create a customer
        Customer customer = new Customer("John Doe", "johndoe", "password", "customer", 123456789, 1);

        // Customer checks in
        customer.checkIn();

        // Customer places an order
        OrderItem orderItem1 = new OrderItem(item1, 2);
        OrderItem orderItem2 = new OrderItem(item2, 1);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        Order order = new Order(1, "John Doe");
        order.setItems(orderItems);

        // Display order details
        System.out.println("\nOrder Details:");
        for (OrderItem orderItem : order.getItems()) {
            System.out.println(orderItem.getMenuItem().getTitle() + " - Quantity: " + orderItem.getQuantity());
        }

        // Customer checks out
        customer.checkOut();

        // Create a reservation
        LocalDateTime reservationDateTime = LocalDateTime.now().plusDays(1);
        Reservation reservation = new Reservation(customer, reservationDateTime, 4);

        // Receptionist creates a reservation
        Receptionist receptionist = new Receptionist("Receptionist", "receptionist", "password", "receptionist", 987654321);
        receptionist.createReservation(customer, reservationDateTime, 4);

        // Display reservations
        System.out.println("\nReservations:");
        for (Reservation res : receptionist.getReservations()) {
            System.out.println(res.getCustomer().getName() + " - " + res.getReservationDateTime() + " - " + res.getNumberOfPeople() + " people");
        }

        // Manager cancels a reservation
        Receptionist receptionist1 = new Receptionist("Manager", "manager", "password", "manager", 555555555);
        receptionist1.cancelReservation(reservation);
    }
}
