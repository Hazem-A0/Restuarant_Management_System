package GUI;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import Users.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RegisterPage {
    ArrayList<Customer> registeredCustomers = new ArrayList<Customer>();

    public RegisterPage(ArrayList<Customer> registeredCustomers) {
        this.registeredCustomers = registeredCustomers;
    }

    public Scene getScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        root.setId("background");
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Place Title on the top
        VBox hbox_title = new VBox();
        Text title = new Text("NPC Restaurant and Cafe");
        title.setId("title");
        hbox_title.getChildren().add(title);
        hbox_title.setId("top");
        root.setTop(hbox_title);

        // Place text fields in the center
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");
        TextField roleField = new TextField();
        roleField.setPromptText("Role");
        TextField contactNumberField = new TextField();
        contactNumberField.setPromptText("Contact Number");
        Text errorMsg = new Text();
        errorMsg.setId("error");

        // Place buttons in the center
        Button registerButton = new Button("Register");
        Button homeButton = new Button("Home");

        // Control button
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get user inputs
                String name = nameField.getText();
                String userName = usernameField.getText();
                String password = passwordField.getText();
                String role = roleField.getText();
                int contactNumber;
                try {
                    contactNumber = Integer.parseInt(contactNumberField.getText());
                } catch (Throwable e) {
                    errorMsg.setText("Invalid Number");
                    return;
                }
                Customer customer = new Customer(name, userName, password, role, contactNumber);
                registeredCustomers.add(customer);
                System.out.println("New customer registered: " + customer.getName());

                // Optionally, you can perform further actions with the customer object
            }
        });

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController.gotoHome(event);
            }
        });

        VBox hbox = new VBox();
        hbox.getChildren().addAll(nameField, usernameField, passwordField, roleField, contactNumberField,
                registerButton, homeButton, errorMsg);
        hbox.setId("center");
        root.setCenter(hbox);

        return scene;
    }
}
