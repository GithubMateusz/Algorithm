
public class MacierzSasiedztwa extends GrafSkierowany{
    public int[][] macierz;
    public int krawedzie;
    public int liczbaWierzcholkow;
    
    public MacierzSasiedztwa(int liczbaWierzcholkow) {
        this.liczbaWierzcholkow = liczbaWierzcholkow;
        this.macierz = new int[liczbaWierzcholkow][liczbaWierzcholkow];
        this.krawedzie = 0;
        
        for(int i = 0; i < liczbaWierzcholkow; i++)
        {
            for(int j = 0; j < liczbaWierzcholkow; j++) {
                this.macierz[i][j] = 0;
            }
        }
    }
    
    @Override
    public void dodaj(int start, int koniec) {
        this.macierz[start][koniec] = 1;
        this.krawedzie ++;
    }
    
    @Override
    public String wszerz(int start) {
        Kolejka tmp = new Kolejka();
        tmp.dodaj(start);
        int S, odwiedzone = 1;
        String sukces = "" + start, znak;
        
        while (tmp.liczbaElementow() != 0) {
            S = tmp.pobierzPierwszy().pobierzWartosc();
            tmp.zdejmowanieElementu();
            if (odwiedzone == krawedzie) {  
                return start + ": " + sukces;
            } 
            for (int i = 0; i <liczbaWierzcholkow; i++) {
                znak ="" + i;
                if (macierz[S][i] == 1 && sukces.indexOf(znak) == -1) {
                    tmp.dodaj(i);
                    sukces += " -> " + i ;
                    odwiedzone++;
                } 
            }
        }
        return start + ": " + sukces;
    }
    
    public String wglab(int start) {
        Stos tmp = new Stos();
        tmp.dodaj(start);
        int S, odwiedzone = 1;
        String sukces = ""+ start, znak;
        
        while (tmp.iloscElementow() != 0) {
            S = tmp.pobierzPierwszy().pobierzWartosc();
            tmp.zdejmij();
            if (odwiedzone == krawedzie) {
                return start + ": " + sukces;
            }
            if (sukces.indexOf("" + S) == -1) {
                sukces += " -> " + S;
            }
            for (int i = 0; i <liczbaWierzcholkow; i++) {
                znak ="" + i;
                    if (macierz[S][i] == 1 && sukces.indexOf(znak) == -1) {
                        tmp.dodaj(i);
                        odwiedzone ++;
                }
            }
            if (tmp.iloscElementow() == 0 && S > 0) {
                tmp.dodaj(S-1);
            }
        }
        return start + ": " + sukces;
    }
    
    
    @Override
        public String toString() {
            String tmp = "";
                
            for (int i = 0; i < liczbaWierzcholkow; i++) {
                for (int j = 0; j < liczbaWierzcholkow; j++) {
                    tmp += macierz[i][j] + " ";
                }
                tmp += "\n";
            }
            return tmp;
    }    
}
