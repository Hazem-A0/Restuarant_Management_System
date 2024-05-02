package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import Users.Users;
import Services.Reservation;
import Users.Customer;

public class ReservationPage {

    public void cancelButtonClicked(ActionEvent e) {
        // TODO: Implement cancel reservation
        SceneController.gotoHome(e);
    }

    public void makeReservationButtonClicked(String date, int numberOfPeople) {
        // TODO: Implement make reservation
    }

    public Scene getScene(Stage stage, Customer customer, Reservation[] reservations) {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 250);
        boolean hasReservations = false;
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                Label reservationLabel = new Label("Reservation: " + reservation.getReservationDateTime() + " for "
                        + reservation.getNumberOfPeople() + " people");
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
            Label dateLabel = new Label("Date:");
            TextField dateInput = new TextField();
            Label numberOfPeopleLabel = new Label("Number of People:");
            TextField numberOfPeopleInput = new TextField();
            Button makeReservationButton = new Button("Make Reservation");
            makeReservationButton.setOnAction(e -> makeReservationButtonClicked(dateInput.getText(),
                    Integer.parseInt(numberOfPeopleInput.getText())));
            layout.getChildren().addAll(noReservationsLabel, dateLabel, dateInput, numberOfPeopleLabel,
                    numberOfPeopleInput, makeReservationButton);
        }

        Button homeButton = new Button("Home");
        homeButton.setOnAction(e -> SceneController.gotoHome(e));
        layout.getChildren().add(homeButton);
        return scene;
    }
}
