import java.util.LinkedHashSet;
import java.util.Set;

public class  RemoveDuplicateWords {
    public static void main(String[] args) {
        String input = "abc abc ab abc ab acs acs";
        String result = removeDuplicateWords(input);
        System.out.println(result);
    }

    public static String removeDuplicateWords(String input) {

        Set<String> wordsSet = new LinkedHashSet<>();


        String[] words = input.split(" ");


        for (String word : words) {
            wordsSet.add(word);
        }


        return String.join(" ", wordsSet);
    }
}