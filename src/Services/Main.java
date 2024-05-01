package Services;

import Users.manager;
import Users.Customer;
import Users.Receptionist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
                Customer customer2 = new Customer("Hazem", "hazem", "hazem2", "customer", 123456689);
                Customer customer3 = new Customer("Michael", "michael", "michael3", "customer", 123445789);

                // Create a reservation
                LocalDateTime reservationDateTime = LocalDateTime.now().plusDays(1);
                Reservation reservation = new Reservation(customer1, reservationDateTime, 4);

                // Receptionist creates a reservation
                Receptionist receptionist = new Receptionist("Receptionist", "receptionist", "password", "receptionist",
                                987654321);
                Receptionist.set_tables(tables);
                receptionist.createReservation(customer1, reservationDateTime, 4);

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
