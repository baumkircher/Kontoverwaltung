public class Girokonto
{
    private static int cntKonto = 1;
    private int kontoNummer;

    Girokonto () {
        this.kontoNummer = cntKonto++;
    }

    public int getKontoNummer(){
        return kontoNummer;
    }
}