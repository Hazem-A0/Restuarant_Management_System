package GUI;

import GUI.LoginPage;
import GUI.HomePage;
import GUI.ReservationPage;
import Services.Menu;
import Services.Reservation;
import Users.Customer;
import Users.Receptionist;
import GUI.OrderPage;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SceneController {
    private static Scene scene;
    private static Stage stage;
    private static Parent root;
    private static Menu menu;
    private static Customer customer;
    private static Receptionist receptionist;
    private static ArrayList<Customer> registeredCustomers;

    public static void setStage(Stage stage_) {
        stage = stage_;
    }

    public static void setMenu(Menu menu_) {
        menu = menu_;
    }

    public static void setCustomer(Customer customer) {
        SceneController.customer = customer;
    }

    public static void setReceptionist(Receptionist receptionist) {
        SceneController.receptionist = receptionist;
    }

    public static void setRegisteredCustomers(ArrayList<Customer> registeredCustomers) {
        SceneController.registeredCustomers = registeredCustomers;
    }

    public static ArrayList<Customer> getRegisteredCustomers() {
        return registeredCustomers;
    }

    public static void gotoLogin(ActionEvent event) {
        LoginPage loginPage = new LoginPage();
        scene = loginPage.getScene();
        stage.setScene(scene);
    }

    public static void gotoHome(ActionEvent event) {
        HomePage homePage = new HomePage();
        scene = homePage.getScene();
        stage.setScene(scene);
    }

    public static void gotoRegister(ActionEvent event) {
        RegisterPage registerPage = new RegisterPage(registeredCustomers);
        scene = registerPage.getScene();
        stage.setScene(scene);
    }

    public static void gotoReservation(ActionEvent event) {
        ReservationPage reservationPage = new ReservationPage(SceneController.receptionist, SceneController.customer);
        scene = reservationPage.getScene();
        stage.setScene(scene);
    }

    public static void gotoOrderPage(ActionEvent event) {
        OrderPage orderPage = new OrderPage(SceneController.menu, SceneController.customer);
        scene = orderPage.getScene();
        stage.setScene(scene);
    }

    public static void gotoHomePage(ActionEvent event) {
        HomePage homePage = new HomePage();
        scene = homePage.getScene();
        stage.setScene(scene);
    }

}
