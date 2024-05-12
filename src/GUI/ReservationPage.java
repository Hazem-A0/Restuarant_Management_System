package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import Users.Users;
import Services.Reservation;
import Users.Customer;
import Users.Receptionist;

public class ReservationPage {
    private Receptionist receptionist;
    private Customer customer;

    public ReservationPage(Receptionist receptionist, Customer customer) {
        this.receptionist = receptionist;
        this.customer = customer;
    }

    public void cancelButtonClicked(ActionEvent e) {
        // TODO: Implement cancel reservation
        SceneController.gotoHome(e);
    }

    public void makeReservationButtonClicked(String date, int numberOfPeople) {
        // TODO: Implement make reservation
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

//        Image image = new Image("GUI/logo.png");
//        ImageView imageView = new ImageView(image);
//        imageView.setFitHeight(200);
//        imageView.setFitWidth(200);
//        imageView.setPreserveRatio(true);
//        hbox_title.getChildren().add(title);
//        hbox_title.getChildren().add(imageView);
//        hbox_title.setId("headercontainer");
//        root.setTop(hbox_title);

        VBox layout = new VBox();
        boolean hasReservations = false;
        for (Reservation reservation : receptionist.getReservations()) {
            if (reservation.getCustomer().equals(customer)) {
                Label reservationLabel = new Label("Reservation: " + reservation.getReservationDateTime() + " for "
                        + reservation.getNumberOfPeople() + " people");
                reservationLabel.getStyleClass().add("white-text");
                Button orderButton = new Button("Order");
                Button cancelButton = new Button("Cancel Reservation");

                orderButton.setOnAction(e -> SceneController.gotoOrderPage(e));
                cancelButton.setOnAction(e -> cancelButtonClicked(e));

                layout.getChildren().addAll(reservationLabel, orderButton, cancelButton);
                hasReservations = true;
            }
        }
        if (!hasReservations) {
            Label noReservationsLabel = new Label("You have no reservations");
            noReservationsLabel.getStyleClass().add("white-text");
            Label dateLabel = new Label("Date:");
            dateLabel.getStyleClass().add("white-text");
            TextField dateInput = new TextField();
            Label numberOfPeopleLabel = new Label("Number of People:");
            numberOfPeopleLabel.getStyleClass().add("white-text");
            TextField numberOfPeopleInput = new TextField();
            Button makeReservationButton = new Button("Make Reservation");
            makeReservationButton.setOnAction(e -> makeReservationButtonClicked(dateInput.getText(),
                    Integer.parseInt(numberOfPeopleInput.getText())));
            layout.getChildren().addAll(noReservationsLabel, dateLabel, dateInput, numberOfPeopleLabel,
                    numberOfPeopleInput, makeReservationButton);
        }

        Button homeButton = new Button("Home");
        homeButton.setOnAction(e -> SceneController.gotoHome(e));
        layout.setId("center");
        root.setCenter(layout);
        return scene;
    }
}
