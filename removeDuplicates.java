import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class removeDuplicates {
	public static void main(String[] args) throws IOException{
		Vector<String> v = new Vector<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = br.readLine()) != null){
			boolean bool = true;
			for(int i = 0; i< v.size() && bool == true; i++){
				if((v.get(i)).equals(line)){
					bool = false;
				}
			}
			if(bool == true){
				System.out.println(line);
				v.add(line);
			}
		}
	}
}
