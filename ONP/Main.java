import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Kolejka kolejka = new Kolejka();
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj wyrazenie:");
        String string;
        String tmp;
        
        string = odczyt.nextLine();
        double wynik;
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        while (stringTokenizer.hasMoreTokens()) {
            tmp = stringTokenizer.nextToken();
            kolejka.dodaj(tmp);
        }
        //kolejka.wyswietl();
        if(Funkcje.czyPoprawnyZapis(kolejka)) {
            Kolejka wyjscie = ONP.onp(kolejka);
            wyjscie.wyswietl();
            wynik = ONP.wynik(wyjscie);
            System.out.format("%.2f%n",wynik);
        } else {
            System.out.println("Zły zapis ");
        }   
    }
}
