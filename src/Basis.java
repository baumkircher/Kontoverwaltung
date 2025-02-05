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

    // Methode zum Einzahlen eines Betrags auf das Konto
    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println(betrag + "eingezahlt - Neuer Kontostand: " + kontostand + " EURO");
        }
    }

    // Abstrakte Methode für das Abheben von Geld, wird in den Unterklassen implementiert
    public void abheben(double betrag) {

    }

    // Gibt den aktuellen Kontoauszug aus
    public void kontoauszug() {
        System.out.println("Kontoinhaber: " + kontoinhaber);
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Kontostand: " + kontostand + " EUR");
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public String getBankleitzahl() {
        return bankleitzahl;
    }

    public void setBankleitzahl(String bankleitzahl) {
        this.bankleitzahl = bankleitzahl;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public String getKontoart() {
        return kontoart;
    }

    public void setKontoart(String kontoart) {
        this.kontoart = kontoart;
    }
}

