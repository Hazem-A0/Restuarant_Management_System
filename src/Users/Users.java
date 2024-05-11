package Users;


public abstract class Users {
    protected String name;
    private String userName;
    private String password;
    protected String role;
    private int contactNumber ;

    


	public Users(String name, String userName, String password, String role, int contactNumber) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.contactNumber = contactNumber;
	}


	public int getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() { return role; }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Username: " + userName);
        System.out.println("Role: " + role);
        System.out.println("Contact Number: " + contactNumber);
    }

    @Override
    public String toString(){
        return "Name: " + name + "\n"
                + "User Name: " + userName + "\n"
                + "Password: " + password + "\n"
                + "Role: " + role;
    }
}