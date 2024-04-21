package Services;

public class Menu_items implements Comparable<Menu_items>{

	private int menuItemID;
	private String title;
	private String description;
	private int price;
	
	public Menu_items(int menuItemID, String title, String description, int price) {
		this.menuItemID = menuItemID;
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public int getMenuItemID() {
		return menuItemID;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}
	public void updatePrice(int newPrice)
	{
		this.price = newPrice;
	}
	
	public int compareTo(Menu_items item)
	{
		if (this.price > item.price)
			return 1;
		else if (this.price < item.price)
			return -1;
		else
			return 0;
	}

	
}
