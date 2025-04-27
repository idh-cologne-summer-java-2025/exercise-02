package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class ATM {
    //Map ist eine tabelle die Key und value speichert, 
	//Key darf nur ein mal vorkommen und könnte z.b die Kontonzmmer sein
	//string ist der typ des Keys (kontonummer als text), Integer ist der typ des wertes (kontostand als zahl)
    private Map<String, Integer> accountBalances = new HashMap<>();
    //mit map kann man mehrere kontostände verwalten
    
    //wie viel geld dem automaten gerade zur verfügung steht 
    private int cashAvailable = 10000; 
    
    public ATM() {
        //ein fester kontoinhaber mit der kontonummer 190723101542, hat 4215€ auf dem konto
        accountBalances.put("190723101542", 4215);
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        while (true) { //schleife bis kein geld mehr vorhanden ist
            try {
                //nach kontonummer fragen
                System.out.print("Geben Sie Ihre Kontonummer ein: ");
                String accountNumber = br.readLine();

                //wenn das konto noch nicht existiert, wird neues konto mit 100€ erstellt
                if (!accountBalances.containsKey(accountNumber)) {
                    accountBalances.put(accountNumber, 100);
                    System.out.println("Glückwunsch, Sie haben ein neues Konto mit 100€ Startguthaben");
                }

                //nach auszahlungsbetrag fragen
                System.out.print("Auszahlung, Betrag eingeben: ");
                int amount = Integer.parseInt(br.readLine());

                //geld abheben
                cashout(accountNumber, amount);

            } catch (Exception e) {
                //bei fehler wird die Schleife beendet (ungültige eingabe, kein geld)
                System.out.println("Fehler: " + e.getMessage());
                break;
            }
        }
    }

    //methode zum Geld abheben
    public void cashout(String accountNumber, int amount) {
        //aktueller kontostand
        int balance = accountBalances.get(accountNumber);

        //prüfen, ob genug geld vorhanden ist (konto)
        if (amount > balance) {
            System.out.println("Sie haben kein ausreichendes Guthaben");
        }
        //prüfen, ob genug geld vorhanden ist (automat)
        else if (amount > cashAvailable) {
            System.out.println("Der Automathat nicht genug Geld und kann den Betrag leider nicht auszahlen");
        }
        //wenn genug geld auf dem konto ist
        else {
            //kontostand und automat aktualisieren 
            accountBalances.put(accountNumber, balance - amount);
            cashAvailable -= amount;

            System.out.println("Ihr aktueller Kontostand: " 
                + accountBalances.get(accountNumber) + "€. Aktueller Geldstand im Automaten: " 
                + cashAvailable + "€.");
        }
    }

    //startet Automaten
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}

