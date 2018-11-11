//Console class

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private HTMLParser parser;
    private NumberFinder finder = new NumberFinder();
    private Elements links;
    private Elements spans;
    private Elements pTags;
    private Elements h1s;
    private Elements h2s;
    private Elements h3s;
    private Elements h4s;
    private List<List<String>> posibleMatches = new ArrayList<>();

    //Insert the URL where the phone number will be looked
    public void insertURL(){
        System.out.println("Welcome, please add the Link to the website to find Telf-numbers");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        parser = new HTMLParser(url);
    }

    public void getHTMLfromWeb() throws IOException{
        parser.getHTMLfromWeb();
    }

    public void analyzeAllTags(){
        links = parser.getElements("a");
        spans = parser.getElements("span");
        pTags = parser.getElements("p");
        h1s = parser.getElements("h1");
        h2s = parser.getElements("h2");
        h3s = parser.getElements("h3");
        h4s = parser.getElements("h4");
    }

    //Shows how the program look for phone numbers in every type of tags from the HTML where it could be
    public void createPosibleMatchesLists(){
        System.out.println("Links=========================================================");
        List<String> linkmat = finder.findNumberInElementsList(links);
        posibleMatches.add(linkmat);
        System.out.println("spans=========================================================");
        List<String> spansmat = finder.findNumberInElementsList(spans);
        posibleMatches.add(spansmat);
        System.out.println("Ptags=========================================================");
        List<String> pmat = finder.findNumberInElementsList(pTags);
        posibleMatches.add(pmat);
        System.out.println("H1============================================================");
        List<String> h1mat = finder.findNumberInElementsList(h1s);
        posibleMatches.add(h1mat);
        System.out.println("H2============================================================");
        List<String> h2mat =  finder.findNumberInElementsList(h2s);
        posibleMatches.add(h2mat);
        System.out.println("H3============================================================");
        List<String> h3mat = finder.findNumberInElementsList(h3s);
        posibleMatches.add(h3mat);
        System.out.println("H4============================================================");
        List<String> h4mat =  finder.findNumberInElementsList(h4s);
        posibleMatches.add(h4mat);
    }

    public List<String> mergeMatchesLists(){
        MatchesListMerger merger = new MatchesListMerger(posibleMatches);
        List<String> mergedList = merger.merge();

        return merger.removeDuplicates(mergedList);
    }

    public List<String> finalFilter(List<String> finalPosibleList){
        FinalFilter filter = new FinalFilter(finalPosibleList);

        return filter.subFilter();
    }



}
