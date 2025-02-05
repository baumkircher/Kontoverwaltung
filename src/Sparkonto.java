public class Sparkonto extends Basis{


    public Sparkonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontostand, String kontoart) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontostand, kontoart);
    }

    @Override
    public void abheben(double betrag) {
        if (kontostand >= betrag) {
            kontostand -= betrag;
            System.out.println(betrag + " EUR abgehoben. Neuer Kontostand: " + kontostand + " EURO");
        } else {
            System.out.println("Nicht genug Guthaben auf dem Sparkonto.");
        }
    }
}
