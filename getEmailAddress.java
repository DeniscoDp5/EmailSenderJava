/**
The scope of the class is to enter in a url and look for e-mail adresses.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

public class getEmailAddress{
	public static void main(String[] args) throws IOException{
	CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = br.readLine()) != null){
		
			
			try{
			URL url = new URL(line);
			URLConnection con = url.openConnection();
        	InputStream is =con.getInputStream();
        	BufferedReader br2 = new BufferedReader(new InputStreamReader(is));
        	String line2 = "";
        	while((line2 = br2.readLine()) != null){			
				Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(line2);
    			while (m.find()) {
        			System.out.println(m.group());
    			}
			}
			}catch(Exception e){}
		}
		
	}
}
