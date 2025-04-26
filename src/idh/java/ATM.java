package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int[] accountBalances = new int[10];
	int atmCash = 100;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 accountBalances[1] = 200; 
	        accountBalances[2] = 100; 
	        accountBalances[3] = 50;
	        accountBalances[4] = 50;
	        accountBalances[5] = 50;
	        accountBalances[6] = 50;
		while (true) {
			try {
				System.out.print("Enter your account number (0-9): ");
                int accountNumber = Integer.parseInt(br.readLine());
                
                if (accountNumber < 0 || accountNumber >= accountBalances.length) {
                    System.out.println("Account not found.");
                    continue;
                }
                System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
            } catch (Exception e) {
                System.out.println("Invalid input. Exiting...");
                break;
            }
        }
	}

	 public void cashout(int accountNumber, int amount) {
	        int balance = accountBalances[accountNumber];

	        
	        if (amount > balance) {
	            System.out.println("Sorry, you don't have enough money in the bank.");
	            return;
	        }

	        if (amount > atmCash) {
	            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
	            return;
	        }

	        accountBalances[accountNumber] -= amount;
	        atmCash -= amount;

	        System.out.println("Ok, here you go!");
	    }

	    /**
	     * Launches the ATM
	     */
	    public static void main(String[] args) {
	        ATM atm = new ATM();
	        atm.run();
	    }
	}
