
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nazwa="", typ = "";
        String wynik[] = null;
        int liczbaWierzcholkow, krawedzie;
        int od = 0;
        int start, koniec;
        FileReader plik = new FileReader("C:\\Users\\mat\\Documents\\java\\Praca3\\src\\plik.txt");
        try(BufferedReader wejscie = new BufferedReader(plik)) {
            String tekst = wejscie.readLine();
            StringTokenizer podzial = new StringTokenizer(tekst);
            System.out.println(typ);
            liczbaWierzcholkow = Integer.parseInt(podzial.nextToken());
            System.out.println(liczbaWierzcholkow);
            typ = podzial.nextToken();
            tekst = wejscie.readLine();
            krawedzie = Integer.parseInt(tekst);
            if ("m".equals(typ)) {
                MacierzSasiedztwa graf = new MacierzSasiedztwa(liczbaWierzcholkow);
                tekst = wejscie.readLine();
                do {
                    podzial = new StringTokenizer(tekst);
                    start = Integer.parseInt(podzial.nextToken());
                    koniec = Integer.parseInt(podzial.nextToken());
                    graf.dodaj(start, koniec);
                    tekst = wejscie.readLine();
                } while(tekst != null);   
            System.out.println(graf.toString());
            System.out.println(graf.wszerz(od));
            System.out.println(graf.wglab(od));
            
            } else if ("s".equals(typ)) {
                ListaSasiedztwa graf = new ListaSasiedztwa(liczbaWierzcholkow);
                tekst = wejscie.readLine();
                do {
                    podzial = new StringTokenizer(tekst);
                    start = Integer.parseInt(podzial.nextToken());
                    koniec = Integer.parseInt(podzial.nextToken());
                    graf.dodaj(start, koniec);
                    tekst = wejscie.readLine(); 
                } while(tekst != null);    
            System.out.println(graf.toString());
            System.out.println(graf.wszerz(od));
            System.out.println(graf.wglab(od));
            }  
                
        }
           
        
    }
    
}
