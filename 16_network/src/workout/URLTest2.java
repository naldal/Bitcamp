package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.liebli.com/goods/goods_list.php?cateCd=001002");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String keyword = "18K";
		String keyword2 = "18k";
		String line=null; 
		int cnt=1;
		
		while((line=br.readLine())!=null) {
			if(line.contains(keyword)||line.contains(keyword2)) {
				System.out.println(line);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
