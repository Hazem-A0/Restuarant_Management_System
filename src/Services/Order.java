package Services;
import java.util.*;

public class Order {
	private int order_id;
	private String clientName;
	private ArrayList<Menu_items> items;
	private OrderStatus status;
	
	public Order(int order_id, String clientName) {
		this.order_id = order_id;
		this.clientName = clientName;
		items = new ArrayList<>();
		status = status.PLACED;
	}
	public void addItem(Menu_items item) {
        items.add(item);
    }
	public void removeItem(Menu_items item) {
        items.remove(item);
    }
	
	 public OrderStatus getStatus() {
	        return status;
	    }
	 
	 public void setStatus(OrderStatus status) {
	        this.status = status;
	    }


}
