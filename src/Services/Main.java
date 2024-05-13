package Services;

import Users.manager;
import Users.Chef;
import Users.Customer;
import Users.Receptionist;
import Users.Users;
import Users.Waiter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import GUI.HomePage;
import GUI.SceneController;
import GUI.LoginPage;
import GUI.OrderPage;
import GUI.ReservationPage;

import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {

        public static void main(String[] args) {
                // add manager
                Users managerInstance = new manager("George", "george", "password", "manager", 1205495697, 20000);
                managerInstance.displayInfo();

                // add chef
                Users Main_Chef = new Chef("Hassan", "hassan", "chef_password", "Chef", 1205495697, 10000);
                Main_Chef.displayInfo();

                // add Waiter
                Users Waiter1 = new Waiter("Ibrahim", "ibrahim", "waiter_password", "Waiter", 1205495697, 5000);
                Main_Chef.displayInfo();

                // Create tables
                Tables table1 = new Tables(3);
                Tables table2 = new Tables(4);
                Tables table3 = new Tables(5);
                Tables table4 = new Tables(2);
                ArrayList<Tables> tables = new ArrayList<Tables>();
                tables.add(table1);
                tables.add(table2);
                tables.add(table3);
                tables.add(table4);

                // Create menu items
                Menu_items item1 = new Menu_items("Main Course", "Spaghetti", 10);
                Menu_items item2 = new Menu_items("Main dishes", "Pizza", 12);
                Menu_items item3 = new Menu_items("Salads", "Salad", 6);

                // Create a menu
                Menu menu = new Menu();
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
                Customer customer1 = new Customer("Hazem", "Hazem", "password", "customer", 123456789);
                Customer customer2 = new Customer("Amin", "Amin", "password", "customer", 123456689);
                Customer customer3 = new Customer("Michael", "michael", "michael3", "customer", 123445789);

                // Create a reservation
                LocalDateTime reservationDateTime = LocalDateTime.now().plusDays(1);
                Reservation reservation = new Reservation(customer1, reservationDateTime, 4);

                // Receptionist creates a reservation
                Receptionist receptionist = new Receptionist("Receptionist", "receptionist", "password", "receptionist",
                                987654321);
                Receptionist.set_tables(tables);
                receptionist.createReservation(customer1, reservationDateTime, 4);
                receptionist.createReservation(customer2, reservationDateTime, 5);

                // Remove the reservation using polymorphism
                Removable removable = receptionist; // Polymorphic reference
                removable.remove_object(customer1);

                // Display reservations
                System.out.println("\nReservations:");
                for (Reservation res : receptionist.getReservations()) {
                        System.out.println(res.getCustomer().getName() + " - " + res.getReservationDateTime() + " - "
                                        + res.getNumberOfPeople() + " people");
                }

                launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
                try {
                        // add manager

                        // Create tables
                        Tables table1 = new Tables(3);
                        Tables table2 = new Tables(4);
                        Tables table3 = new Tables(5);
                        Tables table4 = new Tables(2);
                        ArrayList<Tables> tables = new ArrayList<Tables>();
                        tables.add(table1);
                        tables.add(table2);
                        tables.add(table3);
                        tables.add(table4);

                        // Create menu items
                        Menu_items item1 = new Menu_items("Main Course", "Spaghetti", 10);
                        Menu_items item2 = new Menu_items("Main dishes", "Pizza", 12);
                        Menu_items item3 = new Menu_items("Salads", "Salad", 6);

                        // Create a menu
                        Menu menu = new Menu();
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
                        Customer customer1 = new Customer("Hazem", "hazem1", "password", "customer", 123456789);
                        Customer customer2 = new Customer("Amin", "amin2", "hazem2", "customer", 123456689);
                        Customer customer3 = new Customer("Michael", "michael", "michael3", "customer", 123445789);

                        ArrayList<Customer> registeredCustomers = new ArrayList<Customer>();
                        registeredCustomers.add(customer1);
                        registeredCustomers.add(customer2);
                        registeredCustomers.add(customer3);
                        // Create a reservation
                        LocalDateTime reservationDateTime = LocalDateTime.now().plusDays(1);
                        Reservation reservation = new Reservation(customer1, reservationDateTime, 4);

                        // Receptionist creates a reservation
                        Receptionist receptionist = new Receptionist("Receptionist", "receptionist", "password",
                                        "receptionist",
                                        987654321);
                        Receptionist.set_tables(tables);
                        receptionist.createReservation(customer1, reservationDateTime, 4);

                        // Create a list of order items
                        ArrayList<OrderItem> orderItems = new ArrayList<>();
                        orderItems.add(new OrderItem(item1, 2)); // Example: Add 2 portions of item1 to the order
                        orderItems.add(new OrderItem(item2, 1)); // Example: Add 1 portion of item2 to the order

                        // Create an Order for the customer
                        Order order = new Order(customer1, orderItems);

                        // Create a Bill for the customer's order
                        Bill bill = new Bill(customer1, "Cash", order);

                        // Calculate the total bill
                        double totalBill = bill.totalPrice();

                        // Print the total bill
                        System.out.println("Total Bill for " + customer1.getName() + ": $" + totalBill);

                        SceneController.setMenu(menu);
                        SceneController.setReceptionist(receptionist);
                        SceneController.setRegisteredCustomers(registeredCustomers);

                        HomePage homePage = new HomePage();

                        Scene scene = homePage.getScene();
                        primaryStage.setTitle("NPC Restaurant and Cafe");
                        primaryStage.setScene(scene);
                        primaryStage.setResizable(false);
                        SceneController.setStage(primaryStage);
                        primaryStage.show();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
