import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Girokonto> konten = new ArrayList<Girokonto>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Wähle:");
        System.out.println("1..Konto anlegen");
        System.out.println("2..Übersicht");
        System.out.println("3..Einzahlen");
        System.out.println("4..Abheben");
        System.out.println("5..Konto auflösen");
        System.out.println("0..exit");

        while (true) {
            switch (input.nextInt()) {
                case 1:
                    Girokonto temp = new Girokonto();
                    konten.add(temp);
                    break;
                case 2:
                    if (konten.isEmpty()) {
                        System.out.println("Keine Konten vorhanden.");
                    } else {
                        for (Girokonto konto : konten) {
                            System.out.println("Kontotype: " + konto.getClass().getSimpleName() +
                                    " | Kontonummer: " + konto.getKontoNummer());
                        }
                    }
                    break;
                case 3:

                    System.out.println("Einzahlung");
                    break;
                case 4:
                    System.out.println("Abheben");
                    break;
                case 5:
                    System.out.println("Kontoauflösung");
                    break;
                case 0:
                    System.out.println("Programm beendet");
                    input.close();
                    return;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }
}
