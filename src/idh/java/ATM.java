package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
	int AutomataCashBalance = 1000;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	public Map<String, Integer> Accountlist = new HashMap<String, Integer>();
	
	public int getBalanceInt (String AccNum) {
		if(Accountlist.containsKey(AccNum)) {
		  return Accountlist.get(AccNum);
		}
		else {
			throw new Error("404 Account not found :(");
		}
	}
	
	public void InnitAcc() {
		Accountlist.put("123", 100);
		Accountlist.put("124", 100);
		Accountlist.put("125", 1000);
		Accountlist.put("404", 0);
		Accountlist.put("42", 420);
	}
	
	public void run() {
		InnitAcc();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your Account number: ");
				String AccountNum = br.readLine();

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount,AccountNum);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, String AcN) {
		if (AutomataCashBalance >= amount) {
			
			
			try {
				int accountBalance = getBalanceInt(AcN);
				if (amount <= accountBalance) {
					accountBalance = accountBalance - amount;
					AutomataCashBalance -= amount;
					Accountlist.put(AcN, accountBalance);
					System.out.println("Ok, here is your money, enjoy!");
				} else {
					System.out.println("Sorry, not enough money on your Account.");
				}
			}
			catch (Exception e) {
				System.out.println(e.getCause());
			}
		}
		else {
			System.out.println("Sorry, not enough money in the machine.");
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
