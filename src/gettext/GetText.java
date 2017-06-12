
package gettext;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import net.sf.json.JSON;
import org.jsoup.select.Elements;


public class GetText {
    public static void main(String[] args) throws IOException {
    
       PrintWriter out = new PrintWriter("htmlcorriere.txt");  //creazione file
       //prendere html da sito
       URL url = new URL("http://www.corriere.it/sport/motomondiale/notizie/motogp-mugello-rossi-ci-prova-non-facile-ma-voglio-esserci-2f83b3cc-45ee-11e7-9b23-80b3b0be0a6c.shtml");
       Document doc = Jsoup.parse(url, 3*1000);
       Elements title= doc.getElementsByClass("chapter-paragraph");
       String s = title.toString(); //converte l'oggetto title in stringa
       s= Jsoup.parse(s).text(); //rimozione caratteri html
       out.println(s);  //salvataggio testo pagina nel file
       out.close();
        System.out.println("l'articolo è stato salvato corretamente nel file di testo");
       
        
     Scanner sc=new Scanner(System.in); //creazione oggetto scanner
       System.out.println("inserisci parola da ricercare ");
       String ric= sc.nextLine(); //lettura stringa da ricercare
       
       PrintWriter outt2 = new PrintWriter("htmlcorrierepost.txt");  //creazione file post
       
       //inizio ricerca parola nel file
       BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Sintecnos\\Documents\\NetBeansProjects\\GetText\\htmlcorriere.txt")); 
       String line;
        while((line = in.readLine()) != null) 
            {
              if(line.toUpperCase().contains(ric.toUpperCase())){
                System.out.println("trovata parola: " +ric);
                line=line.replaceAll(ric, "ciao");
                outt2.println(line);
            } else
                System.out.println("parola non trovata");
            }
            
            in.close();
       
        //fine ricerca parola
        
         //visualizzazione file
         BufferedReader br = new BufferedReader(new FileReader("htmlcorriere.txt"));  
//         for (String line; (line = br.readLine()) != null;) {
//            System.out.println(line); 
//         }
        out.close(); //chiusura file
     }

    private static void String(Element title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

