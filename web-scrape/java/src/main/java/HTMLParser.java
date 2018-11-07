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

    public Elements getAllLinkElements() {
        Elements links = HTMLdocument.getElementsByTag("a");
       return links;
    }

    public Elements getAllSpanElements(){
        Elements spans = HTMLdocument.getElementsByTag("span");
       return spans;
    }

    public Elements getAllPElements(){
        Elements pTags = HTMLdocument.getElementsByTag("p");
        return pTags;
    }

    public Elements getAllH1Elements(){
        Elements h1 = HTMLdocument.getElementsByTag("h1");
        return h1;
    }

    public Elements getAllH2Elements(){
        Elements h2 = HTMLdocument.getElementsByTag("h2");
        return h2;
    }

    public Elements getAllH3Elements(){
        Elements h3 = HTMLdocument.getElementsByTag("h3");
        return h3;
    }

    public Elements getAllH4Elements(){
        Elements h4 = HTMLdocument.getElementsByTag("h4");
        return h4;
    }


}
