package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
	private HashMap<Integer,Integer> accounts = new HashMap<>();
	
	int accountBalance;
	int ATMBalance = 500;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(int AccountNumber) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, AccountNumber);
				AccountWahl();
			}catch (Exception e){
				return;
			}
		}
	
	
	public void AccountWahl() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter your account number: ");
				int accountnumber = Integer.parseInt(br.readLine());
				Account(accountnumber);
				run(accountnumber);
			} catch(Exception e) {
				break;
			}
		}
	}
	
	public void Account(int AccountNumber) {
		if(accounts.containsKey(AccountNumber)==false) {
			accounts.put(AccountNumber, 100);
			
		}else {
			
		}
	}

	public void cashout(int amount,int AccountNumber) {
		if(amount <= ATMBalance) {
		if (amount <= accounts.get(AccountNumber)) {
			accounts.put(AccountNumber, accounts.get(AccountNumber) - amount);
			ATMBalance = ATMBalance -amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}
	}else {
		System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
	}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.AccountWahl();
	};

}
