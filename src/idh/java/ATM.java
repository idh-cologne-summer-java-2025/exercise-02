package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ATM {
	int ATMBalance;
	
	public ATM(int balance) {
		ATMBalance = balance;
	}
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// Liste der Konten gespeichert sind
	ArrayList<Account> accounts = new ArrayList<>();

	public void addAccountToList(int id) {
		accounts.add(new Account(id));
	}

	// Findet Index in Liste
	public int findAccountIndexById(int id) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getid() == id) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	// Hauptmenü des ATM
	public void run() {
		while (true) {
			try {
				System.out.println("Welcome! How can I help you? Please type in number.");
				System.out.println(" 1. Create new Account  \n 2. Cashout \n 3. Deposit");

				int value = Integer.parseInt(br.readLine());
				if (value == 1) {
					newAccount();
				} else if (value == 2) {

					startCashout();
				} else if (value == 3) {

					startDeposit();

				}

			} catch (Exception e) {
				break;
			}
		}
	}

	// Erstellt neues Konto mit Guthaben
	public void newAccount() {
		int id;
		int amount;
		while (true) {
			try {
				System.out.print("Create new Account-ID: ");
				id = Integer.parseInt(br.readLine());
				addAccountToList(id);
				System.out.println("Success! You created an account with the ID " + id);
				System.out.println();
				System.out.println("How much money would you like to deposit?");
				amount = Integer.parseInt(br.readLine());
				this.ATMBalance += amount;
				accounts.get(findAccountIndexById(id)).deposit(amount);
				run();

			} catch (Exception e) {
				break;
			}
		}

	}

	// Eingabe und überprüfung der ID 
	
	public int enterID() {

		try {
			System.out.print("Enter your Account ID: ");
			int id = Integer.parseInt(br.readLine());
			int index = findAccountIndexById(id);
			if (index != -1) {
				return index;
			} else {
				System.out.println("Account not found.");
			}
		} catch (Exception e) {
			System.out.println("Invalid ID.");
		}
		return -1;
	}

	// Zahlt Geld auf Konto ein WIP
	public void startDeposit() {
		int index = enterID();
        if (index == -1) 
        	return;

        try {
            System.out.print("Enter amount to deposit: ");
            int amount = Integer.parseInt(br.readLine());
            this.ATMBalance = this.ATMBalance + amount;

            accounts.get(index).deposit(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount.");
        }
	}

	// Zahlt Geld aus WIP
	public void startCashout() {
		int index = enterID();
        if (index == -1) return;

        try {
            System.out.print("Enter amount to withdraw: ");
            int amount = Integer.parseInt(br.readLine());

            if (amount > ATMBalance) {
                System.out.println("ATM does not have enough cash.");
                return;
            }

            if (accounts.get(index).cashout(amount) == true) {
                ATMBalance = ATMBalance - amount;
            }
        } catch (Exception e) {
            System.out.println("Invalid amount.");
        }
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM(100);
		atm.run();
	};

}
