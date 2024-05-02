package GUI;

import Users.Customer;
import javafx.scene.layout.VBox;
import Services.Menu;
import Services.Order;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import Services.OrderItem;
import Services.Menu_items;

public class OrderPage {
    private Menu menu;
    private Customer customer;
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private String[] menuItemStrings;

    public OrderPage(
            Menu menu, Customer customer) {
        this.customer = customer;
        this.menu = menu;
        OrderItem orderItem = new OrderItem(menu.getItems().get(0), 1);
        orderItems.add(orderItem);
        menuItemStrings = new String[menu.getItems().size()];
        for (int i = 0; i < menu.getItems().size(); i++) {
            menuItemStrings[i] = menu.getItems().get(i).toString();
        }
    }

    public void orderButtonClicked(javafx.event.ActionEvent e) {
        System.out.println("Order button clicked");
        System.out.println("Order items:");
        for (OrderItem item : orderItems) {
            System.out.println(item.getMenuItem().getDishName() + " x" + item.getQuantity());
        }
    }

    public Scene getScene() {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 250);

        // Add item dropdown
        ComboBox<String> itemDropdown = new ComboBox<String>();
        itemDropdown.getItems().addAll(menuItemStrings);
        itemDropdown.setValue(menuItemStrings[0]);

        // Add quantity field
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        // Add item button
        Button addItemButton = new Button("Add item");
        addItemButton.setOnAction(ev -> {
            Menu_items selectedItem = menu.getItems().get(itemDropdown.getSelectionModel().getSelectedIndex());
            int quantity = Integer.parseInt(quantityField.getText());
            OrderItem item = new OrderItem(selectedItem, quantity);
            orderItems.add(item);

            // Show currently selected items with option to remove or change quantity
            HBox itemLayout = new HBox();
            Text itemName = new Text(item.getMenuItem().getDishName());
            Text itemPrice = new Text("Price: " + item.getMenuItem().getPrice());
            Text itemQuantity = new Text("Quantity: " + item.getQuantity());
            Button removeButton = new Button("Remove");
            Button changeQuantityButton = new Button("Change quantity");

            removeButton.setOnAction(e -> {
                orderItems.remove(item);
                layout.getChildren().remove(itemLayout);
            });

            changeQuantityButton.setOnAction(e -> {
                // Change quantity
            });

            itemLayout.getChildren().addAll(itemName, itemPrice, itemQuantity, removeButton, changeQuantityButton);
            layout.getChildren().add(itemLayout);
        });

        layout.getChildren().addAll(itemDropdown, quantityField, addItemButton);

        // Add order button
        Button orderButton = new Button("Order");
        orderButton.setOnAction(e -> orderButtonClicked(e));
        layout.getChildren().add(orderButton);

        return scene;
    }
}
