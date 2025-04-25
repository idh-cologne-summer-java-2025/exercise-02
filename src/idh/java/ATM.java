package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	Account[] accArr = {new Account(500),new Account(112), new Account(666)};
	int cash = 1000;
	
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
				System.out.print("Enter your Account number: ");
				int accID = Integer.parseInt(br.readLine());
				
				//Check, ob AccID existiert. Wenn nicht, wird die Methode neugestartet
				//Wenn doch, dann läuft das Programm weiter
				if (null==getAccountByID(accID)) {
					run();
				} 
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accID);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int accID) {
		
		Account acc = getAccountByID(accID); 
		int accountBalance = acc.getAccountBalance();
		
		if (amount >= accountBalance) {
			System.out.println("Sorry, not enough money on your account.");
		} 
		else if (amount>=cash) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}
		else {
			accountBalance = accountBalance - amount;
			cash = cash - amount;
			System.out.println("Ok, here is your money, enjoy!");
		}

	}

	/**
	 * Eine Methode, die heraussucht, ob zu der angegebenen Account-ID auch ein Account
	 * angelegt vorliegt. Wenn nicht, wird eine Fehlermeldung ausgespuckt.
	 * */
	public Account getAccountByID(int accID) {
		for (int i=0;i<accArr.length;i++) {
			if (accArr[i].getAccountID() == accID) {
				return accArr[i];
			}
		}
		System.out.println("There's no account with accountID "+accID+". \n "
				+ "Please type in a valid Account-Number");
		return null;
	}
	
	public void enoughCash(int amount) {
		if (amount>= cash) {
			
		}
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
	
	

}
