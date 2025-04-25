package idh.java;

public class NutzerKonto {
    private String kontonummer;
    private float kontostand;

    public NutzerKonto(String kontonummer) {

        this.kontonummer = kontonummer;
        this.kontostand = 1500.0f; // Initialer Kontostand
    }

    public void einzahlen(float betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println("Einzahlung erfolgreich: " + betrag + " Euro.");
        } else {
            System.out.println("Ungültiger Betrag.");
        }
    }

    public void abheben(float betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println("Abhebung erfolgreich: " + betrag + " Euro.");
        } else {
            System.out.println("Ungültiger Betrag oder unzureichender Kontostand.");
        }
    }

    public float getKontostand() {
        return kontostand;
    }

    public String getKontonummer() {
        return kontonummer;
    }


}
