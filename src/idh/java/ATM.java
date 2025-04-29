package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int[] accountNumbers = {111, 222, 333};
	int[] accountBalances = {300, 150, 1000};
	int cashInATM = 1000;


	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("Please enter your account number: ");
			int enteredAcc = Integer.parseInt(br.readLine());
			int accIndex = findAccountIndex(enteredAcc);

			if (accIndex == -1) {
				System.out.println("Account not found.");
				return;
			}

			System.out.println("Welcome! Your current balance is: " + accountBalances[accIndex]);

			while (true) {
				try {
					System.out.print("Enter amount to withdraw");
					int amount = Integer.parseInt(br.readLine());
					cashout(accIndex, amount);
				} catch (NumberFormatException e) {
					System.out.println("Session ended. Goodbye!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
	
	public void cashout(int accIndex, int amount) {
		if (amount <= 0) {
			System.out.println("Invalid amount.");
			return;
		}

		if (amount > accountBalances[accIndex]) {
			System.out.println("Insufficient funds on account.");
		} else if (amount > cashInATM) {
			System.out.println("Insufficient cash in ATM.");
		} else {
			accountBalances[accIndex] -= amount;
			cashInATM -= amount;
			System.out.println("Here is your money: " + amount);
			System.out.println("Remaining balance: " + accountBalances[accIndex]);
		}
	}

	private int findAccountIndex(int accNumber) {
		for (int i = 0; i < accountNumbers.length; i++) {
			if (accountNumbers[i] == accNumber) {
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
