package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	int[] accountNumbers = {1001, 1002, 1003};
	int[] accountBalances = {200, 150, 500};
	int cashInMachine = 1000; 

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accNumber = Integer.parseInt(br.readLine());

				int index = findAccount(accNumber);
				if (index == -1) {
					System.out.println("Account not found.");
					continue;
				}

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());

				cashout(index, amount);

			} catch (Exception e) {
				System.out.println("Invalid input. Exiting.");
				break;
			}
		}
	}

	public int findAccount(int accNumber) {
		for (int i = 0; i < accountNumbers.length; i++) {
			if (accountNumbers[i] == accNumber) {
				return i;
			}
		}
		return -1;
	}

	public void cashout(int index, int amount) {
		if (amount > accountBalances[index]) {
			System.out.println("Sorry, not enough money in your account.");
		} else if (amount > cashInMachine) {
			System.out.println("Sorry, the ATM doesn't have enough cash.");
		} else {
			accountBalances[index] = accountBalances[index] - amount;
			cashInMachine = cashInMachine - amount; 
			System.out.println("Ok, here is your money, enjoy!");
		}
	}

	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}