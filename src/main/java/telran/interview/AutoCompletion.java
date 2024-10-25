package telran.interview;

import java.util.TreeSet;

public class AutoCompletion {
    // TODO
    private final TreeSet<String> wordsTreeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return wordsTreeSet.add(word);
    }

    public String[] getVariants(String prefix) {
        return wordsTreeSet.subSet(prefix, prefix + Character.MAX_VALUE).toArray(new String[0]);
    }
}
