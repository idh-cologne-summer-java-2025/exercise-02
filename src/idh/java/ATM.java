package idh.java;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.Random;


public class ATM {
	int accountBalance = 10000;
	
	// create accounts
	Account[] accounts = new Account[5];
	
	// fill accounts with random cash amounts
	public ATM() {
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the account number: ");
				int accountNo = Integer.parseInt(br.readLine());				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNo, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountNo, int amount) {
		if (amount > accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Sorry, not enough money in the bank.");
			return;
		}

		Account account = getAccount(accountNo);
		
			
		if (account == null) {
			System.out.println("Sorry, account does not exist!");
		    return;
		}
			
		if (amount > account.getBalance() ) {
			System.out.println("Sorry, your account has insufficient funds!");
			System.out.println("Your current account balance is: "+account.getBalance());
		    return;
		}
		
		account.withdraw(amount);
		accountBalance = accountBalance - amount;
		System.out.println("Ok, here is your money, enjoy!");	
		}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
	
	public Account getAccount(int id) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getId() == id)
				return accounts[i];
		}
		return null;
	}
	
}
