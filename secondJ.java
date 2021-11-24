/**
 * INSTRUCTIONS
 * 
 * Modify the constants LOCATION and 
 */
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.io.File;

//https://www.paginegialle.it/ricerca/negozi/Udine/p-2?mr=50
//https://www.paginegialle.it/ricerca/negozio%20abbigliamento/Udine/p-3?mr=50
//https://www.paginegialle.it/ricerca/abbigliamento/Udine
//https://www.paginegialle.it/ricerca/meccanica/Udine/p-2?mr=50
public class secondJ{

	public static final String LOCATION = "UD";
	public static final String SECTOR = "Informatica";

	public static void main(String[] args) throws IOException{
	int j=1;
	for(int i = 1; i< 50 ;i++){
		Document doc = Jsoup.connect("https://www.paginegialle.it/ricerca/" + SECTOR + "/" + LOCATION + "/p-" + i + "?mr=50").get(); //punto 1
		
		Elements dovs = doc.select("section.list-element");
	//	System.out.println("!!!!!!!!!!!!!!!!!!!!" + i + "!!!!!!!!!!!!!!!!!!");
		for(Element el : dovs){
			try{
			String nome = el.select("h2.list-element__title a").first().text();
			String web = "";
			//web = el.select("a[title^=sito]").first().attr("href");
			System.out.println(nome);
			j++;
			} 
			catch(Exception e) {}
			
		}
		
		}//end For
		
	}
}
