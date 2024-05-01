/**
 * 
 */
/**
 * 
 */
module Restaurant_Management_System_ {
	requires javafx.controls;
	requires javafx.fxml;

	opens Services to javafx.fxml;

	exports Services;
}