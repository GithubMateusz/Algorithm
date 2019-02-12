public class Element {
    private final String elem;
    private Element nastepny;
    
    public Element(String elem){
        this.elem = elem;
        this.nastepny = null;
    }
    
    public Element(String elem, Element nastepny){
        this.nastepny = nastepny;
        this.elem = elem;
    }
    
    public void zmienNastepny(Element element){
        nastepny = element;
    }

    public Element pobierzNastepny(){
        return nastepny;
    }

    public String pobierzWartosc(){
        return elem;
    }
}