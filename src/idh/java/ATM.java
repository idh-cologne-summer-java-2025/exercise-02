package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> accounts = new HashMap<>();
    private int atmCash = 500; // Bargeld im Automaten

    public ATM() {
        // Beispielhafte Initialisierung von Konten
        accounts.put(123, 100);
        accounts.put(234, 200);
        accounts.put(345, 300);
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());

                if (!accounts.containsKey(accountNumber)) {
                    System.out.println("Unknown account number.");
                    continue;
                }

                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                cashout(accountNumber, amount);
            } catch (Exception e) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        int accountBalance = accounts.get(accountNumber);

        if (amount > accountBalance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else if (amount > atmCash) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } else {
            // Auszahlung möglich
            accounts.put(accountNumber, accountBalance - amount);
            atmCash -= amount;
            System.out.println("Ok, here you go!");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
