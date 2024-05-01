package Services;

import Users.manager;
import Users.Customer;
import Users.Receptionist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import GUI.HomePage;
import GUI.SceneController;
import GUI.LoginPage;
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
        manager managerInstance = new manager("John Doe", "manager", "password", "manager", 1205495697);
        menu.addItem(item1, managerInstance);
        menu.addItem(item2, managerInstance);
        menu.addItem(item3, managerInstance);

        // Display menu
        System.out.println("Menu:");
        menu.sort();
        for (Menu_items menuItem : menu.getItems()) {
            System.out.println(menuItem.getDishName() + " - $" + menuItem.getPrice());
        }

        // Create a customer
        Customer customer = new Customer("John Doe", "johndoe", "password", "customer", 123456789);

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
            System.out.println(orderItem.getMenuItem().getDishName() + " - Quantity: " + orderItem.getQuantity());
        }

        // Customer checks out
        customer.checkOut();

        // Create a reservation
        LocalDateTime reservationDateTime = LocalDateTime.now().plusDays(1);
        Reservation reservation = new Reservation(customer, reservationDateTime, 4);

        // Receptionist creates a reservation
        Receptionist receptionist = new Receptionist("Receptionist", "receptionist", "password", "receptionist",
                987654321);
        Receptionist.set_tables(tables);
        receptionist.createReservation(customer, reservationDateTime, 4);

        // Display reservations
        System.out.println("\nReservations:");
        for (Reservation res : receptionist.getReservations()) {
            System.out.println(res.getCustomer().getName() + " - " + res.getReservationDateTime() + " - "
                    + res.getNumberOfPeople() + " people");
        }

        // Manager cancels a reservation
        Receptionist receptionist1 = new Receptionist("Manager", "manager", "password", "manager", 555555555);
        // receptionist.cancelReservation(reservation);
        receptionist.cancelReservation(customer);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            HomePage homePage = new HomePage();
            Scene scene = homePage.getScene();
            primaryStage.setTitle("Restaurant Management System");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            SceneController.setStage(primaryStage);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
