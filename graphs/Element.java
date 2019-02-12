public class Element {
    private final int elem;
    private Element nastepny;
    
    public Element(int elem){
        this.elem = elem;
        this.nastepny = null;
    }
    
    public Element(int elem, Element nastepny){
        this.nastepny = nastepny;
        this.elem = elem;
    }
    
    public void zmienNastepny(Element element){
        nastepny = element;
    }

    public Element pobierzNastepny(){
        return nastepny;
    }

    public int pobierzWartosc(){
        return elem;
    }
}