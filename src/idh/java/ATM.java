package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//changing sth
public class ATM {
	int accountBalance = 1000;
	User users[] = new User[2]; //Array with UserObjects, needs to be filled though ... could write a method for creating User Objects and putting them in the Array, not necessary this time.
	User u1 = new User(1, 50);
	User u2 = new User(2, 120);
//	trying to fill users-array with User objects, some kind of syntax error seems to occur 
//	users[1] = u1;
//	users[2] = u2;
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
//				for(int i = 0; i < users.length; i++) {
//					if(users[i].getId()==id) {
//						System.out.print("Welcome UserID " + id + "Balance of User " + users[i].getId() + ":"  + users[i].getBalance());
//		relocate everything above into cashout() 
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(id, amount);	
					}
				 catch (Exception e) {
				System.err.println("Something went wrong.");
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int id, int amount) {
		for(int j = 0; j<users.length; j++) {
		if (id==users[j].getId() && amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
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
