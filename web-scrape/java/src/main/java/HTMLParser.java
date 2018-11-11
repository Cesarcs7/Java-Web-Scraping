import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTMLParser {
    private String url;
    private Document HTMLdocument;

    public HTMLParser(String url) {
        this.url = url;
    }

    public void getHTMLfromWeb() throws IOException {
            HTMLdocument = Jsoup.connect(url).get();
    }

    public Elements getElements(String tag){
        Elements matches = HTMLdocument.getElementsByTag(tag);
        return matches;
    }
}
