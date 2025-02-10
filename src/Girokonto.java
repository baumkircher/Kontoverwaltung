class Girokonto extends Basis {
    public Girokonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontostand, "Girokonto");
    }

    @Override
    public void abheben(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println(betrag + " abgehoben - Neuer Kontostand: " + kontostand + " EURO");
        } else {
            System.out.println("Ungültiger Betrag oder nicht genügend Guthaben.");
        }
    }
}