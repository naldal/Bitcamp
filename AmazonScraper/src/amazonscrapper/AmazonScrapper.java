package amazonscrapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonScrapper {

    private final String path;
    private final String url;
    
    public static void main(String[] args) throws IOException {
	    final String PATH = "/Users/cec77/Desktop/";
	    final String URL  = "https://www.amazon.com/books-used-books-textbooks/b?ie=UTF8&node=283155";
	    
	    AmazonScrapper as = new AmazonScrapper(PATH, URL);
	    as.action();
    }

    public AmazonScrapper(String path, String url) {
        this.path = path;
        this.url  = url;
    }

    public void action() throws IOException {
        PrintWriter pw = null;
        Document  page = Jsoup.connect(url).userAgent("Jsoup Scrapper").get();

        String     bookSelector = "span.a-truncate.a-size-base";
        Elements   bookElements = page.select(bookSelector);
        List<String> bookTitles = new ArrayList<>(bookElements.size());

        bookElements.forEach(e -> bookTitles.add(e.text()));

        int cnt = 1;
        for(int i = 0; i < bookTitles.size(); i++) {
            if(i % 2 == 0) {
                if(pw != null) pw.close();
                pw = initPrintWriter(path+"/"+cnt+"번째 파일.txt");
                cnt++;
            }
            
            pw.println(bookTitles.get(i));
        }
    }

    private PrintWriter initPrintWriter(String path) throws IOException {
        File file = new File(path);

        if(!file.exists())
            file.createNewFile();

        return new PrintWriter(new FileWriter(file));
    }
}
