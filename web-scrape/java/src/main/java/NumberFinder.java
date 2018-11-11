import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    private Patterns patterns = new Patterns();
    private List<Pattern> patternList = patterns.buildPatternList();


    public List<String> findNumberInElementsList(Elements list){
        //try all the regex patterns, one by one
        List<String> patterOneMatches = tryPatternInElementsList(list, 0);
        List<String> patternTwoMatches = tryPatternInElementsList(list, 1);
        List<String> patternThreeMatches = tryPatternInElementsList(list, 2);
        List<String> patternFourMatches = tryPatternInElementsList(list, 3);
        //merge all found results and return them in a list
        List<String> mergedMatches = mergeAllMatches(patterOneMatches, patternTwoMatches, patternThreeMatches, patternFourMatches);

        List<String> completeMatches = removeDuplicates(mergedMatches);
        System.out.println(" TOTAL = "+completeMatches.toString());
        return completeMatches;
    }

    private List<String>  tryPatternInElementsList(Elements list, int index){
        List<String> patternMatches = new ArrayList<String>();
        for (Element element:list) {
            Matcher matcher = patternList.get(index).matcher(element.text());
            if(matcher.find()){
                patternMatches.add(element.text());
                System.out.println("found with pattern "+(index+1)+" : >> "+ element.text());
            }
        }
        return patternMatches;
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
