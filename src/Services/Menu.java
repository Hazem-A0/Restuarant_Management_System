package Services;
import java.util.*;

import Users.manager;

public class Menu implements Removable {
	
	protected  ArrayList <Menu_items> menuItems ;
	
	public Menu() {
		menuItems = new ArrayList<>();
    }



	protected void addItem(Menu_items item, manager manager) { //(Menu_items item, manager manager)

        if (manager != null) {
        	menuItems.add(item);
            System.out.println("Item '" + item.getDishName() + "' added to the menu.");
        } else {
            System.out.println("Only manager can add items to the menu.");
        }
    }

	@Override
	public void remove_object (Object item) {
        	menuItems.remove((Menu_items)item);
            System.out.println("Item '" + ((Menu_items) item).getDishName() + "' removed from the menu.");
    
	}
	/*@Override
	public void remove_object (Object item, manager manager) {
        if (manager != null) {
        	menuItems.remove((Menu_items)item);
            System.out.println("Item '" + ((Menu_items) item).getDishName() + "' removed from the menu.");
        } else {
            System.out.println("Only manager can remove items from the menu.");
        }
    }*/
	/*public void sort() {
        Collections.sort(menuItems);
    }*/
	 public List<Menu_items> getItems() {
	        return menuItems;
	    }



	
	
}
