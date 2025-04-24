package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int ATMbalance = 3000;
	

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(BenutzerInnen[] KundInnen) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter your account number: ");
				int accountnumber = Integer.parseInt(br.readLine());
				BenutzerInnen Kunde = findCustomer(accountnumber, KundInnen);
				if (Kunde!= null) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount, Kunde);
				}
				
			} catch (Exception e) {
				break;
			}
		}
	}
	public BenutzerInnen findCustomer(int accountnumber, BenutzerInnen[] KundInnen) {
		for (int i = 0; i < KundInnen.length; i++) {
			if (accountnumber == KundInnen[i].kontonummer) {
				return KundInnen[i];
			}
		}System.out.println("Sorry, you do not seem to be a customer here.");
		return null;
		
		
		
	}

	public void cashout(int amount, BenutzerInnen Kunde) {
		if (ATMbalance >= amount) {
			if (amount <= Kunde.kontostand) {
				Kunde.kontostand = Kunde.kontostand - amount;
				System.out.println("Ok, here is your money, enjoy!");
				ATMbalance -= amount;
			} else System.out.println("Sorry, not enough money in the bank.");
		} else System.out.println("Sorry, the ATM does not have that much cash anymore.");
		

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		BenutzerInnen[] KundInnen = new BenutzerInnen[5];
		KundInnen[0] = new BenutzerInnen (123, 1500);
		KundInnen[1] = new BenutzerInnen(234, 2000);
		KundInnen[2] = new BenutzerInnen (456, 1500);
		KundInnen[3] = new BenutzerInnen(789, 2000);
		KundInnen[4] = new BenutzerInnen (891, 1500);

		atm.run(KundInnen);
		
	}

}
