
import java.util.*;


public class ListaSasiedztwa extends GrafSkierowany {
    
    private int krawedzie;
    private int liczbaWierzcholkow;
    private List<Integer>[] lista;
    
    @SuppressWarnings("unchecked")
    public ListaSasiedztwa(int liczbaWierzcholkow) {
        this.liczbaWierzcholkow = liczbaWierzcholkow;
        this.krawedzie = 0;
       
        lista = (List<Integer>[]) new List[liczbaWierzcholkow];
        for (int i = 0; i < liczbaWierzcholkow; i++) {
            lista[i] = new ArrayList<Integer>();
        }
    }
    @Override
    public void dodaj(int start, int koniec) {
        lista[start].add(koniec);
        krawedzie++;
    }
    
      
    @Override
    public String wszerz(int start) {
        Kolejka tmp = new Kolejka();
        tmp.dodaj(start);
        int S, krawedz, odwiedzone = 0;
        String sukces = start + " ", znak;
        
        while (tmp.liczbaElementow() != 0) {
            S = tmp.pobierzPierwszy().pobierzWartosc();
            tmp.zdejmowanieElementu();
            if (odwiedzone == krawedzie) {
                return start + ": " + sukces;
            } 
            for (int i = 0; i <lista[S].size(); i++) {
                krawedz = lista[S].get(i);
                znak ="" + krawedz;
                if (sukces.indexOf(znak) == -1) {
                    tmp.dodaj(krawedz);
                    sukces += krawedz + " ";
                    odwiedzone++;
                } 
            }
        }
        return start + ": " + sukces;
    }
    
    @Override
    public String wglab(int start) {
        Stos tmp = new Stos();
        tmp.dodaj(start);
        int S, krawedz, odwiedzone = 0;
        String sukces = "" , znak;
        
        while (tmp.iloscElementow() != 0) {
            S = tmp.pobierzPierwszy().pobierzWartosc();
            tmp.zdejmij();
            if (odwiedzone == krawedzie) {
                return start + ": " + sukces;
            }
            if (sukces.indexOf("" + S) == -1) {
                sukces += " -> " + S;
            }
            for (int i = 0; i <lista[S].size(); i++) {
                krawedz = lista[S].get(i);
                znak ="" + krawedz;
                if (sukces.indexOf(znak) == -1) {
                    tmp.dodaj(krawedz);
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
                tmp += i + ": ";
                for (int j = 0; j < lista[i].size(); j++) {
                    tmp += lista[i].get(j) + " ";
                }
                tmp += "\n";
            }
            return tmp;
    }
}
