//This is the main class, where the console will be called to interact with the user and show the progress

import java.util.List;


public class Main {
    public static void main(String[] args){
        try {
            Console console = new Console();
            console.insertURL();
            console.getHTMLfromWeb();
            console.analyzeAllTags();
            console.createPosibleMatchesLists();
            List<String> finalPosibleList = console.mergeMatchesLists();
            List<String> finalList = console.finalFilter(finalPosibleList);
            print(finalList);
        }
        catch(Exception e){
            System.out.println("Invalid URL");
            main(new String[] {"args"});
        }
    }

private static void print(List<String> finalList){
    for (String element: finalList) {
        System.out.printf("Phone Number: "+element);
    }
}

}
