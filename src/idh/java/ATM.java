package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int[] accountNumbers = {123, 234, 345};
	int[] accountBalances = {700, 2000, 350};
	int atmCash = 1500;
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
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());

				int index = findAccountIndex(accountNumber);
				if (index == -1) {
					System.out.println("Account not found.");
					continue;
				}

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());

				cashout(index, amount);
			} catch (Exception e) {
				System.out.println("Invalid input. Exiting...");
				break;
			}
		}
	}

	public void cashout(int index, int amount) {
		if (amount > accountBalances[index]) {
			System.out.println("Sorry, you don't have enough money in the bank.");
		} else if (amount > atmCash) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} else {
			accountBalances[index] -= amount;
			atmCash -= amount;
			System.out.println("Ok, here you go! \nyou´r new balance is " + accountBalances[index] + "€");
		}
	}
	private int findAccountIndex(int accountNumber) {
		for (int i = 0; i < accountNumbers.length; i++) {
			if (accountNumbers[i] == accountNumber) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	
	};

}
