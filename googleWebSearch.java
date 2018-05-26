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
		
			Document doc = Jsoup.connect("https://www.google.it/search?q="+ line.replace(" ","+")+"%20-paginegialle").get();
			Element el = doc.select("div.g").first();
			System.out.println(el.select("a").first().attr("href"));
			
			
			
			//https://www.google.it/search?client=ubuntu&channel=fs&q=ricerca&ie=utf-8&oe=utf-8&gfe_rd=cr&dcr=0&ei=pPYNWuCBNc3BXsfZhOgN
		}
	}
	
}
