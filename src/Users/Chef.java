package Users;
import java.util.*;
import Services.Menu_items;
import Services.Order;
import Services.OrderItem;

public final class Chef extends Users {
    
    
    public Chef(String name, String userName, String password, String role, int contactNumber) {
		super(name, userName, password, role, contactNumber);
	}

	public void takeOrder(Order order) {
        List<OrderItem> items = order.getItems(); // This line should be removed
        for (OrderItem orderItem : order.getItems()) {
        	Menu_items menuItem = orderItem.getMenuItem();
            prepareItem(menuItem);
        }
        System.out.println("Order prepared successfully.");
    }

    private void prepareItem(Menu_items menuItem) {
        System.out.println("Preparing: " + menuItem.getTitle());
    }

}