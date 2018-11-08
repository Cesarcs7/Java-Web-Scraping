import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConsoleTest {
    private List<String> list = new ArrayList<>();
    private List<String> finalPosibleList = new ArrayList<>();

    @Test
    public void mergeMatchesLists() {
        Console console = new Console();
        List<String> mergedLists = console.mergeMatchesLists();
        assertEquals(list, mergedLists);
    }

    @Test
    public void finalFilter() {
        Console console = new Console();
        List<String> finalList = console.finalFilter(finalPosibleList);
        assertEquals(list, finalList);
    }
}