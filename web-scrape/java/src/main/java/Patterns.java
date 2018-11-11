import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Patterns {
    private Pattern patternOne = Pattern.compile("\\d+\\s\\d+\\s\\d+");
    private Pattern patternTwo = Pattern.compile("\\d+\\s\\d+");
    private Pattern patternThree = Pattern.compile("\\d+-\\d+");
    private Pattern patternFour = Pattern.compile("\\d+\\s-\\s\\d+");

    public List<Pattern> buildPatternList() {
        List<Pattern> patternList = new ArrayList<Pattern>();
        patternList.add(patternOne);
        patternList.add(patternTwo);
        patternList.add(patternThree);
        patternList.add(patternFour);

        return patternList;
    }
}
