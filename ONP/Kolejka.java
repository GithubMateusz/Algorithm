
public class Kolejka {
    Element pierwszy;
    Element ostatni;
    
    public Kolejka() {
        this.pierwszy = this.ostatni = null;
    }
    
    public Kolejka(Kolejka kopia) {
        this.pierwszy = kopia.pierwszy;
        this.ostatni = kopia.ostatni;
    }
    
    public Element pobierzPierwszy() {
        return pierwszy;
    }

    public Element pobierzOstatni() {
        return ostatni;
    }

    public void zmienOstatni(Element element) {
        ostatni = element;
    }

    public void zmienPierwszy(Element element) {
        pierwszy = element;
    }
    
    public void dodaj(String elem) {
        Element tmp = new Element(elem);
        if (pierwszy == null){
            pierwszy = ostatni = tmp;
        } else {
            ostatni.zmienNastepny(tmp);
            ostatni = tmp;
        }
    }

    public void zdejmowanieElementu(){
        if (pierwszy != null) {
            if(pierwszy.pobierzNastepny() == null) {
                ostatni = null;
            }
            pierwszy = pierwszy.pobierzNastepny();
        } else { 
            System.out.println("Kolejka nie zawiera elementów");
        }
    }
    
    public void wyswietl() {
        if (pierwszy != null) {
            Element tmp = pierwszy;
            while (tmp != null) {
                System.out.println(tmp.pobierzWartosc() + " " );
                tmp = tmp.pobierzNastepny();
            }
        } else { 
            System.out.println("Kolejka nie zawiera elementów");
        }
    }
    
    public int liczbaElementow() {
        int ilosc = 0;
        if (pierwszy != null) {
            Element tmp = pierwszy;
            while (tmp != null) {
                ilosc ++;
                tmp = tmp.pobierzNastepny();
            }
        }
        return ilosc;
    }
}