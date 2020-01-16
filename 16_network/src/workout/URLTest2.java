package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.liebli.com/goods/goods_list.php?cateCd=001002");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

		String line=null; 
		String txt=null;
		
		while((line=br.readLine())!=null) {
			txt += line;
		}
		txt += " ";
		
		System.out.println();
		
		
		
	}
}
