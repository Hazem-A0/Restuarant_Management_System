package Services;
import java.util.*;



public class Order {
	private int order_id;
	private String clientName;
	private List<OrderItem> items;
	private OrderStatus status;
	
	
	public Order(int order_id, String clientName) {
		this.order_id = order_id;
		this.clientName = clientName;
		items = new ArrayList<>();
		status = OrderStatus.PLACED;
	}
	public List<OrderItem> getItems() {
        return items;
    }
	public void addItem(OrderItem item) {
        items.add(item);
    }
	public void removeItem(OrderItem item) {
        items.remove(item);
    }
	
	 public OrderStatus getStatus() {
	        return status;
	    }
	 
	 public void setStatus(OrderStatus status) {
	        this.status = status;
	    }


}
