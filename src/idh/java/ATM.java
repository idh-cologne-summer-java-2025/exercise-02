package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap; 
import java.util.Map; // neu dazugekommen accounts anlegen und dann mit key prinzip arbeiten acc.put(int, int)

public class ATM {
    // Der Automat hat einen Bargeldbestand
    int atmBalance = 10000;

    // Eine Map zur Verwaltung der Konten (ID -> Kontostand)
    Map<Integer, Integer> accounts = new HashMap<>();

    // Initiale Konten und deren Kontostände
    public ATM() {
        // Beispielhafte Konten mit Anfangsbeträgen
        accounts.put(1, 17000); //accnr, kto-stand
        accounts.put(2, 5300);   
        accounts.put(3, 107);  	  
    }

    /**
     * Main command loop of the ATM.
     * Erst muss die Kontonummer eingegeben werden, danach der Betrag.
     * Der Automat prüft, ob das Konto genug Guthaben hat und ob genügend Bargeld vorhanden ist.
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                // Kontonummer eingeben
                System.out.print("Please, Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());

                // Prüfen, ob das Konto existiert
                if (!accounts.containsKey(accountNumber)) {
                    System.out.println("Sorry, account not found.");
                    continue;
                }

                // Betrag eingeben
                System.out.print("Please, Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());

                // Auszahlung durchführen
                cashout(accountNumber, amount);
            } catch (Exception e) {
                break; // Bei ungültiger Eingabe wird das Programm beendet
            }
        }
    }

    /**
     * Verarbeitet die Auszahlung.
     * Es wird geprüft, ob das Konto ausreichend Guthaben hat und ob der Automat genug Bargeld hat.
     */
    public void cashout(int accountNumber, int amount) {
        int accountBalance = accounts.get(accountNumber);

        // Prüfen, ob der Benutzer genug Geld hat
        if (amount > accountBalance) {
            System.out.println("† Oh No! It seems you have insufficient Funds †");
            return;
        }

        // Prüfen, ob der Automat genug Bargeld hat
        if (amount > atmBalance) {
            System.out.println("Sorree~ I'm Empty? - We might need to adjust that amount");
            return;
        }

        // Wenn alles passt, wird das Geld abgehoben
        accounts.put(accountNumber, accountBalance - amount); // Konto aktualisieren
        atmBalance -= amount; // Bargeldbestand des Automaten aktualisieren
        System.out.println("Withdrawal approved, Have a lovely Day ♥♥♥");
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
