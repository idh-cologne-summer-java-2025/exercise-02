package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
	float accountBalance = 100;
	float availableMoney = 100000.0f; // The amount of money available in the ATM
	private Map<String, NutzerKonto> konten = new HashMap<>();
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter Account Identification Number: ");
				String kontonummer = br.readLine();


				System.out.print("Enter the amount you want to withdraw: ");
				float amount = Float.parseFloat(br.readLine());



				cashout(amount, kontonummer);

			} catch (Exception e) {
				break;
			}
		}
	}
	/**
	 * Withdraws the amount from the ATM and updates the account balance
	 * 
	 * @param amount     The amount to withdraw
	 * @param kontonummer The account number of the user
	 * 
	 * Uses the class NutzerKonto to manage the account balance and stroes it in a hashmap to manage dynamic account creation
	 * Checks for negative amounts and if the amount exceeds the available money in the ATM or Account balance
	 */


	public void cashout(float amount, String kontonummer) {
		if(amount < 0) {
			System.out.println("Negative amount not allowed.");

		} else if(amount > availableMoney) {
			System.out.println("Amount exceeds available Money.");

		} else {
					try {
			NutzerKonto konto = konten.get(kontonummer);
			if(konto == null) {
			NutzerKonto neuesKonto = new NutzerKonto(kontonummer);
			konten.put(kontonummer, neuesKonto);
				
			}

		} catch (Exception e) {
			NutzerKonto neuesKonto = new NutzerKonto(kontonummer);
			konten.put(kontonummer, neuesKonto);

		}
		NutzerKonto konto = konten.get(kontonummer);

			if(konto.getKontostand() >= amount) {
				konto.abheben(amount);
				availableMoney -= amount;
				System.out.println("You have withdrawn: " + amount + " euros.");
				System.out.println("Available money in ATM: " + availableMoney + " euros.");
				System.out.println("Your new account balance is: " + konto.getKontostand() + " euros.");
			} else {
				System.out.println("Insufficient funds in the account.");
			}
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
