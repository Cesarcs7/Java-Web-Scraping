import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    //regex patterns to look for in the lists with HTML tags content
    private Pattern patternOne = Pattern.compile("\\d+\\s\\d+\\s\\d+");
    private Pattern patternTwo = Pattern.compile("\\d+\\s\\d+");
    private Pattern patternThree = Pattern.compile("\\d+-\\d+");
    private Pattern patternFour = Pattern.compile("\\d+\\s-\\s\\d+");



    public List<String> findNumberInElementsList(Elements list){
        //try all the regex patterns, one by one
        List<String> patterOneMatches = tryPatternOneInElementsList(list);
        List<String> patternTwoMatches = tryPatternTwoInElementList(list);
        List<String> patternThreeMatches = tryPatternThreeInElementList(list);
        List<String> patternFourMatches = tryPatternFourInElementList(list);
        //merge all found results and return them in a list
        List<String> mergedMatches = mergeAllMatches(patterOneMatches, patternTwoMatches, patternThreeMatches, patternFourMatches);

        List<String> completeMatches = removeDuplicates(mergedMatches);
        System.out.println(" TOTAL = "+completeMatches.toString());
        return completeMatches;
    }

    private List<String> tryPatternOneInElementsList(Elements list){
        List<String> patterOneMatches = new ArrayList<String>();
        for (Element element:list) {
            Matcher matcher = patternOne.matcher(element.text());
            if(matcher.find()){
                patterOneMatches.add(element.text());
                System.out.println("found with pattern one: > "+ element.text());
            }
        }
        return patterOneMatches;
    }

    private List<String> tryPatternTwoInElementList(Elements list){
        List<String> patternTwoMatches= new ArrayList<String>();
        for (Element element:list) {
            Matcher matcher = patternTwo.matcher(element.text());
            if(matcher.find()){
                patternTwoMatches.add(element.text());
                System.out.println("found with pattern two: >> "+ element.text());
            }
        }
        return patternTwoMatches;
    }

    private List<String> tryPatternThreeInElementList(Elements list){
        List<String> patternThreeMatches= new ArrayList<String>();
        for (Element element:list) {
            Matcher matcher = patternThree.matcher(element.text());
            if(matcher.find()){
                patternThreeMatches.add(element.text());
                System.out.println("found with pattern three: >>> "+ element.text());
            }
        }
        return patternThreeMatches;
    }

    private List<String> tryPatternFourInElementList(Elements list){
        List<String> patternFourMatches= new ArrayList<String>();
        for (Element element:list) {
            Matcher matcher = patternFour.matcher(element.text());
            if(matcher.find()){
                patternFourMatches.add(element.text());
                System.out.println("found with pattern four: >>>> "+ element.text());
            }
        }
        return patternFourMatches;
    }
    //Merge all the matches in one list and return it
    private List<String> mergeAllMatches(List<String> matchesListOne, List<String> matchesListTwo, List<String> matchesListThree, List<String> matchesListFour){
        List<String> completeMatches = new ArrayList<>();
        completeMatches.addAll(matchesListOne);
        completeMatches.addAll(matchesListTwo);
        completeMatches.addAll(matchesListThree);
        completeMatches.addAll(matchesListFour);
        return completeMatches;
    }
    //Remove Duplicates in the list
    private List<String> removeDuplicates(List<String> mergedMatches){
        Set<String> hs = new HashSet<>();
        List<String> completeMatches = new ArrayList<>();
        hs.addAll(mergedMatches);
        completeMatches.addAll(hs);

        return completeMatches;
    }

}
