package Services;
import java.util.*;
public class Tables {
	
	private  ArrayList <Integer>table_number = new ArrayList((Integer)10);
	private int num_of_Seats;
	private boolean isbooked;
	private String client_name;
	
	public Tables(int num_of_Seats, boolean isbooked, String client_name) {
		super();
		this.num_of_Seats = num_of_Seats;
		this.isbooked = isbooked;
		this.client_name = client_name;
	}

	public ArrayList<Integer> getTable_number() {
		return table_number;
	}

	public void setTable_number(ArrayList<Integer> table_number) {
		this.table_number = table_number;
	}

	public int getNum_of_Seats() {
		return num_of_Seats;
	}
	public void setNum_of_Seats(int num_of_Seats) {
		this.num_of_Seats = num_of_Seats;
	}
	public boolean isIsbooked() {
		return isbooked;
	}
	public void setIsbooked(boolean isbooked) {
		this.isbooked = isbooked;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	public void reserve_table(int tablenum) {
		for(int i =0;i<10;i++) {
			if (tablenum == table_number.get(i)) {
				table_number.remove(i);
				}
		}
		
	/*public void table_depreserve(Object Client) {
		//Client.getable()
	} // get table user preserved and readd it to array of tables*/
		
	}
	

}
