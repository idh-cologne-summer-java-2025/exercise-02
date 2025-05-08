package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	//Arrays
	String[] accountNumbers = {"123", "456", "789"};
	int[] accountBalances = {100, 200, 300}; 
	int ATMBalance = 300; 

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
                String accountNumber = br.readLine();
                int account = matchAccount(accountNumber);
                if (account == -1) {
                    System.out.println("Unknown account!");
                    continue;
                }
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(account, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

	public int matchAccount(String accountNumber) {
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i].equals(accountNumber)) {
                return i;
            }
        }
        return -1; //,wenn Account nicht gefunden!
    }	

	public void cashout(int account, int amount) {
		//To-Do	
		if (amount > accountBalances[account]) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else if (amount > ATMBalance) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } else {
            accountBalances[account] -= amount;
            ATMBalance -= amount;
            System.out.println("Ok, here you go!");
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
