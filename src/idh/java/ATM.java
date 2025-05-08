package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ATM {
	 int cashATM = 3000;
	 int[] accountIDs = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010};
	 int[] balances = {700, 300, 2050, 1020, 1500, 600, 4000, 500, 10, 3000};
	
	
	 
	 /**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Please enter your account ID: ");
				int accountID = Integer.parseInt(br.readLine());
				
				int index = accountFinder(accountID);
				if (index == -1) {
					System.out.println("Unknown AccountID");
				}
				
				System.out.print("Please enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(index,amount);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(int index, int amount) {
		if(amount > balances[index]) {
			System.out.println("Sorry, not enough balance");
		} else if (amount > cashATM) {
			System.out.println("Sorry. not enough cash in the ATM");
		} else {
			balances[index] = balances[index] - amount;
			cashATM = cashATM - amount;
			System.out.println("Ok, here is your money! Remaining Balance is: "+balances[index]+"$");
		}
			}
	/**
	 * Searches the array for the accountID. If found returns array Index, if not, returns -1
	 */
	public int accountFinder(int accountID) {
		for (int i= 0; i < accountIDs.length;i++) {
			if (accountIDs[i] == accountID) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
	
	
		
}