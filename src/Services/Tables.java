package Services;
import java.util.*;
public class Tables {
	
	//private  ArrayList <Integer>table_number = new ArrayList((Integer)10);
		//static  ArrayList <Tables> table_number = new ArrayList(10);
	Integer[] tableNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	private  ArrayList <Tables>table_number = new ArrayList(List.of(tableNumbers));
	private int num_of_Seats;
	private boolean isbooked;
	private String client_name;
	
	//public Tables(int num_of_Seats, boolean isbooked, String client_name) {
		public Tables(int num_of_Seats) {
		super();
		this.num_of_Seats = num_of_Seats;
		this.isbooked = false;
		//this.client_name = client_name;
	}
		public void setItems(ArrayList <Tables> table_number) {
			this.table_number = table_number;
		}

		public ArrayList <Tables> getTables() {
	        return table_number;
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
	
	
	


