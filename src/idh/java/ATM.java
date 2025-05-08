package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    int atmCashAvailable = 500;
    Map<Integer, Integer> accounts = new HashMap<>();

    public ATM() {
        accounts.put(123, 100);
        accounts.put(666, 600);
        accounts.put(777, 700);
	accounts.put(444, 401);
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());

                if (!accounts.containsKey(accountNumber)) {
                    System.out.println("Account not found.");
                    continue;
                }
								
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                cashout(accountNumber, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        int balance = accounts.get(accountNumber);

        if (amount > atmCashAvailable) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore. Best I can do is "+ atmCashAvailable + ". Please try again tomorrow.");
        } else if (amount > balance) {
            System.out.println("Oops. Low balance: " + balance + " Äpfel.");
        } else {
            atmCashAvailable -= amount;
           	accounts.put(accountNumber, balance - amount);
            System.out.println("Ok, here you go! Your new balance: " + (balance-amount));
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
