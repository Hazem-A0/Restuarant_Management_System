package Users;

import java.util.*;

public final class manager extends Users {

	private double salary;

    public manager(String name, String userName, String password, String role, int contactNumber, double salary) {
        super(name, userName, password, role, contactNumber);
        
        this.salary = salary;
    }

 
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        
        System.out.println("Salary: $" + salary);
    }

	
}
