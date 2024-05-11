package Users;
import java.util.*;
import Services.Menu_items;
import Services.Order;
import Services.OrderItem;

public final class Chef extends Users {
    
    

	private double salary;

    public Chef(String name, String userName, String password, String role, int contactNumber,  double salary) {
        super(name, userName, password, role, contactNumber);
       
        this.salary = salary;
    }

  
    @Override
    public void displayInfo() {
        super.displayInfo(); 
       
        System.out.println("Salary: $" + salary);
    }


	
}