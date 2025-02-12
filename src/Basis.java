public class Basis {
    protected String kontoinhaber;
    protected String bankleitzahl;
    protected String kontonummer;
    protected double kontostand;
    protected String kontoart;

    public Basis(String kontoinhaber, String bankleitzahl, String kontonummer, double kontostand, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println(betrag + " eingezahlt - Neuer Kontostand: " + kontostand + " EURO");
        }
    }

    public boolean ueberweisen(Basis zielkonto, double betrag) {
        if (this.abheben(betrag)) {
            zielkonto.einzahlen(betrag);
            System.out.println("Überweisung erfolgreich: " + betrag + " EURO von " + this.kontonummer + " zu " + zielkonto.kontonummer);
            return true;
        }
        System.out.println("Überweisung fehlgeschlagen.");
        return false;
    }

    public boolean abheben(double betrag) {
        return false; // Wird von Unterklassen implementiert
    }
    public void kontoauszug() {
        System.out.println("Kontoinhaber: " + kontoinhaber);
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Kontostand: " + kontostand + " EUR");
    }

    public String getKontonummer() {
        return kontonummer;
    }
}
