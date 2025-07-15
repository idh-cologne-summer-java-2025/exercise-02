package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap; // Importiert HashMap für die Kontenverwaltung
import java.util.Map;    // Importiert die Map-Schnittstelle

public class ATM {

    // Verwenden einer Map, um Kontonummern (Integer) und Kontostände (Integer) zu speichern.
    private Map<Integer, Integer> accounts;
    // Variable zur Speicherung des aktuellen Bargeldbestands im Geldautomaten.
    private int atmCashBalance;

    /**
     * Konstruktor für die ATM-Klasse.
     * Initialisiert die Beispielkonten und den anfänglichen Bargeldbestand des Automaten.
     */
    public ATM() {
        accounts = new HashMap<>();
        // Fügen Sie hier Beispielkonten mit ihren Anfangssalden hinzu.
        // Format: accounts.put(Kontonummer, Kontostand);
        accounts.put(123, 500);  // Konto 123 hat 500 Währungseinheiten
        accounts.put(234, 150);  // Konto 234 hat 150 Währungseinheiten
        accounts.put(345, 1200); // Konto 345 hat 1200 Währungseinheiten
        accounts.put(456, 1500); // Konto 456 hat 1500 Währungseinheiten

        // Legen Sie den anfänglichen Bargeldbestand des Geldautomaten fest.
        atmCashBalance = 3000; // Der Automat startet mit 2000 Währungseinheiten Bargeld
    }

    /**
     * Hauptbefehlsschleife des Geldautomaten.
     * Fragt den Benutzer nach seiner Kontonummer und dem abzuhebenden Betrag.
     * Übergibt diese Informationen an die Methode processWithdrawal(...),
     * die die eigentliche Logik und die Aktualisierungen durchführt.
     * Wenn der Benutzer ungültige Eingaben macht (keine Zahl), wird eine Fehlermeldung ausgegeben
     * und die Schleife fortgesetzt oder beendet, je nach Fehlerart.
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the ATM!");

        while (true) {
            try {
                // Schritt 1: Kontonummer abfragen
                System.out.print("Enter your account number (or type 'exit' to quit): ");
                String accountNumStr = br.readLine();

                // Prüfen, ob der Benutzer das Programm beenden möchte
                if (accountNumStr == null || accountNumStr.trim().equalsIgnoreCase("exit")) {
                    break;
                }

                int accountNumber = Integer.parseInt(accountNumStr.trim());

                // Schritt 2: Abhebungsbetrag abfragen
                System.out.print("Enter the amount to withdraw: ");
                String amountStr = br.readLine();

                 // Prüfen auf leere Eingabe für Betrag
                if (amountStr == null || amountStr.trim().isEmpty()) {
                     System.out.println("Invalid amount entered. Please try again.");
                     continue; // Nächste Iteration der Schleife
                }

                int amount = Integer.parseInt(amountStr.trim());

                // Schritt 3: Auszahlungsprozess aufrufen
                processWithdrawal(accountNumber, amount);

                // Optional: Zeigt den verbleibenden Bargeldbestand des Automaten an
                System.out.println("(ATM cash remaining: " + this.atmCashBalance + ")");
                System.out.println("------------------------------------"); // Trennlinie für bessere Lesbarkeit

            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter numbers only for account and amount.");
                // Die Schleife wird fortgesetzt, um eine neue Eingabe zu ermöglichen
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Gibt detaillierte Fehlermeldung aus (für Debugging)
                break; // Beendet die Schleife bei unerwarteten Fehlern
            }
        }
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    /**
     * Verarbeitet die Auszahlungsanforderung.
     * Prüft, ob das Konto existiert, ob genügend Geld auf dem Konto ist
     * und ob der Geldautomat genügend Bargeld hat.
     * Aktualisiert den Kontostand und den Bargeldbestand des Automaten bei erfolgreicher Auszahlung.
     *
     * @param accountNumber Die Kontonummer des Benutzers.
     * @param amount Der abzuhebende Betrag.
     */
    public void processWithdrawal(int accountNumber, int amount) {
        // Validierung: Betrag muss positiv sein
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be a positive number.");
            return; // Beendet die Methode hier
        }

        // 1. Prüfen, ob das Konto existiert
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Sorry, account number " + accountNumber + " was not found.");
            return; // Beendet die Methode hier
        }

        // Hole den aktuellen Kontostand
        int currentAccountBalance = accounts.get(accountNumber);

        // 2. Prüfen, ob der *Geldautomat* genug Bargeld hat
        if (amount > this.atmCashBalance) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
            return; // Beendet die Methode hier
        }

        // 3. Prüfen, ob das *Konto* genug Guthaben hat
        if (amount > currentAccountBalance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
            return; // Beendet die Methode hier
        }

        // 4. Wenn alle Prüfungen erfolgreich sind: Auszahlung durchführen
        // Aktualisiere den Kontostand
        accounts.put(accountNumber, currentAccountBalance - amount);
        // Aktualisiere den Bargeldbestand des Automaten
        this.atmCashBalance -= amount; // Kurzform für: this.atmCashBalance = this.atmCashBalance - amount;

        System.out.println("Ok, here you go!");
        // Optional: Zeige dem Benutzer den neuen Kontostand an
        System.out.println("Your new account balance is: " + accounts.get(accountNumber));
    }

    /**
     * Startet den Geldautomaten.
     */
    public static void main(String[] args) {
        ATM atm = new ATM(); // Erzeugt eine neue Instanz des Geldautomaten (mit Konten und Bargeld)
        atm.run();           // Startet die Hauptschleife des Automaten
    }
}