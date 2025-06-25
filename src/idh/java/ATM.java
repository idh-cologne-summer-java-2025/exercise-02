package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
private	int ATMaccountBalance = 600;
private int[] accountNumbers = {123, 234, 345};
private int[] accountBalances = {700, 250, 150};

	
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
				 int accountIndex = findAccountIndex(accountNumber);
	                if (accountIndex == -1) {
	                    System.out.println("Account not found.");
	                    continue;
	                }

	                System.out.print("Enter the amount to withdraw: ");
	                int amount = Integer.parseInt(br.readLine());

	                cashout(accountIndex, amount);
	            } catch (Exception e) {
	                System.out.println("Invalid input. Exiting.");
	                break;
			}
		}
	}
	 private int findAccountIndex(int accountNumber) {
	        for (int i = 0; i < accountNumbers.length; i++) {
	            if (accountNumbers[i] == accountNumber) {
	                return i;
	            }
	        }
	        return -1; // Account Number not found
	    }
	public void cashout(int accountIndex, int amount)
	 {
        int accountBalance = accountBalances[accountIndex];
{
	 if (amount > accountBalance) {
         System.out.println("Sorry, you don't have enough money in the bank.");
     } else if (amount > ATMaccountBalance) {
         System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
     } else {	
	if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			ATMaccountBalance = ATMaccountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

     }
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
