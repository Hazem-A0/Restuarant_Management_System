package Users;
import Services.Bill;
import Services.Menu_items;
import Services.Order;
import Services.OrderItem;
import Services.OrderStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Users {
	private boolean checkedIn;
	private Order currentOrder;
	private LocalDateTime lastVisitTime;
	private List<OrderItem> currentOrderItems;
	private Bill bill;
	
	
	public Customer(String name, String userName, String password, String role, int contactNumber) {
		super(name, userName, password, role, contactNumber);
		currentOrderItems = new ArrayList<>();
		this.checkedIn=false;
	}
	public LocalDateTime getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(LocalDateTime lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public List<OrderItem> getItems() {
		return currentOrderItems;
	}

	public void addToOrder(Menu_items item, int quantity) {
        OrderItem orderItem = new OrderItem(item, quantity);
        currentOrderItems.add(orderItem);
        System.out.println("Added " + quantity + "x " + item.getDishName() + " to your order.");
    }
	
    public void placeOrder(String paymentType) {
        if (currentOrderItems.isEmpty()) {
            System.out.println("Your order is empty. Please add items before placing the order.");
            return;
        }

        currentOrder = new Order(this, currentOrderItems);
        bill = new Bill( this, paymentType, currentOrder);
        System.out.println("Order Details:");
        System.out.println("Customer: " + this.getName());
        System.out.println("Items:");
        for (OrderItem item : currentOrderItems) {
            Menu_items menuItem = item.getMenuItem();
            int quantity = item.getQuantity();
            System.out.println(quantity + "x " + menuItem.getDishName() + " - $" + (menuItem.getPrice() * quantity));
        }
        System.out.println("Total: $" + bill.totalPrice());
        // Clear current order after placing it
        currentOrderItems.clear();
        System.out.println("Order placed successfully.");
    }
    

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}



	
	public void checkIn() {
        checkedIn = true;
        System.out.println(name + " has checked in.");
    }
	
	public Bill getBill() {
		return bill;
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
	@Override
	public void displayInfo() {
		
		super.displayInfo();
	}
    
	

}
