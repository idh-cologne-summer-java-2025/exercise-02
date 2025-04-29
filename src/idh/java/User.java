package idh.java;

/**
 * Class representing an ordinary User
 * Constructors force User Objects to at least have an ID and balance values.
 */
public class User {
	private String name;
	private int id;
	private int balance;
	
	public User(int id, int balance) {
		this.id = id;
		this.balance = balance;
		}
	
//	Overloaded constructor
	public User(String name, int id, int balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
