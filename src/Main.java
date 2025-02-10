import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Girokonto> konten = new ArrayList<Girokonto>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Wähle:");
        System.out.println("1..Girokonto anlegen");
        System.out.println("2..Kreditkonto anlegen");
        System.out.println("3..Sparkonto anlegen");
        System.out.println("4..Übersicht");
        System.out.println("5..Einzahlen");
        System.out.println("6..Abheben");
        System.out.println("7..Konto auflösen");
        System.out.println("0..Exit");

        while (true) {
            switch (input.nextInt()) {
                case 1:
                    input.nextLine();
                    System.out.println("Kontoinhaber:");
                    String inhaber = input.nextLine();
                    System.out.println("Bankleitzahl:");
                    String blz = input.nextLine();
                    System.out.println("Kontonummer:");
                    String knr = input.nextLine();
                    System.out.println("Startkontostand:");
                    double stand = input.nextDouble();
                    konten.add(new Girokonto(inhaber, blz, knr, stand));
                    System.out.println("GiroKonto wurde erfolgeich erstellt");
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Kontoinhaber:");
                    inhaber = input.nextLine();
                    System.out.println("Bankleitzahl:");
                    blz = input.nextLine();
                    System.out.println("Kontonummer:");
                    knr = input.nextLine();
                    System.out.println("Startkontostand:");
                    stand = input.nextDouble();
                    konten.add(new Girokonto(inhaber, blz, knr, stand));
                    System.out.println("Sparkonto erfolgreich erstellt: " + knr);
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Kontoinhaber:");
                    inhaber = input.nextLine();
                    System.out.println("Bankleitzahl:");
                    blz = input.nextLine();
                    System.out.println("Kontonummer:");
                    knr = input.nextLine();
                    System.out.println("Startkontostand:");
                    stand = input.nextDouble();
                    konten.add(new Girokonto(inhaber, blz, knr, stand));
                    System.out.println("Kreditkonto erfolgreich erstellt: " + knr);
                    break;
                case 4:
                    for (Basis konto : konten) {
                        konto.kontoauszug();
                    }
                    break;
                case 5:
                    System.out.println("Kontonummer eingeben:");
                    String kontoNummer = input.next();
                    System.out.println("Betrag eingeben:");
                    double betrag = input.nextDouble();
                    for (Basis konto : konten) {
                        if (konto.getKontonummer().equals(kontoNummer)) {
                            konto.einzahlen(betrag);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Kontonummer eingeben:");
                    kontoNummer = input.next();
                    System.out.println("Betrag eingeben:");
                    betrag = input.nextDouble();
                    for (Basis konto : konten) {
                        if (konto.getKontonummer().equals(kontoNummer)) {
                            konto.abheben(betrag);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Kontonummer eingeben:");
                    kontoNummer = input.next();
                    System.out.println("Konto " + kontoNummer + " wurde aufgelöst.");
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
}
