import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;


public class googleWebSearch{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null){
		
			Document doc = Jsoup.connect("https://www.google.it/search?q="+ line.replace(" ","+")+"+contatti+-booking+-tripadvisor+-expedia+-facebook+-paginegialle+-hotel.info").get();
			try {
				Element el1 = doc.select("div.search div div").first();
				Element el2 = doc.select("div.search div div div:th-child(2)").first();
				Element el3 = doc.select("div.search div div div:th-child(3)").first();
				Element el4 = doc.select("div.search div div div:th-child(4)").first();

				System.out.println(el1.select("a").first().attr("href"));
				System.out.println(el2.select("a").first().attr("href"));
				System.out.println(el3.select("a").first().attr("href"));
				System.out.println(el4.select("a").first().attr("href"));
			}catch(Exception e) {

			}
						
			//https://www.google.it/search?client=ubuntu&channel=fs&q=ricerca&ie=utf-8&oe=utf-8&gfe_rd=cr&dcr=0&ei=pPYNWuCBNc3BXsfZhOgN
			//https://www.google.com/search?q=Hotel+%26+Residence+Holiday+contatti+-booking+-tripadvisor+-expedia+-facebook+-paginegialle+-hotel.info
		}
	}
	
}
