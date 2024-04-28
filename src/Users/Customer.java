package Users;
import Services.Order;
import Services.OrderItem;
import Services.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;

public class Customer extends Users {
	private boolean checkedIn;
	private Order currentOrder;
	private LocalDateTime lastVisitTime;
	private List<OrderItem> items;
	

	public LocalDateTime getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(LocalDateTime lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
		
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Customer(String name, String userName, String password) {
		super(name, userName, password, "Client");
		this.checkedIn=false;
	}

	/*public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}*/
	public void checkIn() {
        checkedIn = true;
        System.out.println(name + " has checked in.");
    }
	
	public void checkOut() {
        checkedIn = false;
        lastVisitTime = LocalDateTime.now();
        System.out.println(name + " has checked out.");
    }
	
	public void cancelOrder() {
        if (currentOrder != null) {
            currentOrder.setStatus(OrderStatus.CANCELLED);
            System.out.println(name + "'s current order has been cancelled.");
        } else {
            System.out.println(name + " does not have an active order to cancel.");
        }
    }
	public void modifyOrder(Order newOrder) {
        if (currentOrder != null) {
            currentOrder = newOrder;
            System.out.println(name + "'s order has been modified.");
        } else {
            System.out.println(name + " does not have an active order to modify.");
        }
    }
	public LocalDateTime getLastVisitedTime() {
        if (lastVisitTime != null) {
            return lastVisitTime;
        } else {
            System.out.println(name + " has not visited before.");
            return null;
        }
    }
	
	public boolean isCheckedIn() {
        return checkedIn;
    }
	public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    
	

}
