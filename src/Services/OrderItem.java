package Services;


public class OrderItem {
    private Menu_items menuItem;
    private int quantity;

    public OrderItem(Menu_items menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public Menu_items getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Menu_items menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Function to calculate the total price for this order item
    public double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }
}

