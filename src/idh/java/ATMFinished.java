package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATMFinished {

    int bargeldStand= 100;

    // accounts
    Konto[] konten = new Konto[5];

    public ATMFinished() {
	// create accounts with varying balances
	Random random = new Random();
	for (int i = 0; i < konten.length; i++) {
	    konten[i] = new Konto(i, random.nextInt(1000));
	}
    }

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
		System.out.print("Enter the amount to withdraw: ");
		int amount = Integer.parseInt(br.readLine());
		cashout(accountNumber, amount);
	    } catch (Exception e) {
		e.printStackTrace();
		break;
	    }
	}
    }

    public void cashout(int kontoNummer, int amount) {
	// check for cash in the ATM
	if (amount > bargeldStand) {
	    System.out.println("Sorry, not enough cash left.");
	    return;
	}

	// check for existence of the account
	Konto konto = getKonto(kontoNummer);
	if (konto == null) {
	    System.out.println("Sorry, this account doesn't exist.");
	    return;
	}

	// check for balance of the account
	if (amount > konto.getBalance()) {
	    System.out.println("Sorry, you don´t have enough money.");
	    return;
	}

	konto.withdraw(amount);
	bargeldStand = bargeldStand - amount;
	System.out.println("Ok, here is your money, enjoy!");

    };

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
	ATM atm = new ATM();
	atm.run();
    };

    /**
     * Gets the account with a given id.
     */
    public Konto getKonto(int id) {
	for (int i = 0; i < konten.length; i++) {
	    if (konten[i].getId() == id)
		return konten[i];
	}
	return null;
    }

}