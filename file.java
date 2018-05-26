import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;

public class file{
	public static void main(String[] args)throws IOException{
	
		MailProjectClass fl = new MailProjectClass();
		Session sn= fl.init(args[0],args[1]);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = null;
		String line = "";
		
		while((line = br.readLine()) != null){
			st = new StringTokenizer(line);
			try{
			System.out.println(line);
			fl.sendMail(sn,(String)st.nextElement());
			
			}catch(Exception e){
				System.out.println("not send at "+line);
			}	
		}
	}
}
