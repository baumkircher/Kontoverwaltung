class Kreditkonto extends Basis {
    private double kreditlimit;

    public Kreditkonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontostand, double kreditlimit) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontostand, "Kreditkonto");
        this.kreditlimit = kreditlimit;
    }

    @Override
    public void abheben(double betrag) {
        if (betrag > 0 && (kontostand - betrag) >= -kreditlimit) {
            kontostand -= betrag;
            System.out.println(betrag + " abgehoben - Neuer Kontostand: " + kontostand + " EURO");
        } else {
            System.out.println("Limit überschritten!");
        }
    }
}