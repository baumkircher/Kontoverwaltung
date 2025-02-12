class Sparkonto extends Basis {
    public Sparkonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontostand, "Sparkonto");
    }

    @Override
    public boolean abheben(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println(betrag + " EUR abgehoben. Neuer Kontostand: " + kontostand + " EURO");
            return true;
        }
        System.out.println("Nicht genug Guthaben auf dem Sparkonto.");
        return false;
    }
}
