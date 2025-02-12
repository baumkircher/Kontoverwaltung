class Girokonto extends Basis {
    public Girokonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontostand, "Girokonto");
    }

    @Override
    public boolean abheben(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println(betrag + " abgehoben - Neuer Kontostand: " + kontostand + " EURO");
            return true;
        }
        System.out.println("Ungültiger Betrag oder nicht genügend Guthaben.");
        return false;
    }
}