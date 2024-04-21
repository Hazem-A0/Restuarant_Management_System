package Services;
import java.util.*;

public class Menu {
	
	private  ArrayList <Menu_items> menuItems ;
	
	public Menu() {
		menuItems = new ArrayList<>();
    }
	public void addItem(Menu_items item) {
		menuItems.add(item);
    }
	public void sort() {
        Collections.sort(menuItems);
    }
	public void removeItem(Menu_items item) {
		menuItems.remove(item);
    }
}
