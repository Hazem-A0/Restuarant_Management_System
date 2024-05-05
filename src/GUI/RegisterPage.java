package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RegisterPage {
    public Scene getScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        root.setId("background");

        // Place Title on the top
        VBox hbox_title = new VBox();
        Text title = new Text("NPC Restaurant and Cafe");
        title.setId("title");

//        Image image = new Image("GUI/logo.png");
//        ImageView imageView = new ImageView(image);
//        imageView.setFitHeight(200);
//        imageView.setFitWidth(200);
//        imageView.setPreserveRatio(true);
//        hbox_title.getChildren().add(title);
//        hbox_title.getChildren().add(imageView);
//        hbox_title.setId("top");
//        root.setTop(hbox_title);

        // Place text fields in the center
        TextField username = new TextField();
        username.setPromptText("Username");
        TextField password = new TextField();
        password.setPromptText("Password");

        // Place buttons in the center
        Button login_button = new Button("Login");
        Button home_button = new Button("Home");

        // control button
        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Login button clicked");
            }
        });

        home_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController.gotoHome(event);
            }
        });

        VBox hbox = new VBox();
        hbox.getChildren().addAll(username, password, login_button, home_button);
        hbox.setId("center");
        root.setCenter(hbox);

        return scene;
    }
}
