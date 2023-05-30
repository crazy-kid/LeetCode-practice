import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class mid_648 {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";

        String[] words = sentence.split(" ");
        HashSet<String> dictSet = new HashSet<String>();
        for (String root : dictionary) {
            dictSet.add(root);
        }
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < words[k].length(); i++) {
                if (dictSet.contains(words[k].subSequence(0, i + 1))) {
                    words[k] = words[k].substring(0, i + 1);
                    break;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            ans.append(words[i] + " ");
        }
        ans.append(words[words.length - 1]);
        System.out.println(ans.toString());
    }
}
