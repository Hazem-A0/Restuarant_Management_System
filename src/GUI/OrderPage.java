package GUI;

import Services.Menu;
import Services.OrderItem;
import Services.Menu_items;
import Users.Customer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class OrderPage {
    private Menu menu;
    private Customer customer;
    private List<OrderItem> orderItems = new ArrayList<>();
    private String[] menuItemStrings;
    private TextField totalPriceField; // Added field to display total price
    private Text errorText;

    public OrderPage(
            Menu menu, Customer customer) {
        this.customer = customer;
        errorText = new Text();
        errorText.setFill(Color.WHITE);
        this.menu = menu;
        menuItemStrings = new String[menu.getItems().size()];
        for (int i = 0; i < menu.getItems().size(); i++) {
            menuItemStrings[i] = menu.getItems().get(i).toString();

        }
    }

    public void orderButtonClicked(javafx.event.ActionEvent e, String paymentMethod) {
        System.out.println("Order button clicked");
        System.out.println("Order items:");
        double totalPrice = 0.0;
        for (OrderItem item : orderItems) {
            System.out.println(item.getMenuItem().getDishName() + " x" + item.getQuantity());
            totalPrice += item.getMenuItem().getPrice() * item.getQuantity();
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Payment Method: " + paymentMethod);

        String orderDetails = "Order items:\n";
        for (OrderItem item : orderItems) {
            orderDetails += item.getMenuItem().getDishName() + " x" + item.getQuantity() + "\n";
        }

        // Set total price in the text field
        totalPriceField.setText(String.format("Total Price: $%.2f", totalPrice));

        SceneController.gotoOrderComplete(e, totalPrice, orderDetails);
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

        VBox layout = new VBox();
        // Add item dropdown
        ComboBox<String> itemDropdown = new ComboBox<>();
        itemDropdown.getItems().addAll(menuItemStrings);
        itemDropdown.setValue(menuItemStrings[0]);

        // Add quantity field
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        // Add item button
        Button addItemButton = new Button("Add item");
        addItemButton.setOnAction(ev -> {
            Menu_items selectedItem = menu.getItems().get(itemDropdown.getSelectionModel().getSelectedIndex());
            String quantityInput = quantityField.getText();
            showError("");
            if (quantityInput.isEmpty()) {
                // Display error for empty quantity
                showError("Please enter a quantity.");
                return;
            }
            int quantity;
            try {
                quantity = Integer.parseInt(quantityInput);
                if (quantity <= 0) {
                    // Display error for negative or zero quantity
                    showError("Please enter a positive quantity.");
                    quantityField.setText("");
                    return;
                }
            } catch (NumberFormatException e) {
                // Display error for non-integer quantity
                quantityField.setText("");
                showError("Please enter an integer quantity.");

                return;
            }

            OrderItem item = new OrderItem(selectedItem, quantity);
            orderItems.add(item);

            // Update total price when an item is added
            updateTotalPrice();

            // Show currently selected items with option to remove or change quantity
            HBox itemLayout = new HBox();
            Text itemName = new Text(item.getMenuItem().getDishName() + "\t");
            Text itemPrice = new Text("Price: " + item.getMenuItem().getPrice() + "\t");
            Text itemQuantity = new Text("Quantity: " + item.getQuantity() + "\t");
            Button removeButton = new Button("Remove");
            Button changeQuantityButton = new Button("Change quantity");
            itemLayout.setId("order");
            itemName.setId("orderitem");
            itemPrice.setId("orderitem");
            itemQuantity.setId("orderitem");
            removeButton.setOnAction(e -> {
                orderItems.remove(item);
                layout.getChildren().remove(itemLayout);
                updateTotalPrice(); // Update total price when an item is removed
            });

            changeQuantityButton.setOnAction(e -> {
                // Change quantity
            });

            itemLayout.getChildren().addAll(itemName, itemPrice, itemQuantity, removeButton, changeQuantityButton);
            layout.getChildren().add(itemLayout);
        });

        layout.getChildren().addAll(itemDropdown, quantityField, addItemButton);

        // Payment method
        CheckBox cashCheckBox = new CheckBox("Cash");
        cashCheckBox.setId("cashCheckBox"); // Set ID for CSS styling

        CheckBox visaCheckBox = new CheckBox("Visa");
        visaCheckBox.setId("visaCheckBox"); // Set ID for CSS styling

        // Add order button
        Button orderButton = new Button("Order");
        orderButton.setOnAction(e -> orderButtonClicked(e,
                cashCheckBox.isSelected() ? "Cash" : (visaCheckBox.isSelected() ? "Visa" : "Unknown")));
        layout.getChildren().addAll(cashCheckBox, visaCheckBox, orderButton);

        // Add total price text field
        totalPriceField = new TextField();
        totalPriceField.setEditable(false);
        layout.getChildren().add(totalPriceField);

        // Add cancel order button
        Button cancelOrderButton = new Button("Cancel Order");
        cancelOrderButton.setOnAction(e -> {
            // Navigate back to homepage
            SceneController.gotoHomePage(e);
        });
        layout.getChildren().add(cancelOrderButton);
        layout.getChildren().add(errorText);
        root.setCenter(layout);
        return scene;
    }

    // Method to update total price
    private void updateTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : orderItems) {
            totalPrice += item.getMenuItem().getPrice() * item.getQuantity();
        }
        totalPriceField.setText(String.format("Total Price: $%.2f", totalPrice));
    }

    private void showError(String message) {

        errorText.setText(message);
    }

}
