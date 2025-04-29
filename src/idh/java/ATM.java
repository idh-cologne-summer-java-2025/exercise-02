package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    // Konto-Daten: Kontonummer → Kontostand
    private Map<Integer, Integer> accounts = new HashMap<>();
    
    // Bargeldbestand des Automaten
    private int cashInATM = 200;

    public ATM() {
        // Beispielkonten: Kontonummern und Startguthaben
        accounts.put(123, 54);
        accounts.put(234, 78);
        accounts.put(345, 250);
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
                System.out.println("Invalid input. Exiting.");
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        int accountBalance = accounts.get(accountNumber);

        if (amount > accountBalance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else if (amount > cashInATM) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        } else {
            accounts.put(accountNumber, accountBalance - amount);
            cashInATM -= amount;
            System.out.println("Ok, here you go!");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}

