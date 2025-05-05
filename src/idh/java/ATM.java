package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;

	Account[] accounts = new Account[5];
	
	public ATM() {
		for (int i=0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
			
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
				System.out.print("Enter the account id to withdraw: ");
				int id = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(id, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	protected Account getAccount(int id) {
		for (int i=0; i < accounts.length; i++) {
			if (accounts[i].getId() == id) {
				return accounts[i];
			}
		}
		 return null;
	}
	public void cashout(int id, int amount) {
		
		Account account = getAccount(id);
		
		if(account == null) {
			System.out.println("dieses Konto existiert nicht");
			return;
		}
		
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
