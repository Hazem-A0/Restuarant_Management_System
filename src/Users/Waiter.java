package Users;
import java.util.*;

import Services.Order;
import Services.OrderItem;

public final class Waiter extends Users {
   
  

	public Waiter(String name, String userName, String password, String role, int contactNumber) {
		super(name, userName, password, role, contactNumber);
	}

	/*public Order createOrder(ArrayList<OrderItem> items , int ID,String name) {
        Order order = new Order(ID,name);
        for (OrderItem item : items) {
            order.addItem(item);
        }
        System.out.println("Order created successfully.");
        return order;
    }*/
}
