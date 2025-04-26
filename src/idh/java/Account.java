package idh.java;

public class Account {

	int id;

	int accountBalance;

	public Account(int id) {
		this.id = id;
		this.accountBalance = 0;

	}

	public void deposit(int amount) {
		this.accountBalance = this.accountBalance + amount;
		System.out.println("Success! " + amount + " € deposited.");
		System.out.println("New balance: " + this.accountBalance + " €");
	}

	public boolean cashout(int amount) {
		if (this.accountBalance >= amount) {
			this.accountBalance = this.accountBalance - amount;
			System.out.println("Success! " + amount + " € withdrawn.");
			System.out.println("New balance: " + accountBalance + " €");
			return true;
		} else {
			System.out.println("Insufficient funds! Current balance: " + accountBalance + " €");
			return false;
		}
	}

	public int getBalance() {
		return this.accountBalance;
	}

	public void setBalance(int newBalance) {
		this.accountBalance = newBalance;
	}

	public int getid() {
		return this.id;
	}

}
