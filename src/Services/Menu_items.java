package Services;

public abstract class Menu_items implements Comparable<Menu_items>{

	private String dishName;
	private String dishType;
	private int price;
	
	public Menu_items(String dishType, String dishName, int price){
    this.dishType = dishType;
    this.dishName = dishName;
    this.price = price;
    
}
	   public String getDishType() {
	        return dishType;
	    }
	   public void setDishType(String dishType) {  // dish types to be modified
	        if (!(dishType.equals("main_course") || dishType.equals("appetizer")
	                || dishType.equals("desert")))
	            throw new IllegalArgumentException();

	        this.dishType = dishType;
	    }
	
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getdishType() {
		return dishType;
	}

	public int getPrice() {
		return price;
	}
	public void updatePrice(int newPrice)
	{
		if (newPrice<0) throw new IllegalArgumentException();
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
	 @Override
	    public boolean equals(Object obj){
	        return this.dishType.equals(((Menu_items)obj).getdishType())
	                && this.dishName.equals(((Menu_items)obj).getDishName())
	                && this.price == ((Menu_items)obj).getPrice();
	    }
	
	 @Override
	    public String toString(){
	        return "Dish type: " + dishType + "\n"
	                + "Dish name: " + dishName + "\n"
	                + "Dish price: " + price + "\n";
	    }

	
}

/*public int getMenuItemID() {
return menuItemID;
}
*/
