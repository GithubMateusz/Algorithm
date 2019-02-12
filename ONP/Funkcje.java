import java.util.StringTokenizer;

public class Funkcje {
    public static int priorytety(String znak) {
        if ("+".equals(znak) || "~".equals(znak) || ")".equals(znak)) {
            return 1;
        } else if ("*".equals(znak) || "/".equals(znak) || "%".equals(znak)) {
            return 2;
        } else if ("^".equals(znak) ) {
            return 3;
        } else {
            return 0;
        }
    } 
    
    public static int rodzajOperatora(String znak) {
        if ("(".equals(znak)) {
            return 0;
        } else if ("~".equals(znak) || "+".equals(znak) ||"*".equals(znak) 
                   || "^".equals(znak) || "/".equals(znak) || "%".equals(znak)) {
            return 1;
        } else if (")".equals(znak)) {
            return 2;
        } else if(!"-".equals(znak) && znak.matches("[[[-]??[0-9]++[.][0-9]++]++ || [[-]??[.][0-9]++]++]++")) { 
            return 3;
        } else {
            return 4;
        }
    }

    
    public static double dzialanie(String znak, double liczbaA, double liczbaB) {
        switch (znak) {
                    case "~":
                        return liczbaA - liczbaB;
                    case "+":
                        return liczbaA + liczbaB;
                    case "*":
                        return liczbaA * liczbaB;
                    case "/":
                        return liczbaA / liczbaB;
                    case "^":
                        return Math.pow(liczbaA,liczbaB);
                    case "%":
                        return liczbaA % liczbaB;  
        }
        return 0;
    }
    public static boolean czyPoprawnyZapis(Kolejka wejscie) {
        String tmp;
        Kolejka kolejka = new Kolejka(wejscie);
        int nawiasyOtwierajace = 0;
        int nawiasyZamykajace = 0;
        int nawiasOtwierajacy = 0;
        int nawiasZamykajacy = 0;
        int ilosc = kolejka.liczbaElementow(), licznik = 0 ;
        
        while (licznik < ilosc) {
            tmp = kolejka.pobierzPierwszy().pobierzWartosc();
            kolejka.zdejmowanieElementu();
            if( rodzajOperatora(tmp) < 4) { //sprawdzanie czy 
                if (rodzajOperatora(tmp) == 0 || nawiasyOtwierajace > 0 ) {
                    if (rodzajOperatora(tmp) == 0) { // czy otwierajacy
                        nawiasyOtwierajace ++;
                        nawiasOtwierajacy = licznik;
                    } else if (rodzajOperatora(tmp) == 2) { // czy zamykajcy
                        nawiasyZamykajace ++;
                        nawiasZamykajacy = licznik;
                    }
                } else if (rodzajOperatora(tmp) == 2) {
                    return false;   
                }
            } else {
                return false;
            }
            licznik++;
        }
        
        if (nawiasyOtwierajace == nawiasyZamykajace) {
            if (nawiasOtwierajacy < nawiasZamykajacy || nawiasyOtwierajace == 0) {
                return true;
            }  
        } 
        return false;
    }   
}
