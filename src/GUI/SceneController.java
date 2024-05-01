package GUI;

import GUI.LoginPage;
import GUI.HomePage;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private static Scene scene;
    private static Stage stage;
    private static Parent root;

    private static HomePage homePage = new HomePage();
    private static LoginPage loginPage = new LoginPage();

    public static void setStage(Stage stage_) {
        stage = stage_;
    }

    public static void gotoLogin(ActionEvent event) {
        scene = loginPage.getScene();
        stage.setScene(scene);
        // stage.show();
    }

    public static void gotoHome(ActionEvent event) {
        scene = homePage.getScene();
        stage.setScene(scene);
        // stage.show();
    }
}
