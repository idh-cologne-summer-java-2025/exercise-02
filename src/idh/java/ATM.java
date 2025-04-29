package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//changing sth
public class ATM {
	int accountBalance = 1000;
	User users[] = new User[5]; //Array with UserObjects, needs to be filled though ..., could write a method for creating User Objects and putting them in the Array, not this time though
	User u1 = new User(1, 50);
	User u2 = new User(2, 120);
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter ID: ");
				int id = Integer.parseInt(br.readLine());
				for(int i = 0; i < users.length; i++) {
					if(users[i].getId()==id) {
						System.out.print("Welcome UserID " + id + "Balance of User " + users[i].getId() + ":"  + users[i].getBalance());
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(amount);
					}else {
						System.out.println("No such ID.");
					}
					}
				} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
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
