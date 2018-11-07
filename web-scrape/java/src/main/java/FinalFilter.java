import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalFilter {

    private List<String> finalPosibleList;
    private Pattern patternOne = Pattern.compile("(\\d{3,4}\\s(\\d{2,3}\\s)+\\d+)");
    private Pattern patternTwo = Pattern.compile("(\\d{2,4}\\s-\\s(\\d{2,3}\\s)+\\d+)");
    private Pattern patternThree = Pattern.compile("\\d{2,4}-(\\d{5,10})");
    private Pattern patternFour = Pattern.compile("\\d{3,4}\\s\\d{7,10}");

    public FinalFilter(List<String> finalPosibleList) {
        this.finalPosibleList = finalPosibleList;
    }

    public List<String> subFilter(){
        System.out.println("-----------------------------------------------------------\n" + "Filtering..." );
        List<String> finalList = new ArrayList<>();
        for (String element: finalPosibleList) {
            Matcher matcher = patternOne.matcher(element);
            if(matcher.find()){
                finalList.add(matcher.group(0));
                System.out.println("found with pattern one: > "+ matcher.group(0));
            }
        }
        for (String element: finalPosibleList) {
            Matcher matcher = patternTwo.matcher(element);
            if(matcher.find()){
                finalList.add(matcher.group(0));
                System.out.println("found with pattern two: >> "+ matcher.group(0));
            }
        }
        for (String element: finalPosibleList) {
            Matcher matcher = patternThree.matcher(element);
            if(matcher.find()){
                finalList.add(matcher.group(0));
                System.out.println("found with pattern three: >>> "+ matcher.group(0));
            }
        }
        for (String element: finalPosibleList) {
            Matcher matcher = patternFour.matcher(element);
            if(matcher.find()){
                finalList.add(matcher.group(0));
                System.out.println("found with pattern four: >>>> "+ matcher.group(0));
            }
        }
        System.out.println("-----------------------------------------------------------\n");
        return finalList;
    }


}
