package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    int[] accountNumbers = {123, 234, 345};
    int[] accountBalances = {500, 400, 60};
    int atmBalance = 1000;

    int currentUserIndex = -1; // Welcher User ist eingeloggt?

    public void enter() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int input = Integer.parseInt(br.readLine());

                boolean found = false;
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (input == accountNumbers[i]) {
                        currentUserIndex = i;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    throw new RuntimeException("This account number is not valid");
                }

                System.out.println("Welcome! Your balance is: " + accountBalances[currentUserIndex]);
                break; // Konto erkannt – raus aus Schleife

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void run() {
        enter(); // Benutzer einloggen

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                cashmanagement(amount);
                cashout(amount);

            } catch (Exception e) {
                System.out.println("Transaction failed: " + e.getMessage());
                break;
            }
        }
    }

    public void cashout(int amount) {
        if (amount > accountBalances[currentUserIndex]) {
            throw new RuntimeException("Sorry, you don't have enough money in your account.");
        }

        accountBalances[currentUserIndex] -= amount;
        atmBalance -= amount;
        System.out.println("Ok, here is your money, enjoy!");
        System.out.println("Your new balance is: " + accountBalances[currentUserIndex]);
    }

    public void cashmanagement(int amount) {
        if (amount > atmBalance) {
            throw new RuntimeException("Sorry, the ATM doesn't have that much cash anymore.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
