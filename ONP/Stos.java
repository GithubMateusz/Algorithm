public class Stos {
    Element pierwszy;
    
    Stos() {
        this.pierwszy = null;
    }
    
    public Element pobierzPierwszy(){
        return pierwszy;
    } 
    
    
    public void dodaj(String elem){
        Element tmp = new Element(elem, pierwszy);
        pierwszy = tmp;
    }
    
    public void zdejmij() {
        if (pierwszy != null) {
            pierwszy = pierwszy.pobierzNastepny();
        } else {
            System.out.println("Stos nie zawiera elemntow");
        }
    }
    
    public void wyswietl() {
        if (pierwszy != null) {
            Element tmp = pierwszy;
            while (tmp != null) {
                System.out.println(tmp.pobierzWartosc());
                tmp = tmp.pobierzNastepny();
            }
        } else {
            System.out.println("Stos nie zawiera elementow");
        }
    }
    
    public int iloscElementow() {
        int licznik = 0;
        if (pierwszy != null) {
            Element tmp = pierwszy;
            while (tmp != null) {
                licznik ++;
                tmp = tmp.pobierzNastepny();
            }
        }
        return licznik;
    }
}