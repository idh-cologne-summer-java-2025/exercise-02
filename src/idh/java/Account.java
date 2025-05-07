package idh.java;

public class Account {
	private int accountBalance;
	private int accountID;
	
	public Account (int accountID) {
		accountBalance = 500;
		this.accountID = accountID;
	}
	
	
	
	
	
	protected int getAccountBalance() {
		return accountBalance;
	}
	
	protected int getAccountID() {
		return accountID;
	}
	
	protected void setAccountBalance(int abgGeld) {
		accountBalance = accountBalance - abgGeld;
	}
}
