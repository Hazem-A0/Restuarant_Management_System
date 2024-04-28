package Services;
import java.util.*;

import Users.manager;

public class Menu {
	
	private  ArrayList <Menu_items> menuItems ;
	
	public Menu() {
		menuItems = new ArrayList<>();
    }
	protected void addItem(Menu_items item, manager manager) { //(Menu_items item, manager manager)
        if (manager != null) {
        	menuItems.add(item);
            System.out.println("Item '" + item.getTitle() + "' added to the menu.");
        } else {
            System.out.println("Only manager can add items to the menu.");
        }
    }

    protected void removeItem(Menu_items item, manager manager) {
        if (manager != null) {
        	menuItems.remove(item);
            System.out.println("Item '" + item.getTitle() + "' removed from the menu.");
        } else {
            System.out.println("Only manager can remove items from the menu.");
        }
    }
	public void sort() {
        Collections.sort(menuItems);
    }
	 public List<Menu_items> getItems() {
	        return menuItems;
	    }
}
