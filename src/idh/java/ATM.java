package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class ATM {
	
	int ATMBalance = 50000; // initial maximum cashdeposit in the ATM
		
	// Arrays store account numbers and respective balances
	public int[] accountNumbers = {1234, 1337, 7353}; 
	public int[] accountBalances = {100, 1500, 50000};

	
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
				System.out.print("Enter your account number: ");      // added input for account number
				int accountNumber = Integer.parseInt(br.readLine()); 
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				cashout(accountNumber, amount);
				System.out.println(" "); 
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(int accountNumber, int amount) {
		int accountIndex = -1; // added storing index in accountNumbers

		// loop to search for accountNumbers
		for (int i = 0; i <accountNumbers.length; i++)  
			if (accountNumbers[i] == accountNumber) {
				accountIndex = i; 
				break;
			}

	// checking accountBalance of respective accountNumber
	int accountBalance = accountBalances[accountIndex];

	if (amount > accountBalance) {
	System.out.print("Sorry, not enough money in the bank.");

	// check if ATM has enough cash in deposit
	} else if (ATMBalance < amount) {
	System.out.println("Sorry, the ATM doesn't have that much cash anymore.");

	// final cashout
	} else {
	accountBalances[accountIndex] -= amount; 
	ATMBalance -= amount; 
	System.out.print("Ok, here is your money, enjoy!");	
	}

	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}