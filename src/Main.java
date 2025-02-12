import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Basis> konten = new ArrayList<Basis>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Wähle:");
            System.out.println("1..Girokonto anlegen");
            System.out.println("2..Kreditkonto anlegen");
            System.out.println("3..Sparkonto anlegen");
            System.out.println("4..Übersicht");
            System.out.println("5..Einzahlen");
            System.out.println("6..Abheben");
            System.out.println("7..Überweisung");
            System.out.println("8..Konto auflösen");
            System.out.println("0..Exit");

            switch (input.nextInt()) {
                case 1:
                    anlegen("Girokonto");
                    break;
                case 2:
                    anlegen("Kreditkonto");
                    break;
                case 3:
                    anlegen("Sparkonto");
                    break;
                case 4:
                    for (Basis konto : konten) {
                        konto.kontoauszug();
                    }
                    break;
                case 5:
                    einzahlen();
                    break;
                case 6:
                    abheben();
                    break;
                case 7:
                    ueberweisen();
                    break;
                case 0:
                    System.out.println("Programm beendet");
                    input.close();
                    return;
                default:
                    System.out.println("Ungültige Eingabe.");
                    break;
            }
        }
    }

    private static void anlegen(String kontoTyp) {
        input.nextLine();
        System.out.println("Kontoinhaber:");
        String inhaber = input.nextLine();
        System.out.println("Bankleitzahl:");
        String blz = input.nextLine();
        System.out.println("Kontonummer:");
        String knr = input.nextLine();
        System.out.println("Startkontostand:");
        double stand = input.nextDouble();
        if (kontoTyp.equals("Girokonto")) {
            konten.add(new Girokonto(inhaber, blz, knr, stand));
        } else if (kontoTyp.equals("Kreditkonto")) {
            System.out.println("Kreditlimit:");
            double limit = input.nextDouble();
            konten.add(new Kreditkonto(inhaber, blz, knr, stand, limit));
        } else {
            konten.add(new Sparkonto(inhaber, blz, knr, stand));
        }
        System.out.println(kontoTyp + " erfolgreich erstellt: " + knr);
    }

    private static void einzahlen() {
        System.out.println("Kontonummer eingeben:");
        String kontoNummer = input.next();
        System.out.println("Betrag eingeben:");
        double betrag = input.nextDouble();
        for (Basis konto : konten) {
            if (konto.getKontonummer().equals(kontoNummer)) {
                konto.einzahlen(betrag);
            }
        }
    }

    private static void abheben() {
        System.out.println("Kontonummer eingeben:");
        String kontoNummer = input.next();
        System.out.println("Betrag eingeben:");
        double betrag = input.nextDouble();
        for (Basis konto : konten) {
            if (konto.getKontonummer().equals(kontoNummer)) {
                konto.abheben(betrag);
            }
        }
    }

    private static void ueberweisen() {
        System.out.println("Von Kontonummer:");
        String von = input.next();
        System.out.println("Zu Kontonummer:");
        String zu = input.next();
        System.out.println("Betrag eingeben:");
        double betrag = input.nextDouble();
        Basis kontoVon = null, kontoZu = null;
        for (Basis konto : konten) {
            if (konto.getKontonummer().equals(von)) {
                kontoVon = konto;
            } else if (konto.getKontonummer().equals(zu)) {
                kontoZu = konto;
            }
        }
        if (kontoVon != null && kontoZu != null) {
            kontoVon.ueberweisen(kontoZu, betrag);
        } else {
            System.out.println("Überweisung fehlgeschlagen: Konto nicht gefunden.");
        }
    }
}
