package idh.java;

public class Account {

	int accountBalance;
	int id;
	
	public Account(int id, int status) {
		this.id = id;
		this.accountBalance = status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return accountBalance;
	}

	public void setBalance(int status) {
		this.accountBalance = status;
	}

	public void withdraw(int sum) {
		this.accountBalance = accountBalance - sum;
	}

}