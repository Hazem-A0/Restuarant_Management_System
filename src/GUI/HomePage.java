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

public class HomePage {
    public Scene getScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        root.setId("background");
        // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Place Title on the top
        VBox hbox_title = new VBox();
        Text title = new Text("Restaurant Management System");
        title.setId("title");

        Image image = new Image("resources/logo.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        hbox_title.getChildren().add(title);
        hbox_title.getChildren().add(imageView);
        hbox_title.setId("top");
        root.setTop(hbox_title);

        // Place buttons in the center
        Button menu_button = new Button("Menu");
        Button order_button = new Button("Orders");
        Button reservation_button = new Button("Reservations");
        Button login_button = new Button("Login");
        Button register_button = new Button("Register");

        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController.gotoLogin(event);
            }
        });

        // Place buttons in the center
        VBox hbox = new VBox();
        hbox.getChildren().addAll(menu_button, order_button, reservation_button, login_button, register_button);
        hbox.setId("center");
        root.setCenter(hbox);

        return scene;
    }
}
