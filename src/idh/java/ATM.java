package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

    int[] accountNumbers = {123, 234, 345};
    int[] accountBalances = {200, 300, 40};
    int cashAvailable = 500; // Bargeld im Automaten

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Enter your account number (or 'exit' to end the process): ");
                String input = br.readLine();
                if (input.equalsIgnoreCase("exit")) break;

                int enteredAccount = Integer.parseInt(input);
                int index = findAccountIndex(enteredAccount);

                if (index == -1) {
                    System.out.println("Unknown number!");
                    continue;
                }

                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                cashout(index, amount);

            } catch (Exception e) {
                System.out.println("something went wronr. Try again.");
            }
        }

        System.out.println("Bye");
    }

    private int findAccountIndex(int accountNumber) {
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accountNumber) {
                return i;
            }
        }
        return -1; // Konto nicht gefunden
    }

    public void cashout(int index, int amount) {
        int userBalance = accountBalances[index];

        if (amount > userBalance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else if (amount > cashAvailable) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } else {
            accountBalances[index] -= amount;
            cashAvailable -= amount;
            System.out.println("OK, here you go.");
        }

    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
