package Services;


public class OrderItem{
	private Menu_items menuItem;

    public OrderItem(Menu_items menuItem) {
        this.menuItem = menuItem;
    }

 
    public Menu_items getMenuItem() {
        return menuItem;
    }

}
