package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import GUI.SceneController;

public class OrderCompletePage {
    double totalPrice;
    String orderDetails;

    public OrderCompletePage(double totalPrice, String orderDetails) {
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
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

        Image image = new Image(getClass().getResourceAsStream("/GUI/logo3.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        hbox_title.getChildren().add(title);
        hbox_title.getChildren().add(imageView);
        hbox_title.setId("headercontainer");
        root.setTop(hbox_title);

        VBox orderContainer = new VBox();
        Text orderDetailsText = new Text(orderDetails);
        Text totalPriceText = new Text("Total Price: " + totalPrice);
        // set text color to white and font size to 20
        orderDetailsText.setFill(javafx.scene.paint.Color.WHITE);
        orderDetailsText.setStyle("-fx-font-size: 20");
        totalPriceText.setFill(javafx.scene.paint.Color.WHITE);
        totalPriceText.setStyle("-fx-font-size: 24");
        orderContainer.getChildren().add(orderDetailsText);
        orderContainer.getChildren().add(totalPriceText);
        root.setCenter(orderContainer);

        // Place buttons in the center
        Button homeButton = new Button("Return to Home");

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController.gotoHome(event);
            }
        });

        // Place buttons in the center
        VBox hbox = new VBox();
        hbox.getChildren().addAll(homeButton);
        hbox.setId("center");
        root.setBottom(hbox);

        return scene;
    }
}
