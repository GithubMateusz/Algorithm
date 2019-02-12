public class ONP {
    public static Kolejka onp(Kolejka wejscie) {
        
        Stos stos = new Stos();
        Kolejka kolejka = new Kolejka();
        String tmp;
        String tmp2;
        int iloscElementowStosu;
        
        while (wejscie.liczbaElementow() > 0) {
            tmp = wejscie.pobierzPierwszy().pobierzWartosc();
            wejscie.zdejmowanieElementu();
            switch (Funkcje.rodzajOperatora(tmp)) {
                case 0: // jestli to nawias otwierajacy
                    stos.dodaj(tmp);
                    break;
                case 1: // jesli to operator
                    iloscElementowStosu = stos.iloscElementow();
                    for (int i = 0; i < iloscElementowStosu; i++) {
                        tmp2 = stos.pobierzPierwszy().pobierzWartosc();
                        if (Funkcje.priorytety(tmp) > Funkcje.priorytety(tmp2)) {
                            iloscElementowStosu = 0;
                        } else { 
                            stos.zdejmij();
                            kolejka.dodaj(tmp2);
                        }
                    }
                    stos.dodaj(tmp);
                    break;
                case 2: // jestli to nawias zamykajacy
                    iloscElementowStosu = stos.iloscElementow();
                    for (int i = 0; i < iloscElementowStosu; i++){
                        tmp2 = stos.pobierzPierwszy().pobierzWartosc();
                        stos.zdejmij();
                        if (!"(".equals(tmp2)) {
                            kolejka.dodaj(tmp2);
                        } else {
                            iloscElementowStosu = 0;
                        }
                    }   
                    break;
                case 3: //jesli liczba
                    kolejka.dodaj(tmp);
                    break;
                default:
                    break;
            }
            while(wejscie.liczbaElementow() == 0 && stos.iloscElementow() > 0 ) {
                tmp2 = stos.pobierzPierwszy().pobierzWartosc();
                stos.zdejmij();
                kolejka.dodaj(tmp2);
            }
        }
        return kolejka;
    }
    
    public static double wynik(Kolejka wejscie) {
        Stos roboczy = new Stos();
        String tmp;
        double a;
        double b;
        double wynik = 0;
        
        while (wejscie.liczbaElementow() > 0) {
            tmp = wejscie.pobierzPierwszy().pobierzWartosc();
            wejscie.zdejmowanieElementu();
            if (Funkcje.rodzajOperatora(tmp) == 3 ) {
                roboczy.dodaj(tmp);
            } else {
                a = Double.parseDouble(roboczy.pobierzPierwszy().pobierzWartosc());
                roboczy.zdejmij();
                b = Double.parseDouble(roboczy.pobierzPierwszy().pobierzWartosc());
                roboczy.zdejmij();
                wynik = Funkcje.dzialanie(tmp, b, a);
                tmp = "" + wynik;
                roboczy.dodaj(tmp);
            }
        }
        return wynik;
    }
}
