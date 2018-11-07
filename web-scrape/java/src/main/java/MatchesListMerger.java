import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchesListMerger {
    private List<List<String>> listsToMerge;

    public MatchesListMerger(List<List<String>> listsToMerge) {
        this.listsToMerge = listsToMerge;
    }

    public List<String> merge(){
        List<String> mergedList = new ArrayList<>();
        for (List<String> list : listsToMerge){
            mergedList.addAll(list);
        }
        return mergedList;
    }

    public List<String> removeDuplicates(List<String> list){
        Set<String> hs = new HashSet<>();
        List<String> mergedList = new ArrayList<>();
        hs.addAll(list);
        mergedList.addAll(hs);

        return mergedList;
    }
}
